package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import java.io.IOException;
import java.sql.Connection;
import java.util.stream.Collectors;

public class ResetPasswordTests extends TestBase {

  @Test

  public void testResetPassword() throws IOException {

    String user = String.format("administrator");
    String password = "root";
    app.reset().start(user, password);

    UserData admin = new UserData();
    UserData user1 = app.db().users().stream().filter((u) -> !u.equals(admin.withId(1).
            withUsername("administrator").withEmail("root@localhost"))).collect(Collectors.toList()).iterator().next();
    int id = user1.getId();
    app.reset().getUsersList(id);

  }
}
