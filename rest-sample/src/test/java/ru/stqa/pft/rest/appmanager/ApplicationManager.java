package ru.stqa.pft.rest.appmanager;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
  private final Properties properties;
  private WebDriver wd;

  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

}
