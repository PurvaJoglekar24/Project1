package pageElements;

import java.io.File;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy (id="add-to-cart-sauce-labs-onesie") WebElement addOnesie;
	public void addProductToCart() throws InterruptedException {
		
		addOnesie.isEnabled();
		addOnesie.click();
		
		TakesScreenshot sc=(TakesScreenshot) driver;
		Thread.sleep(3000);
		File source= sc.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\saucedemo.jpeg");
		System.out.println("Product is added to cart and Screenshot taken");
	}

	
	@FindBy(xpath = "//div[@class='cart_list']//div[@class='item_pricebar']/button") private List<WebElement> RemoveCartItem;
	@FindBy(id="continue-shopping")WebElement ContinueShopping; 
	@FindBy(id="checkout") public WebElement checkout;
	
	public void clickOnRemoveCart() {
		((WebElement) RemoveCartItem).click();
	}
	
	public WebElement continueShoppingPresence() {
		return ContinueShopping;
	}
	public void clickOnContinueShopping() {
		ContinueShopping.click();
	}
	public WebElement checkoutPresence() {
		return checkout;
	}
	public void clickOnCheckout() {
		checkout.click();
	}
	public boolean isContnueShoppingbtndisplayed()
	{
		return  ContinueShopping.isDisplayed();
	}
	
	
	
}
