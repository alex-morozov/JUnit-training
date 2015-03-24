package ru.trainings.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.trainings.common.TestBase;

public class RandomLoginTest extends TestBase {

  @Test(dataProvider = "users")
  public void LoginWrong(String user, String password) throws InterruptedException {
	    driver.findElement(By.linkText("Войти")).click();
	    driver.findElement(By.name("loginuser")).clear();
	    driver.findElement(By.name("loginuser")).sendKeys(user);
	    driver.findElement(By.name("loginpassword")).clear();
	    driver.findElement(By.name("loginpassword")).sendKeys(password);
	    driver.findElement(By.name("btnlogin")).click();	
	    check.assertDisplayed(driver.findElement(By.name("btnlogin")));
  }

  
  @DataProvider
  public Iterator<Object[]> users() {
    List<Object[]> data = new ArrayList<Object[]>();
    for (int i = 0; i < 3; i++) {
      data.add(new Object[]{
         generateRandomName(), generateRandomPassword() 
      });
    }
    return data.iterator();
  }

  private Object generateRandomPassword() {
    return "password" + new Random().nextInt();
  }

  private Object generateRandomName() {
    return "user" + new Random().nextInt();
  }

}
