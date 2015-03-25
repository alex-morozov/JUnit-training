package ru.trainings.common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	public static WebDriver driver = new FirefoxDriver();
	public static SeleniumAssertion check = new SeleniumAssertion (driver);		
	public static String baseURL = "http://www.musicforums.ru/";
	
	@Rule
	 public ExternalResource startDriverRule = new ExternalResource() {	
		@Override
		protected void before (){
	  driver.get(baseURL);
	  }
	};
	
	
	@ClassRule
	 public static ExternalResource finishDriverRule = new ExternalResource() {	
		@Override
		protected void after (){
			if (driver != null) {
		        driver.quit();
		      }
	  }
	};
}
