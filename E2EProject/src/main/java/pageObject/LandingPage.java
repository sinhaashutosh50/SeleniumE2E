package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By signIn = By.linkText("Login");
	
	By title = By.xpath("//section[@id='content']/div[1]/div[1]/h2[1]");
	
	By navigationBar = By.cssSelector("[class='nav navbar-nav navbar-right']");
	
	public WebElement getLogin() {
		return driver.findElement(signIn);
	}
	
	public WebElement getTitle() {
		
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		
		return driver.findElement(navigationBar);
	}
	
	
}
