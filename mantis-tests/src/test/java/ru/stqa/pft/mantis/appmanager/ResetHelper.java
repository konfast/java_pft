package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class ResetHelper extends HelperBase {

  public ResetHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String password ) {
    wd.get(app.getProperty("web.baseURL") + "login_page.php");
    type(By.id("username"), username);
    wd.findElement(By.xpath("//input[@type='submit']")).click();
    type(By.id("password"), password);
    wd.findElement(By.xpath("//input[@type='submit']")).click();

  }

  public void getUsersList(int id) {
    wd.findElement(By.xpath("//li/a[@href=\"/mantisbt-2.14.0/manage_overview_page.php\"]")).click();
    wd.findElement(By.xpath("//ul/li/a[@href=\"/mantisbt-2.14.0/manage_user_page.php\"]")).click();
    wd.findElement(By.xpath("//tr/td/a[@href=\"manage_user_edit_page.php?user_id=" + id + "\"]")).click();

  }

  public void resetUserPassword() {
    wd.findElement(By.xpath("//span/input[@value='Сбросить пароль']")).click();
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.xpath("//button/span[contains(text(),'Изменить учетную запись')]"));

  }

}
