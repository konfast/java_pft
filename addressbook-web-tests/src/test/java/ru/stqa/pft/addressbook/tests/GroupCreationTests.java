package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GruopData;

public class GroupCreationTests extends TestBase {

  @Test
  public void GroupCreationTests() {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GruopData("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}

