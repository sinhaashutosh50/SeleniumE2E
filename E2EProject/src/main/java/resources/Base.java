package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver ;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		
		
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\sinha\\Documents\\Eclipse Workspace - Selenium\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sinha\\Documents\\chromedriver_win32\\chromedriver.exe");
		       
		      driver = new ChromeDriver();
		    
		}
		
		if(browserName.equals("firefox")) {
			
			//firefox code
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + " .png";
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
	}
}
