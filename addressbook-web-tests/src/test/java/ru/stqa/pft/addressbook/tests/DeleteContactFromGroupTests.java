package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.io.File;
import java.util.Set;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

    if (app.db().contacts().iterator().next().getGroups().size() == 0) {
      app.contact().addInSelectGroup(app.db().contacts().iterator().next().getId(), app.db().groups().iterator().next().getId());
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

    Contacts contacts1 = app.db().contacts();
    ContactData contactnew = contacts1.stream().filter((c) -> c.equals(contact)).findFirst().get();
    Set<GroupData> groupOfContactSet1 = contactnew.getGroups();
    assertThat(groupOfContactSet1.size(), equalTo(groupOfContactSet.size() - 1));

    GroupData groupData2 = groupOfContactSet.stream().filter(groupData -> !(groupOfContactSet1.contains(groupData))).findFirst().get();
    assertThat(groupOfContactSet1, equalTo(((Groups) groupOfContactSet).without(groupData2)));

  }

}
