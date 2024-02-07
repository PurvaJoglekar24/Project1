package pageElements;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartOptionAndAddToCart {
	
	WebDriver driver;
	
	public CartOptionAndAddToCart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@class='shopping_cart_link']") WebElement cartLink;
	public void validateCartButton() {
		Login loginpage= new Login(driver);
		loginpage.loginEnterKey();
		if(cartLink.isEnabled()) {
			System.out.println("cartLink is enabled");
		}
		else {
			System.out.println("cartLink is not enabled");
		}
		cartLink.click();
		String title=driver.getTitle();
		System.out.println("The title of current page is "+title);
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@FindBy (id="add-to-cart-sauce-labs-onesie") WebElement addOnesie;
	public void addProductToCart() throws InterruptedException {
		driver.navigate().back();
		addOnesie.isEnabled();
		addOnesie.click();
		
		TakesScreenshot sc=(TakesScreenshot) driver;
		Thread.sleep(3000);
		File source= sc.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\saucedemo.jpeg");
		System.out.println("Product is added to cart and Screenshot taken");
	}
	
	@FindBy (id="checkout") WebElement checkout;
	@FindBy (name="firstName") WebElement firstName;
	@FindBy (name="lastName") WebElement lastName;
	@FindBy (name="postalCode") WebElement postalCode;
	@FindBy (name="continue") WebElement continueBtn;
	public void validateCheckoutOption() {
		cartLink.click();
		checkout.isEnabled();
		checkout.click();
		firstName.sendKeys("Purva");
		lastName.sendKeys("Joglekar");
		postalCode.sendKeys("123");
		continueBtn.click();
		}
	@FindBy(name="remove-sauce-labs-onesie") WebElement remove;
	public void remove() {
		driver.navigate().back();
		driver.navigate().back();
		remove.isEnabled();
		remove.click();
		TakesScreenshot s2= (TakesScreenshot)driver;
		File src= s2.getScreenshotAs(OutputType.FILE);
		File desti= new File("D:\\saucedemo2.jpeg");
		System.out.println("Screenshot2 taken and product is removed from cart");
	}	
	
}
