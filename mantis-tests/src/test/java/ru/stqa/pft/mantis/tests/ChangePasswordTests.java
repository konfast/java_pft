package ru.stqa.pft.mantis.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test

  public void testChangePassword() throws IOException {
    HttpSession session = app.newSession();
    session.login("administrator", "root");
    assertTrue(session.isLoggedInAs("administrator"));
    goToManage();

  }


}
