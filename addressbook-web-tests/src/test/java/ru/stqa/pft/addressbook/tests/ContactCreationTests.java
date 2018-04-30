package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirst_name("Svetlana").withLast_name("Ivanova").withUser_address("Ukraine").
            withUser_phone("111-11-11").withUser_email("ivanova@localhost.com").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
