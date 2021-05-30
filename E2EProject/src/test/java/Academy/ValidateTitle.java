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

public class ValidateTitle extends Base {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		log.info("ValidateTitle before method");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
		log.info("ValidateTitle before method");
		
		
	}
	
	@Test
	public void validateTitle() throws IOException {
		
				
		LandingPage l =new LandingPage(driver);
		
		String text = l.getTitle().getText();
		
		Assert.assertEquals(text, "FEATURED COURSES1");
		
		log.info("The text feature courses was validated successfully");
		
		
	}
}
