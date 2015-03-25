package ru.trainings.common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	public static WebDriver driver = new FirefoxDriver();
	public static SeleniumAssertion check = new SeleniumAssertion (driver);		
	public static String baseURL = "http://www.musicforums.ru/";
		
	@Before
	  public void init (){
	  driver.get(baseURL);
	  }
	
	@AfterClass
	public static void stop (){
		driver.quit();
	}
}
