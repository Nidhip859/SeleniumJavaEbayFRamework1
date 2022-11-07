package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase  {

	
	
	@FindBy(id="gh-logo")
	WebElement ebayLogo;
	
	@FindBy(id="userid")
	WebElement username;
	
	@FindBy (id="signin-continue-btn")
	WebElement signinBtn;
	
	public LoginPage() throws IOException {
		
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	public String validateLoginPageTile() {
		return driver.getTitle();
	}
	public boolean validateEbayImage() {
		return ebayLogo.isDisplayed();
	}
	 public PasswordLoginPage login(String user) throws IOException {
		 username.sendKeys(user);
		 signinBtn.click();
		 return new PasswordLoginPage();
	 }
	 

}
