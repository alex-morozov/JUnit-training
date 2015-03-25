package ru.trainings.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import ru.trainings.common.TestBase;

@RunWith(DataProviderRunner.class)
public class RandomLoginTest extends TestBase {

	// при запуске - java.lang.Exception: No such dataprovider: users
	

	@Test
	@UseDataProvider("users")
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
  public static Object[][] users() {
    List<Object[]> data = new ArrayList<Object[]>();
    for (int i = 0; i < 10; i++) {
      data.add(new Object[]{
         generateRandomName(), generateRandomPassword() 
      });
    }
    return (Object[][]) data.toArray(new Object[][]{});
  }

  private static Object generateRandomPassword() {
    return "password" + new Random().nextInt();
  }

  private static Object generateRandomName() {
    return "user" + new Random().nextInt();
  }

}
