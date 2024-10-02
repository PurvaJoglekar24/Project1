package test;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageElements.CartPage;
import pageElements.CheckoutPage;
import pageElements.CheckoutPageTwo;
import pageElements.Homepage;
import pageElements.LoginPage;
import pageElements.OrderCompletePage;
import readExcelFile.ExcelFileData;

public class BaseTest {
	WebDriver driver;
	LoginPage loginPage; Homepage homePage; CartPage cartPage; CheckoutPage checkoutPage;
	CheckoutPageTwo checkoutPageTwo;OrderCompletePage orderCompletePage;
	XSSFSheet loginsheet= ExcelFileData.readExcelData("LoginSheet");
	
	@BeforeTest
	public void launchBrowserAndInitialization() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		loginPage= new LoginPage(driver);
		homePage= new Homepage(driver);
		cartPage= new CartPage(driver);
		checkoutPage= new CheckoutPage(driver);
		checkoutPageTwo= new CheckoutPageTwo();
		orderCompletePage= new OrderCompletePage();
	}
	
	@Test(priority=1)
	public void validateLoginPage() {
		Assert.assertTrue(loginPage.isHomePageTextDisplayed(),"Swag Labs");
		
	}
	@Test(priority=2)
	public void validatePlaceholders() {
		loginPage.placeholders();
	}
	
	@DataProvider(name="LoginData")
	public Object validCredentials() {
		Object[][] data= new Object[5][2];
			
				data[0][0]="standard_user";
				data[0][1]="secret_sauce";
						
				data[1][0]="problem_user";
				data[1][1]="secret_sauce";
				
				data[2][0]="performance_glitch_user";
				data[2][1]="secret_sauce";
				
				data[3][0]="error_user";
				data[3][1]="secret_sauce";
				
				data[4][0]="visual_user";
				data[4][1]="secret_sauce";
				return data;
	}
	
	@Test(priority=3, dataProvider="LoginData")
	public void LoginWithValidCredentials(String Username, String Password) {
	loginPage.enterUsername(Username);
	loginPage.enterPassword(Password);
	loginPage.clickOnLoginBtn();
	loginPage.isLockedOutMessageDisplayed();
	Assert.assertEquals(loginPage.errorMessage,"Epic sadface: Sorry, this user has been locked out.");
//	Assert.assertEquals(driver.getCurrentUrl(), loginsheet.getRow(1).getCell(1).toString(),"URL does not match after successful login");
	homePage.openHamburgerMenu();
	homePage.clickOnLogoutLink();
	
}
	@Test(priority=4)
	public void LoginWithEnterKey() {
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.loginBtn.sendKeys(Keys.ENTER);
	}
	
	@Test(priority=5)
	public void LoginWithInvalidUsername() {
		loginPage.enterUsername(loginsheet.getRow(2).getCell(1).toString());
		loginPage.enterPassword(loginsheet.getRow(2).getCell(2).toString());
		loginPage.clickOnLoginBtn();
		loginPage.errormessage();
//		Assert.assertEquals(loginPage.errorMessage, "Epic sadface: Username and password do not match any user in this service");
	}
	@Test(priority=6)
	public void LoginWithInvalidPassword() {
		loginPage.enterUsername(loginsheet.getRow(3).getCell(1).toString());
		loginPage.enterPassword(loginsheet.getRow(3).getCell(2).toString());
		loginPage.clickOnLoginBtn();
		loginPage.errormessage();
//		Assert.assertEquals(loginPage.errorMessage, "Epic sadface: Username and password do not match any user in this service");
	}
	@Test(priority=7)
	public void loginButtonEnabled() {
		loginPage.isLoginButtonEnabled();
	}
	@Test(priority=8)
	public void validatingHomePage() {
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnLoginBtn();
		homePage.validateHomepage();
	}
	@Test(priority=9)
	public void verifyingHamburgerBtn() {
		homePage.presenceOfhamburgerbutton();
	}
	@Test(priority=10)
	public void verifyHamburgerBtnOpens() {
		homePage.openHamburgerMenu();
		Assert.assertTrue(homePage.isHamburgerMenuOpen(), "Hamburger menu is open");
	}
	@Test(priority=11)
	public void verifyAboutPageRedirect() {
		homePage.openHamburgerMenu();
		homePage.clickonAboutLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
	}
	@Test(priority=12)
	public void verifyLogoutLink()
	{
		homePage.openHamburgerMenu();
		homePage.clickOnLogoutLink();
		Assert.assertEquals(driver.getCurrentUrl(), "Logout did not navigate to the login page");
	}
	@Test(priority=13)
	public void verifyHamburgerCloseButton()
	{
		homePage.openHamburgerMenu();
		homePage.hamburgerCloseButton();;
		Assert.assertTrue(homePage.isHamburgerMenuOpen(), "Hamburger Menu is not closed.");
	}
	@Test(priority=14)
	public java.util.List<WebElement> verifySortDropdown() {
		java.util.List<WebElement> dropdownValues= homePage.dropdownContents();
		for(int i=0;i<dropdownValues.size();i++) {
			 dropdownValues.get(i).getText();
		}
		return dropdownValues;
	}
	@Test(priority=15)
	public java.util.List<WebElement> productNamesAtoZ(){
		System.out.println("======Sort A To Z======");
		System.out.println("Number of products:" +homePage.sortOptions.size());
		for(WebElement AtoZ: homePage.sortOptions) {
			System.out.println("List- " + AtoZ.getText());
		}
		return homePage.sortOptions;
	}
	@Test(priority=16)
	public java.util.List<WebElement> productNamesZtoA(){
		System.out.println("======Sort Z To A======");
		System.out.println("Number of products:" +homePage.sortOptions.size());
		for(WebElement ZtoA: homePage.sortOptions) {
			System.out.println("List- " + ZtoA.getText());
		}
		return homePage.sortOptions;
	}
	@Test(priority=17)
	public java.util.List<WebElement> priceLowToHigh(){
		System.out.println("======Low to High======");
		System.out.println("Number of products:" +homePage.sortOptions.size());
		for(WebElement LowToHigh: homePage.sortOptions) {
			System.out.println("List- " +LowToHigh.getText());
		}
		return homePage.sortOptions;
	}
	@Test(priority=18)
		public java.util.List<WebElement> priceHighToLow(){
			System.out.println("======High to Low======");
			System.out.println("Number of products:" +homePage.sortOptions.size());
			for(WebElement HighToLow: homePage.sortOptions) {
				System.out.println("List- " +HighToLow.getText());
			}
			return homePage.sortOptions;
	}
	@Test(priority=19)
	public void inventoryAddToCartBtnValidation() {		
		homePage.clickOnProductsAddToCart();
		homePage.getCartValue();
		System.out.println(homePage.getCartValue());
	}
	@Test(priority=20)
	public void validatingCartPage() {
		homePage.clickOnProductsAddToCart();
		homePage.clickCart();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
	}
	@Test(priority=21)
	public void validatingRemoveCartItem() {
		homePage.clickOnProductsAddToCart();
		homePage.clickCart();
		String beforeRemoving= homePage.getCartValue();
		cartPage.clickOnRemoveCart();
		String afterRemoving= homePage.getCartValue();
		Assert.assertNotEquals(beforeRemoving,afterRemoving);
	}
	@Test(priority=22)
	public void validatingCartCheckoutBtn() {
		homePage.clickOnProductsAddToCart();
		homePage.clickCart();
		cartPage.checkoutPresence();
		Assert.assertTrue(cartPage.checkout.isDisplayed());
		Assert.assertTrue(cartPage.checkout.isEnabled());
		cartPage.clickOnCheckout();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
	}
	@Test(priority=23)
	public void checkOutFieldsValidation() {
		checkoutPage.firstNamePresence();
		Assert.assertTrue(checkoutPage.FirstName.isDisplayed());
		checkoutPage.FirstName.getAttribute("placeholder");
		checkoutPage.lastNamePresence();
		Assert.assertTrue(checkoutPage.LastName.isDisplayed());
		checkoutPage.LastName.getAttribute("placeholder");
		checkoutPage.zipCodePresence();
		Assert.assertTrue(checkoutPage.ZipCode.isDisplayed());
		checkoutPage.ZipCode.getAttribute("placeholder");
	}
	@Test(priority=24)
	public void validatingCheckoutPageCancelBtn() {
		checkoutPage.enterFieldValues("Purva","J","411041");
		checkoutPage.cancelBtnPresence();
		Assert.assertTrue(checkoutPage.Cancel.isDisplayed());
		Assert.assertTrue(checkoutPage.Cancel.isEnabled());
		checkoutPage.clickOnCancelBtn();
	}
	@Test(priority=25)
	public void validatingCheckoutPageContinueBtn() {
		checkoutPage.enterFieldValues("Purva","J","411041");
		checkoutPage.continueBtnPresence();
		Assert.assertTrue(checkoutPage.Continue.isDisplayed());
		Assert.assertTrue(checkoutPage.Continue.isEnabled());
		checkoutPage.clickOnContinueBtn();
	}
	@Test(priority=26)
	public void validatingCancelBtn() {
		checkoutPageTwo.cancelBtnPresence();
		Assert.assertTrue(checkoutPageTwo.Cancel.isDisplayed());
		Assert.assertTrue(checkoutPageTwo.Cancel.isEnabled());
		
		checkoutPageTwo.Cancel.click();
		
	}
	@Test(priority=27)
	public void finishBtnValidation() {
		WebElement FinishBtn = checkoutPageTwo.finishBtnPresence();
		Assert.assertTrue(FinishBtn.isDisplayed());
		Assert.assertTrue(FinishBtn.isEnabled());
		checkoutPageTwo.clickOnFinishBtn();
	}
	@Test(priority=28)
	public void socialNetworks() {
		homePage.socialNetworks();
	}
	@Test(priority=29)
	public void validatingOrderComplete() {
		orderCompletePage.titleText();
		orderCompletePage.thankyouText();
		orderCompletePage.orderCompletionText();
	}
	@Test(priority=30)
	public void backHomebtnValidation() {
		WebElement backhome=  orderCompletePage.backHomeBtn();
		Assert.assertTrue(backhome.isDisplayed());
		Assert.assertTrue(backhome.isEnabled());
		backhome.getText();
		orderCompletePage.clickOnBackHomeBtn();
		
	}
	
	
	
	
}	