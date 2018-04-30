package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    type(By.name("address"), contactData.getUser_address());
    type(By.name("home"), contactData.getUser_phone());
    type(By.name("email"), contactData.getUser_email());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td[8]/a/img")).get(index).click(); //нужно реализовать по id

  }

  public void initContactModificationById(int id) {
    wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr/td/input[@value='"+id+"']/../../td[8]/a/img")).click();
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
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactCreationForm(contact, false);
    summitContactModification();
  }

  public void delete(int index) {
    selectContact(index);
    confirmContactDeletion();
    choiceConfirmation();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    confirmContactDeletion();
    choiceConfirmation();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement element : elements) {

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      List<WebElement> cells = element.findElements(By.tagName("td"));


      String last_name = cells.get(1).getText();
      String first_name = cells.get(2).getText();

      contacts.add(new ContactData().withId(id).withFirst_name(first_name).withLast_name(last_name));

    }
    return contacts;
  }

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement element : elements) {

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      List<WebElement> cells = element.findElements(By.tagName("td"));


      String last_name = cells.get(1).getText();
      String first_name = cells.get(2).getText();

      contacts.add(new ContactData().withId(id).withFirst_name(first_name).withLast_name(last_name));

    }
    return contacts;
  }

}
