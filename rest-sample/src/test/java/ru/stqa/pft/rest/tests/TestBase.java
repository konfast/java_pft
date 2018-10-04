package ru.stqa.pft.rest.tests;

import org.testng.SkipException;
import ru.stqa.pft.rest.appmanager.ApplicationManager;
import java.io.IOException;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager();

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  public boolean isIssueOpen(int issueId) throws IOException {
    int state = app.rest().getIssue(issueId).getState();
    int open = 0;
    int inProgress = 1;
    return state == open || state == inProgress;
  }

}
