package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    Groups group = app.db().groups();
    System.out.println(group);

    /*for (int i = 0; i < contact.size(); i++) {
      Set<GroupData> result = contact.iterator().next().getGroups();
      System.out.println(result);
      if (result.size() < group.size()) {
        contact.iterator().next().inGroup(group.iterator().next());
        //group.stream().map((c) -> new Object[] {c}).collect(Collectors.toSet()).iterator();

        return (group.removeAll(result);
      }
      //set1.removeAll(set2)
    }*/
  }
}




