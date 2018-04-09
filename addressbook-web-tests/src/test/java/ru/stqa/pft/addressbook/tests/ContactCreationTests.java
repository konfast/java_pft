package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {
    app.getContactHelper().getContactCreationForm();
    app.getContactHelper().fillContactCreationForm("Svetlana", "Ivanova", "Ukraine", "111-11-11", "ivanova@localhost.com");
    app.getContactHelper().editAdressbookEntry();
    app.getContactHelper().submitContactCreationForm();
    app.getContactHelper().returnToHomePage();
  }

}
