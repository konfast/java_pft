package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();;
    app.getContactHelper().fillContactCreationForm1("Elena", "Petrova", "Russia", "222-22-22", "petova@localhost.com");
    app.getContactHelper().summitContactModification();
    app.getContactHelper().returnToHomePage();


  }
}
