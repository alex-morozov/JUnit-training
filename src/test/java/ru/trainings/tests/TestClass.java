package ru.trainings.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.trainings.common.SeleniumAssertion;
import ru.trainings.common.TestBase;
import org.openqa.selenium.By;


public class TestClass extends TestBase{	 
		 	  
	@Test ( groups = ("positive"))
	public static void LoginOK (){
		    driver.findElement(By.linkText("Войти")).click();
		    driver.findElement(By.name("loginuser")).clear();
		    driver.findElement(By.name("loginuser")).sendKeys("SeleniumBass");
		    driver.findElement(By.name("loginpassword")).clear();
		    driver.findElement(By.name("loginpassword")).sendKeys("elena1989");
		    driver.findElement(By.name("btnlogin")).click();		    
		    check.assertDisplayed(driver.findElement(By.cssSelector("div.user-name")));		    
	}
	
	@Test ( groups = ("negative"))
	public static void LoginWrong (){
		    driver.findElement(By.linkText("Войти")).click();
		    driver.findElement(By.name("loginuser")).clear();
		    driver.findElement(By.name("loginuser")).sendKeys("Wrong");
		    driver.findElement(By.name("loginpassword")).clear();
		    driver.findElement(By.name("loginpassword")).sendKeys("elena1989");
		    driver.findElement(By.name("btnlogin")).click();	
		    check.assertDisplayed(driver.findElement(By.name("btnlogin")));
	}
	
	@Test ( groups = ("positive"))
	public static void showButton (){
		    driver.findElement(By.linkText("бас-гитары")).click();
		    check.assertDisplayed(driver.findElement(By.cssSelector("input[type=\"button\"]")));			    
	}
	
}
