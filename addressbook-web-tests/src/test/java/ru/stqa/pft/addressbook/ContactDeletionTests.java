package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void Delete() {

    wd.findElement(By.name("selected[]")).click();
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }
}
