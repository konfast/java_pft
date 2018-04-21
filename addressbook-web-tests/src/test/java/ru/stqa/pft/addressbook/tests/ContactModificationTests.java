package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Svetlana", "Ivanova", "Ukraine", "111-11-11", "ivanova@localhost.com", "test1"), true);
      app.getNavigationHelper().returnToHomePage();
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initContactModification(1);;
    app.getContactHelper().fillContactCreationForm(new ContactData("Elena", "Petrova", "Russia", "222-22-22", "petova@localhost.com", null), false);
    app.getContactHelper().summitContactModification();
    app.getNavigationHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
