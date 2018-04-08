package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {
    getContactCreationForm();
    fillContactCreationForm("Svetlana", "Ivanova", "Ukraine", "111-11-11", "ivanova@localhost.com");
    editAdressbookEntry();
    submitContactCreationForm();
    returnToHomePage();
  }

}
