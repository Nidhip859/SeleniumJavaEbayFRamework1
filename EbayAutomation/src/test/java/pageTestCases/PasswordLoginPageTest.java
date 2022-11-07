package pageTestCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.PasswordLoginPage;

public class PasswordLoginPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	PasswordLoginPage passwordpage;
	public PasswordLoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		
		passwordpage = loginpage.login(prop.getProperty("username"));
	
	}	
	
	@Test(priority=1)
	public void verifyPasswordPageTitleTest() {
		String pswdPageTitle = passwordpage.validatePasswordPageTitle();
		Assert.assertEquals(pswdPageTitle, "Sign in or Register | eBay");
	}
	
	@Test(priority=2)
	public void validateUseridTest()  {
		String user = passwordpage.validateUserid();
		Assert.assertEquals(user, prop.getProperty("username"));
	}
	
	@Test(priority=3)
	public void signinWithPasswordTest() throws IOException {
		homepage = passwordpage.signinWithPassword(prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
}
}
