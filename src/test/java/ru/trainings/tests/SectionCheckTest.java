package ru.trainings.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.trainings.common.DataProviders;
import ru.trainings.common.TestBase;



public class SectionCheckTest extends TestBase {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "loadUserFromFile")
	  public void test1(String section) {
		driver.findElement(By.linkText(section)).click();
	    check.assertDisplayed(driver.findElement(By.cssSelector("input[type=\"button\"]")));		
	  }
	
}
