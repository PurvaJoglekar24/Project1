package pageElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class URL {
	
	WebDriver driver= new ChromeDriver();
	@Test(priority=0)
	public void validateUrl(){
		String website="https://www.saucedemo.com/";
		driver.get(website);
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		assertEquals(url, "https://www.saucedemo.com/");
		assertEquals(title, "Swag Labs");
		
	}
	
	@FindBy(xpath="//a[@id='error-information-button']/preceding::span") WebElement errorMessage;
	@Test(priority=1)
	public void invalidUrl() throws InterruptedException {

		try {
		driver.get("https://www.saucedemo12.com/");
		System.out.println(errorMessage.getText());
	}
		catch(Exception e) {
			System.out.println("Invalid url");
		}
	driver.close();
}
}