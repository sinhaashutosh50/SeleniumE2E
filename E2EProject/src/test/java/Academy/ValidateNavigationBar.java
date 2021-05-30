package Academy;

import java.io.IOException;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		log.info("ValidateNavigationBar before method");
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
		log.info("ValidateNavigationBar after method");
		
		
	}
	
	@Test
	public void validateNavigationBar() throws IOException {
		
		
		LandingPage l =new LandingPage(driver);
		
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		
		
	}
}
