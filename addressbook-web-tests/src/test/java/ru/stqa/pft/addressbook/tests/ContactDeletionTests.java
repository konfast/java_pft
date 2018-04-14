package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void Delete() {

    app.getContactHelper().selectContact();
    app.getContactHelper().confirmContactDeletion();
    app.getContactHelper().choiceConfirmation();
    app.getNavigationHelper().returnToHomePage();
  }
}

