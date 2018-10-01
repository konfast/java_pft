package ru.stqa.pft.soap.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.soap.appmanager.ApplicationManager;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
     app.init();
  }

  public boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    BigInteger status = app.soap().getStatus(issueId);
    BigInteger resolved = BigInteger.valueOf(80);
    BigInteger closed = BigInteger.valueOf(90);
    return status.equals(resolved) || status.equals(closed);

  }

  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }


  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

}
