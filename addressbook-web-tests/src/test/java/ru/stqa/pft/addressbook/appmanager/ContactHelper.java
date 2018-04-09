package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper {
  private FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void returnToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void submitContactCreationForm() {
    wd.findElement(By.name("submit")).click();
  }

  public void editAdressbookEntry() {
    wd.findElement(By.name("theform")).click();
  }

  public void fillContactCreationForm(String user_firstname, String user_lastname, String user_address, String user_phone, String user_email) {
    wd.findElement(By.name("theform")).click();
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(user_firstname);
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(user_lastname);
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(user_address);
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(user_phone);
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(user_email);
    //wd.findElement(By.name("theform")).click();
  }

  public void getContactCreationForm() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void confirmContactDeletion() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void selectContact() {
    wd.findElement(By.name("selected[]")).click();
  }
}
