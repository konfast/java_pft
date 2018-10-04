package ru.stqa.pft.rest.tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class MyTestCreateIssue extends TestBase {

  @Test

  public void testCreateIssue() throws IOException {

    skipIfNotFixed(1);
    Issue issue = app.rest().getIssue(1);
    System.out.println(issue);
    Set<Issue> issues = app.rest().getIssues();

    for (Issue i : issues) {
      System.out.println(i);
    }
}

}
