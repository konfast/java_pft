package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.util.Set;

public class AddContactInGroupTests extends TestBase {

  @Test
  public void testsAddContactInGroup() {
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirst_name("Svetlana").withLast_name("Ivanova").
              withPhoto(new File("src/test/resources/bear.png")).inGroup(new GroupData().withName("test1")).withUser_address("Ukraine").
              withUser_phone("111-11-11").withUser_email("ivanova@localhost.com"), true);
    }

    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("test5").withHeader("myHeader").withFooter("myFooter"));
      app.goTo().homePage();
    }

    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();

    for (ContactData contact : contacts) {
      int id = contact.getId();
      Set<GroupData> groupOfContactSet = contact.getGroups();
      groups.removeAll(groupOfContactSet);

      if (!groups.isEmpty()) {
        int index = groups.iterator().next().getId();//получаю id первой попавшейся свободной группы
        app.contact().addInSelectGroup(id,index);
        break;

      } else {
        GroupData newGroup = new GroupData().withName("newTestGroup'");
        app.group().create(newGroup);

        contact.inGroup(newGroup);
      }
    }
  }
}











