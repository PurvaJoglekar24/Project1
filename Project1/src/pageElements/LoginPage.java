package pageElements;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//div[text()='Swag Labs']") WebElement HomePageText;
	@FindBy(id="user-name") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login-button")
	public WebElement loginBtn;
	@FindBy(xpath="//h3[@data-test='error']")
	public WebElement errorMessage;
	@FindBy(xpath="//button[]@class='error-button']") WebElement errorCloseButton;
	
	public void placeholders() {
		
		String nameHolder=username.getAttribute("placeholder");
		if(nameHolder.equals("Username")) {
			System.out.println("Correct placeholder for username");
		}
		else {
			System.out.println("Incorrect placeholder for username");
		}
		
		String passholder=password.getAttribute("placeholder");
		
		if(passholder.equals("Password")) {
			System.out.println("Correct placeholder for password");
		}
		else {
			System.out.println("Incorrect placeholder for password");
		}
	}

	
	
//	public void login(String uname, String pword ) {
//		username.sendKeys(uname);
//		password.sendKeys(pword);
//		loginBtn.click();
//		
//	}
	public void enterUsername(String uname) {
		username.clear();
		username.sendKeys(uname);
	}
	public void enterPassword(String pword) {
		password.clear();
		password.sendKeys(pword);
	}
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	
	
	
//	public void clearFields() {
//		driver.get("https://www.saucedemo.com/");
//		username.clear();
//		password.clear();
//	}
	
	
	
//	public void loginEnterKey() {
//		driver.navigate().back();
//		username.sendKeys("standard_user");
//		password.sendKeys("secret_sauce");
//		password.sendKeys(Keys.ENTER);
//	}
//	
//	public void invalidUnameValidPword() {
//		driver.navigate().back();
//		username.sendKeys("st_user");
//		password.sendKeys("secret_sauce");
//		password.sendKeys(Keys.ENTER);
//		
//		assertNotEquals("standard_user", "st_user");
//		System.out.println("Logged in using 'Enter' key "+errorMessage.getText());
//	}
//	
//	
//	public void validUnameinvalidPword() {
////		driver.navigate().back();
//		username.clear();
//		password.clear();
//		username.sendKeys("standard_user");
//		password.sendKeys("se_sauce");
//		password.sendKeys(Keys.ENTER);
//		
//		assertNotEquals("secret_sauce", "se_sauce");
////		System.out.println(errorMessage.getText());
//		System.out.println("Invalid password");
//	}
//	
//
//	public void loginButton() {
//		username.clear();
//		username.sendKeys("standard_user");
//		password.clear();
//		password.sendKeys("secret_sauce");
//		
//		if(loginBtn.isEnabled()) {
//			
//			System.out.println("Login button is enabled");
//		}
//		password.sendKeys(Keys.ENTER);
//	}
//	
//}

	
	public boolean isHomePageTextDisplayed() {
		return HomePageText.isDisplayed();
	}
	
	public String homePageText() {
		return HomePageText.getText();
	}
	
	public boolean isErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}
	public String errormessage() {
		return errorMessage.getText();
	}
	public boolean isLockedOutMessageDisplayed() {
		return errorCloseButton.isDisplayed();
	}
	public String lockedOutErrorMessage() {
		return errorCloseButton.getText();
	}
	
	public boolean isLoginButtonEnabled() {
		return loginBtn.isEnabled();
	}
	
	
	
	
}
