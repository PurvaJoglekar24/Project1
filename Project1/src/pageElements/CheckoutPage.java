package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	public WebElement FirstName;
	@FindBy(id="last-name") public WebElement LastName;
	@FindBy(id="postal-code")public WebElement ZipCode;
	@FindBy(id="cancel")
	public WebElement Cancel;
	@FindBy(id="continue")
	public WebElement Continue;
	@FindBy(xpath = "//h3[@data-test='error']") WebElement CheckoutPageOneErrorMsg;
	
	public WebElement firstNamePresence() {
		return FirstName;
	}
	public WebElement lastNamePresence() {
		return LastName;
	}
	public WebElement zipCodePresence() {
		return ZipCode;
	}
	public WebElement cancelBtnPresence() {
		return Cancel;
	}
	public WebElement continueBtnPresence() {
		return Continue;
	}
	public void clickOnCancelBtn() {
		Cancel.click();
	}
	public void clickOnContinueBtn() {
		Continue.click();
	}
	public String getErrorMsg() {
		return CheckoutPageOneErrorMsg.getText();
	}
	public void emptyfields() {
		FirstName.sendKeys("");
		LastName.sendKeys("");
		ZipCode.sendKeys("");
	}
	public void enterFieldValues(String Fn, String Ln, String Zipcode) {
		FirstName.sendKeys(Fn);
		LastName.sendKeys(Ln);
		ZipCode.sendKeys(Zipcode);
	}
	public void enterLastNameNZipcodeFieldValues(String Ln, String Zipcode) {
		FirstName.sendKeys("");
		LastName.sendKeys(Ln);
		ZipCode.sendKeys(Zipcode);
	}
	public void enterFirstNameNZipcodeValues(String Fn, String Zipcode) {
		FirstName.sendKeys(Fn);
		LastName.sendKeys("");
		ZipCode.sendKeys(Zipcode);
	}
	public void enterFirstNLastNameValues(String Fn, String Ln) {
		FirstName.sendKeys(Fn);
		LastName.sendKeys(Ln);
		ZipCode.sendKeys("");
	}
	
	
	
	
	
	
}
