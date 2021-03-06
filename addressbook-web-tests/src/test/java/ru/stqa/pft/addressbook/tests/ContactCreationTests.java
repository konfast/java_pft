package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))) {
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[] {new ContactData().withFirst_name(split[0]).withLast_name(split[1]).withPhoto(new File("src/test/resources/bear.png")).
                withUser_address(split[2]).withUser_phone(split[3]).withUser_email(split[4]).inGroup(new GroupData().withName("test1"))});
        line = reader.readLine();
      }
      return list.iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
      return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void ContactCreationTests(ContactData contact) {
      Contacts before = app.db().contacts();
      app.goTo().groupPage();
      Groups groups = app.db().groups();
      //GroupData selectGroup = groups.iterator().next();
      contact = contact.withMobilePhone("").withWorkPhone("").withEmail2("").withEmail3("").
              inGroup(groups.iterator().next());
      app.contact().create(contact, true);
      app.goTo().homePage();
      assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
      verifyContactListInUI();
  }

  @Test(enabled = false)
  public void testBadContactCreation() {
    Contacts before = app.db().contacts();
    ContactData contact = new ContactData().withFirst_name("Svetlana'").withLast_name("Ivanova").withUser_address("Ukraine").
            withUser_phone("111-11-11").withUser_email("ivanova@localhost.com").inGroup(new GroupData().withName("test1"));
    app.contact().create(contact, true);
    app.goTo().homePage();
    assertThat(app.contact().getContactCount(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
    verifyContactListInUI();
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
