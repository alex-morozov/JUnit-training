package ru.trainings.tests;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import ru.trainings.common.MyCategories;
import ru.trainings.common.TestBase;
import ru.trainings.common.Unstable;


public class TestClass extends TestBase implements MyCategories{	 
		 	  
	@Test
	@Category(PositiveTests.class)
	public void LoginOK (){
		    driver.findElement(By.linkText("Войти")).click();
		    driver.findElement(By.name("loginuser")).clear();
		    driver.findElement(By.name("loginuser")).sendKeys("SeleniumBass");
		    driver.findElement(By.name("loginpassword")).clear();
		    driver.findElement(By.name("loginpassword")).sendKeys("elena1989");
		    driver.findElement(By.name("btnlogin")).click();		    
		    check.assertDisplayed(driver.findElement(By.cssSelector("div.user-name")));		    
	}
	
	@Test 
	@Unstable
	public void LoginWrong (){
		    driver.findElement(By.linkText("Войти")).click();
		    driver.findElement(By.name("loginuser")).clear();
		    driver.findElement(By.name("loginuser")).sendKeys("Wrong");
		    driver.findElement(By.name("loginpassword")).clear();
		    driver.findElement(By.name("loginpassword")).sendKeys("elena1989");
		    driver.findElement(By.name("btnlogin")).click();	
		    check.assertDisplayed(driver.findElement(By.name("btnlogin")));
	}
	
	@Test 
	@Category(PositiveTests.class)
	public void showButton (){
		    driver.findElement(By.linkText("бас-гитары")).click();
		    check.assertDisplayed(driver.findElement(By.cssSelector("input[type=\"button\"]")));			    
	}
	
}
