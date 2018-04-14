package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();;
    app.getContactHelper().fillContactCreationForm(new ContactData("Elena", "Petrova", "Russia", "222-22-22", "petova@localhost.com", null), false);
    app.getContactHelper().summitContactModification();
    app.getContactHelper().returnToHomePage();


  }
}
