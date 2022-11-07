package pages;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.TestBase;

public class PasswordLoginPage extends TestBase {

		
		

		@FindBy(id="pass")
		WebElement pass;
		
		@FindBy(id="user-info")
		WebElement userid;
		
		@FindBy(id="sgnBt")
		WebElement submitBtn;
		
		public PasswordLoginPage() throws IOException {
			PageFactory.initElements(driver,this);
			
	}
		public String validatePasswordPageTitle() {
			return driver.getTitle();
		}
		
		public String validateUserid() {
			return userid.getText();
		}
		
		public HomePage signinWithPassword(String pswd) throws IOException {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("document.getElementById('pass').value = '"+pswd+"'");
			//pass.sendKeys(pswd);
			submitBtn.submit();
			 return new HomePage();
		}
		
		
	

}
