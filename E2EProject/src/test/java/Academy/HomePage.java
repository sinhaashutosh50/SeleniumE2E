package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base{
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		log.info("HomePage class driver initialization");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
		log.info("HoePage class driver closes");
	}
	
	
	@Test(dataProvider =  "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		
				
		LandingPage l =new LandingPage(driver);
		
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		
		log.info("The user is" + text);
		lp.getLogin().click();
		

	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		
		data[0][0] = "user1@gmail.com";
		data[0][1] = "password";
		data[0][2] = "restricted user";
		
		data[1][0] ="user2@gmail.com";
		data[1][1] = "password";
		data[1][2] = "nonrestrictedUser";
		
		return data;
		
	}
	

}
