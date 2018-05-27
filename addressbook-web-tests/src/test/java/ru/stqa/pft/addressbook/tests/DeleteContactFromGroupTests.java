package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.io.File;
import java.util.Set;

public class DeleteContactFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirst_name("Svetlana").withLast_name("Ivanova").
              withPhoto(new File("src/test/resources/bear.png")).inGroup(new GroupData().withName("test1")).withUser_address("Ukraine").
              withUser_phone("111-11-11").withUser_email("ivanova@localhost.com"), true);
    }

    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("test5").withHeader("myHeader").withFooter("myFooter"));
      app.goTo().homePage();
    }
  }

  @Test

  public void testDeleteContactFromGroup() {

    Groups group = app.db().groups();
    Contacts contacts = app.db().contacts();
    ContactData contact = contacts.iterator().next();
    int id = contact.getId();
    Set<GroupData> groupOfContactSet = contact.getGroups();

    if (!groupOfContactSet.isEmpty()) {
      int index = groupOfContactSet.iterator().next().getId();
      app.contact().deleteFromSelectGroup(id, index);
      app.goTo().homePage();

    }
  }

}
