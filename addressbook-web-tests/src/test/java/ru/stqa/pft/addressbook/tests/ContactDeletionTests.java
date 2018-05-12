package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirst_name("Svetlana").withLast_name("Ivanova").withUser_address("Ukraine").
              withUser_phone("111-11-11").withUser_email("ivanova@localhost.com").withGroup("test1"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void Delete() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();    assertThat(app.contact().getContactCount(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));

  }
}

