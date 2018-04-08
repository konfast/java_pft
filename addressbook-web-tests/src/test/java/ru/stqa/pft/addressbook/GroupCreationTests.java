package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void GroupCreationTests() {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GruopData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}

