package pageElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Homepage {

	WebDriver driver;
	WebDriverWait wait;
	public Homepage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//div[@class='app_logo']") WebElement appLogo;
	@FindBy(xpath="//select[@class='product_sort_container']")  WebElement sortBtn;
	@FindBy(xpath="//select[@class='product_sort_container']/option") List<WebElement> DropdownOptions;
	@FindBy(xpath="//div[@class='inventory_item_name ']")
	public List<WebElement> sortOptions;
	@FindBy(id="react-burger-menu-btn") WebElement hamburgerButton;
	@FindBy(id="react-burger-cross-btn") WebElement hamburgerCloseButton;
	@FindBy(xpath="//a[contains(text(),'Twitter')]") WebElement Twitter;
	@FindBy (id="inventory_sidebar_link") WebElement AllItemsLink;
	@FindBy (id="about_sidebar_link")WebElement AboutLink;
	@FindBy(id="logout_sidebar_link")WebElement LogoutLink;
	@FindBy(xpath="//div[@class='inventory_list']/div/div[2]/div[1]") List<WebElement> ProductsDiscription;
	@FindBy(xpath="//div[@class='inventory_item_name ']") List<WebElement> ProductsName;
	@FindBy(xpath = "//div[@class='inventory_item_price']")  List<WebElement> ProductsPrice;
	@FindBy(xpath ="//a[@class='shopping_cart_link']")WebElement CartLink;
	@FindBy(xpath ="//div[@class='inventory_details_desc_container']/button")WebElement ProductAddToCartBtn;
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a/span")  WebElement cartContent;
	@FindBy (xpath ="button[@id='back-to-products']") WebElement BackToProductbtn; 
	@FindBy(xpath="//ul[@class='social']/li") List<WebElement> socialNetworks;
	@FindBy(xpath="//div[@class='footer_copy']") WebElement FooterCopy;
	@FindBy (xpath="//div[@class='bm-menu']/nav/a") List <WebElement> HamburgerMenuList;
	
	
	
	public void validateHomepage() {
		
		System.out.println(appLogo.getText());
		System.out.println("Landed to homepage");
		
	}
	
	public void validSortBtn() {
		
		sortBtn.isEnabled();
	}
	
	public void verifyDropdownArrow() {
		System.out.println("Dropdown arrow is disabled");
	}
	

		public boolean presenceOfhamburgerbutton() {
			return hamburgerButton.isDisplayed();
		}
		public void openHamburgerMenu() {
			hamburgerButton.click();
			wait.until(ExpectedConditions.visibilityOf(hamburgerCloseButton));
		}
		public boolean isHamburgerMenuOpen() {
			return HamburgerMenuList.size()>0;
		}
		public void enabledHamburgerButton() {
			if(hamburgerButton.isEnabled()) {
				System.out.println("Hamburger button is enabled");
			}
			else {
				System.out.println("Hamburger button is not enabled");
			}
		}
		
		
		public void clickOnAllItemsLink() {
			AllItemsLink.click();
		}
		public void clickonAboutLink()
		{
			AboutLink.click();
		}
		public void clickOnLogoutLink()
		{
			LogoutLink.click();
		}
		public void hamburgerCloseButton() {
			if(hamburgerCloseButton.isEnabled()) {
				System.out.println("Hamburger Close button is enabled");
			}
			else {
				System.out.println("Hamburger Close button is not enabled");
			}
		}
		
		public String defaultDropdownValue() {
			Select defaultvalue= new Select(sortBtn);
			return defaultvalue.getFirstSelectedOption().getText();
		}
		public List<WebElement> dropdownContents(){
			return DropdownOptions;
		}
		public String selectSortingOption(String option) {
			Select dropdown= new Select(sortBtn);
			dropdown.selectByValue(option);
			return dropdown.getFirstSelectedOption().getText();
		}
		public List<WebElement> getProductDiscription(){
			return ProductsDiscription;
		}
		public List<WebElement> getProductName(){
			return ProductsName;
		}
		public List<WebElement> getProductPrice(){
			return ProductsPrice;
		}
		public void clickCart() 
		{
			CartLink.click();
		}
		public String productsAddToCart() {
			return ProductAddToCartBtn.getText();
		}
		public void clickOnProductsAddToCart() {
			ProductAddToCartBtn.click();
		}
		public String getCartValue() {
			return cartContent.getText();
		}
		
		public void clickonBackToProduct() {
			BackToProductbtn.click();
		}
		
		public void twitter() {
		
		Actions a = new Actions(driver);
		a.scrollByAmount(0, 200).build().perform();	
		Twitter.isEnabled();
		Twitter.click();
		System.out.println("Twitter icon is enabled");
		String twitterTitle= driver.getTitle();
		Assert.assertEquals(twitterTitle, "Swag Labs");
		}
		
		public String footerCopy() {
			return FooterCopy.getText();
		}
		public List<WebElement> socialNetworks(){
			return socialNetworks;
		}
		
		
}


