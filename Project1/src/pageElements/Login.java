package pageElements;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="user-name") WebElement uname;
	@FindBy(id="password") WebElement pword;
	@FindBy(id="login-button") WebElement loginBtn;
	@FindBy(xpath="//h3[@data-test='error']") WebElement errorMessage;
	
	
	public void placeholders() {
		
		String nameHolder=uname.getAttribute("placeholder");
		if(nameHolder.equals("Username")) {
			System.out.println("Correct placeholder for username");
		}
		else {
			System.out.println("Incorrect placeholder for username");
		}
		
		String passholder=pword.getAttribute("placeholder");
		
		if(passholder.equals("Password")) {
			System.out.println("Correct placeholder for password");
		}
		else {
			System.out.println("Incorrect placeholder for password");
		}
	}

	@DataProvider(name="LoginData")
	public Object validCredentials() {
		Object[][] data= new Object[5][2];
			
				data[0][0]="standard_user";
				data[0][1]="secret_sauce";
				
				data[1][0]="locked_out_user";
				data[1][1]="secret_sauce";
				
				data[2][0]="problem_user";
				data[2][1]="secret_sauce";
				
				data[3][0]="performance_glitch_user";
				data[3][1]="secret_sauce";
				
				data[4][0]="error_user";
				data[4][1]="secret_sauce";
				
				data[4][0]="visual_user";
				data[4][1]="secret_sauce";
				return data;
	}
	@Test(dataProvider="LoginData")
	public void enterValidCredentials(String username, String password ) {
		uname.sendKeys(username);
		pword.sendKeys(password);
		loginBtn.click();
	}
	
	public void loginEnterKey() {
		driver.navigate().back();
		uname.sendKeys("standard_user");
		pword.sendKeys("secret_sauce");
		pword.sendKeys(Keys.ENTER);
	}
	
	public void invalidUnameValidPword() {
		driver.navigate().back();
		uname.sendKeys("st_user");
		pword.sendKeys("secret_sauce");
		pword.sendKeys(Keys.ENTER);
		
		assertNotEquals("standard_user", "st_user");
		System.out.println("Logged in using 'Enter' key "+errorMessage.getText());
	}
	
	
	public void validUnameinvalidPword() {
//		driver.navigate().back();
		uname.clear();
		pword.clear();
		uname.sendKeys("standard_user");
		pword.sendKeys("se_sauce");
		pword.sendKeys(Keys.ENTER);
		
		assertNotEquals("secret_sauce", "se_sauce");
//		System.out.println(errorMessage.getText());
		System.out.println("Invalid password");
	}
	

	public void loginButton() {
		uname.clear();
		uname.sendKeys("standard_user");
		pword.clear();
		pword.sendKeys("secret_sauce");
		
		if(loginBtn.isEnabled()) {
			
			System.out.println("Login button is enabled");
		}
		pword.sendKeys(Keys.ENTER);
	}
	
}


