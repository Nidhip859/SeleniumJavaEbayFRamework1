/*
 * @author Nidhi Patel
 */
package pageTestCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.PasswordLoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	PasswordLoginPage passwordpage;
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitlePageTest() {
		String title = loginpage.validateLoginPageTile();
		Assert.assertEquals(title, "Sign in or Register | eBay");
	}
	
	@Test(priority=2)
	public void EbayLogoImageTest() {
		boolean flag = loginpage.validateEbayImage(); 
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws IOException {
		passwordpage = loginpage.login(prop.getProperty("username"));
	}
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
}
	
	


}
