package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageElements.CartOptionAndAddToCart;
import pageElements.HamburgerAndCloseButton;
import pageElements.Homepage;
import pageElements.Login;
import pageElements.RemoveOption;
import pageElements.SortDropdown;
import pageElements.TwitterIcon;
import pageElements.URL;

public class BaseTest {
	
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	
	URL url= new URL();
	url.validateUrl();
	url.invalidUrl();
	
	Login loginpage= new Login(driver);
	loginpage.placeholders();
	loginpage.validCredentials();
	loginpage.enterValidCredentials("standard_user","secret_sauce");
	loginpage.loginEnterKey();
	loginpage.invalidUnameValidPword();
	loginpage.validUnameinvalidPword();
	loginpage.loginButton();
	
	
	Homepage hp= new Homepage(driver);
	hp.validateHomepage();
	hp.validSortBtn();
	hp.verifyDropdownArrow();
	hp.productNamesZtoA();
	hp.priceLowToHigh();
	hp.priceHighToLow();
	hp.validateBurgerButton();
	hp.burgerCloseButton();
	hp.twitter();
	
		
	CartOptionAndAddToCart cart=new CartOptionAndAddToCart(driver);
	cart.validateCartButton();
	cart.addProductToCart();
	cart.validateCheckoutOption();
	cart.remove();
	}
}