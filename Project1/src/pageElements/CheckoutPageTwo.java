package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageTwo {
	WebDriver driver;
	public CheckoutPageTwo() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="cancel") public WebElement Cancel;
	@FindBy(id="finish") WebElement Finish;
	@FindBy(xpath = "//div[@class='summary_subtotal_label']") private WebElement ItemTotal;
	@FindBy(xpath = "//div[@class='summary_tax_label']") private WebElement Tax;
	@FindBy(xpath = "//div[@class='summary_info_label summary_total_label']") private WebElement TotalPriceWithTax;
	
	
	public WebElement cancelBtnPresence() {
		return Cancel;
	}
	public WebElement finishBtnPresence() {
		return Finish;
	}
	public void clickOnFinishBtn() {
		Finish.click();
	}
	public String itemTotalPrice() {
		return 	ItemTotal.getText();
	}
	public String tax() {
		return Tax.getText();
	}
	public String totalPrice() {
		return TotalPriceWithTax.getText();
	}
	
}
