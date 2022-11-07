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

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	PasswordLoginPage passwordpage;
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		
		passwordpage = loginpage.login(prop.getProperty("username"));
		homepage = passwordpage.signinWithPassword(prop.getProperty("password"));
	
	}	
	
	@Test(priority = 2)
	public void validateLogoImageTest() {
		boolean homePageLogo = homepage.validateLogoImage();
		Assert.assertTrue(homePageLogo);
	}
	
	@Test(priority = 1)
	public void validateUserProfileTest() {
		String userName = homepage.validateUserProfile();
		Assert.assertEquals(userName,prop.getProperty("User") );
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
}

}
