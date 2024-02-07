package pageElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Homepage {

	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='app_logo']") WebElement appLogo;
	
	public void validateHomepage() {
		
		System.out.println(appLogo.getText());
		System.out.println("Landed to homepage");
		
	}
	@FindBy(xpath="//select[@class='product_sort_container']")  WebElement sortBtn;
	@FindBy(xpath="//div[@class='inventory_item_name ']") List<WebElement> sortOptions;
	
	public void validSortBtn() {
		
		sortBtn.isEnabled();
	}
	
	public void verifyDropdownArrow() {
		System.out.println("Dropdown arrow is disabled");
	}
	
	public List<WebElement> productNamesZtoA(){
		System.out.println("======Sort Z To A======");
		System.out.println("Number of products:" +sortOptions.size());
		for(WebElement ZtoA: sortOptions) {
			System.out.println("List- " + ZtoA.getText());
		}
		return sortOptions;
	}
	
	public List<WebElement> priceLowToHigh(){
		System.out.println("======Low to High======");
		System.out.println("Number of products:" +sortOptions.size());
		for(WebElement LowToHigh: sortOptions) {
			System.out.println("List- " +LowToHigh.getText());
		}
		return sortOptions;
	}
		public List<WebElement> priceHighToLow(){
			System.out.println("======High to Low======");
			System.out.println("Number of products:" +sortOptions.size());
			for(WebElement HighToLow: sortOptions) {
				System.out.println("List- " +HighToLow.getText());
			}
			return sortOptions;
	}
		@FindBy(id="react-burger-menu-btn") WebElement hamburgerButton;
		@FindBy(id="react-burger-cross-btn") WebElement hamburgerCloseButton;
		public void validateBurgerButton() {
			if(hamburgerButton.isEnabled()) {
				System.out.println("Hamburger button is enabled");
			}
			else {
				System.out.println("Hamburger button is not enabled");
			}
		}
		
		public void burgerCloseButton() {
			if(hamburgerCloseButton.isEnabled()) {
				System.out.println("Hamburger Close button is enabled");
			}
			else {
				System.out.println("Hamburger Close button is not enabled");
			}
		}
		
		@FindBy(xpath="//a[contains(text(),'Twitter')]") WebElement Twitter;
		public void twitter() {
		
		Actions a = new Actions(driver);
		a.scrollByAmount(0, 200).build().perform();	
		Twitter.isEnabled();
		Twitter.click();
		System.out.println("Twitter icon is enabled");
		String twitterTitle= driver.getTitle();
		Assert.assertEquals(twitterTitle, "Swag Labs");
		}
}


