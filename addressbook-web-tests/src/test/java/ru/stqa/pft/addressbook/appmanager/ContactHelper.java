package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreationForm() {
    click(By.name("submit"));
  }

  public void editAdressbookEntry() {
    click(By.name("theform"));
  }

  public void fillContactCreationForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirst_name());
    type(By.name("lastname"), contactData.getLast_name());
    attach(By.name("photo"), contactData.getPhoto());
    type(By.name("address"), contactData.getUser_address());
    type(By.name("home"), contactData.getUser_phone());
    type(By.name("email"), contactData.getUser_email());

    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void getContactCreationForm() {
    click(By.linkText("add new"));
  }

  public void confirmContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr/td/input[@value='" + id + "']/../../td[8]/a/img")).click();

    /*WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();*/

    //третий способ
    //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();

    //четвертый способ
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();

    //пятый способ
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void summitContactModification() {
    click(By.name("update"));
  }

  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact, boolean creation) {
    getContactCreationForm();
    fillContactCreationForm(contact, creation);
    editAdressbookEntry();
    submitContactCreationForm();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactCreationForm(contact, false);
    summitContactModification();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    confirmContactDeletion();
    choiceConfirmation();
    contactCache = null;
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement element : elements) {

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      List<WebElement> cells = element.findElements(By.tagName("td"));


      String last_name = cells.get(1).getText();
      String first_name = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();

      contactCache.add(new ContactData().withId(id).withFirst_name(first_name).withLast_name(last_name).withUser_address(address).
              withAllEmails(allEmails).withAllPhones(allPhones));

    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirst_name(firstname).withLast_name(lastname).withUser_address(address).
            withUser_phone(home).withMobilePhone(mobile).withWorkPhone(work).withUser_email(email).withEmail2(email2).withEmail3(email3);

  }

  public void addInSelectGroup(int id,int index) {
    selectContactById(id);
    Select dropdown =  new Select(wd.findElement(By.xpath("//select[@name='to_group']")));
    dropdown.selectByValue(Integer.toString(index));
    wd.findElement(By.xpath("//input[@name='add']")).click();
  }


  public void deleteFromSelectGroup(int id, int index) {
    Select dropdown = new Select(wd.findElement(By.xpath("//select[@name='group']")));
    dropdown.selectByValue(Integer.toString(index));
    selectContactById(id);
    wd.findElement(By.xpath("//input[@name='remove']")).click();

  }
}


