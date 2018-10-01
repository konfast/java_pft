package ru.stqa.pft.rest.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.rest.appmanager.ApplicationManager;

import static sun.plugin2.util.BrowserType.MOZILLA;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", String.valueOf(MOZILLA)));

  @BeforeSuite
  public void setUp() throws Exception {
     app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

}
