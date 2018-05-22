package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase{

  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseURL") + "signup_page.php");
    type(By.name("username"), username);
    type(By.name("email"), email);
    click(By.cssSelector("input[value = 'Зарегистрироваться']"));
  }

  public void finish(String confirmationLinc, String password) {
    wd.get(confirmationLinc);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    //click(By.cssSelector("input[value = 'Update User']"));
    //click(By.xpath("//button/span[@class='bigger-110]");
    //click(By.xpath("//span[contains(text(),'Изменить учетную запись')]"));
    click(By.xpath("//button/span[contains(text(),'Изменить учетную запись')]"));



  }
}


