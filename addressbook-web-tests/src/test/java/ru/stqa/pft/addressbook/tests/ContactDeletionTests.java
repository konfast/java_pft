package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void Delete() {
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Svetlana", "Ivanova", "Ukraine", "111-11-11", "ivanova@localhost.com", "test1"), true);
      app.getNavigationHelper().returnToHomePage();
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().confirmContactDeletion();
    app.getContactHelper().choiceConfirmation();
    app.getNavigationHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}

