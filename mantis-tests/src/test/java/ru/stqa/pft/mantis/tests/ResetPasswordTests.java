package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test

  public void testResetPassword() throws IOException {

    String user = String.format("administrator");
    String password = "root";
    app.reset().start(user, password);

    UserData admin = new UserData();
    UserData user1 = app.db().users().stream().filter((u) -> !u.equals(admin.withId(1).
            withUsername("administrator").withEmail("root@localhost"))).collect(Collectors.toList()).iterator().next();
    int id = user1.getId();
    String email = user1.getEmail();
    String name = user1.getUsername();

    app.reset().getUsersList(id);
    app.reset().resetUserPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    String password1 = "password";
    app.reset().finish(confirmationLink, password1);
    assertTrue(app.newSession().login(name, password1));

  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);

  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

}
