package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.LoginPage;

public class BasicTest {
	
	private LoginPage loginPage = new LoginPage();

	@BeforeMethod
	protected void beforeMethod() {
		Utilities.openBrowser();
	}
	
	@AfterMethod
	protected void afterMethod() {
		loginPage.logOut();
		Constant.WEBDRIVER.quit();
	}

}
