package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactCreationForm() {
    click(By.name("submit"));
  }

  public void editAdressbookEntry() {
    click(By.name("theform"));
  }

  public void fillContactCreationForm(String user_firstname, String user_lastname, String user_address, String user_phone, String user_email) {
    click(By.name("theform"));
    type(By.name("firstname"),user_firstname);
    type(By.name("lastname"),user_lastname);
    type(By.name("address"),user_address);
    type(By.name("home"),user_phone);
    type(By.name("email"),user_email);
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
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));//дописать сюда как его инициировать
  }

  public void summitContactModification() {
    click(By.name("update"));
  }
}
