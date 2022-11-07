package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(id="gh-ug")
	WebElement profile;
	
	@FindBy(id="gh-logo")
	WebElement logoImage;
	

	public HomePage() throws IOException {
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	public boolean validateLogoImage() {
		return logoImage.isDisplayed();
	}
	
	public String validateUserProfile() {
		return profile.getText();
		}
}
