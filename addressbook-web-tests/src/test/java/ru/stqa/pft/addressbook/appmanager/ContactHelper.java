package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

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
    type(By.name("firstname"),contactData.getFirst_name());
    type(By.name("lastname"),contactData.getLast_name());
    type(By.name("address"),contactData.getUser_address());
    type(By.name("home"),contactData.getUser_phone());
    type(By.name("email"),contactData.getUser_email());

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

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void summitContactModification() {
    click(By.name("update"));
  }

  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact, boolean creation) {
    getContactCreationForm();
    fillContactCreationForm(contact, creation);
    editAdressbookEntry();
    submitContactCreationForm();


  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
