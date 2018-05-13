package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.io.File;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirst_name("Svetlana").withLast_name("Ivanova").
              withPhoto(new File("src/test/resources/bear.png")).withUser_address("Ukraine").
              withUser_phone("111-11-11").withUser_email("ivanova@localhost.com").withGroup("test1"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirst_name("Elena").withLast_name("Petrova").
            withPhoto(new File("src/test/resources/bear.png")).withUser_address("Russia").
            withUser_phone("222-22-22").withMobilePhone(modifiedContact.getMobilePhone()).
            withWorkPhone(modifiedContact.getWorkPhone()).withUser_email("petrova@localhost.com").
            withEmail2(modifiedContact.getEmail2()).withEmail3(modifiedContact.getEmail3()).withGroup(modifiedContact.getGroup());
    app.contact().modify(contact);
    app.goTo().homePage();
    assertThat(app.contact().getContactCount(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }

}
