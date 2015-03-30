package ru.trainings.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import ru.trainings.common.DataProviders;
import ru.trainings.common.DataSource;
import static ru.trainings.common.DataSource.Type.*;
import ru.trainings.common.TestBase;
import ru.trainings.common.UniversalDataProviders;


@RunWith(DataProviderRunner.class)
public class SectionCheckTest extends TestBase {

	@DataProvider
	  public static Object[][] loadFromFile() throws IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(
	        DataProviders.class.getResourceAsStream("/section.data")));
	    
	    List<Object[]> userData = new ArrayList<Object[]>();
	    String line = in.readLine();
	    while (line != null) {
	      userData.add(line.split(";"));
	      line = in.readLine();
	    }
	    
	    in.close();
	    
	    return (Object[][]) userData.toArray(new Object[][]{});
	  }
	
	@Test
	@UseDataProvider(value = "dataSourceLoader", location = UniversalDataProviders.class)
	@DataSource(value = "/section.data", type = RESOURCE)
	  public void test1(String section) {
		driver.findElement(By.linkText(section)).click();
	    check.assertDisplayed(driver.findElement(By.cssSelector("input[type=\"button\"]")));		
	  }
	
	
	  
}
