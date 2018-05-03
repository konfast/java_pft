package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/bear.png");
    ContactData contact = new ContactData().withFirst_name("Svetlana").withLast_name("Ivanova").withPhoto(photo).withUser_address("Ukraine").
            withUser_phone("111-11-11").withUser_email("ivanova@localhost.com").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().homePage();
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testBadContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirst_name("Svetlana'").withLast_name("Ivanova").withUser_address("Ukraine").
            withUser_phone("111-11-11").withUser_email("ivanova@localhost.com").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().homePage();
    assertThat(app.contact().getContactCount(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/bear.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

}
