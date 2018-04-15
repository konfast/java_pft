package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {
    app.getContactHelper().createContact(new ContactData("Svetlana", "Ivanova", "Ukraine", "111-11-11", "ivanova@localhost.com", "test1"), true);
    app.getNavigationHelper().returnToHomePage();
  }
}
