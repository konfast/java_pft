package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {
    app.getContactCreationForm();
    app.fillContactCreationForm("Svetlana", "Ivanova", "Ukraine", "111-11-11", "ivanova@localhost.com");
    app.editAdressbookEntry();
    app.submitContactCreationForm();
    app.returnToHomePage();
  }

}
