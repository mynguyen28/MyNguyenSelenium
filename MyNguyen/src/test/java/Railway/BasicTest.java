package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;

public class BasicTest {
	private HomePage homePage = new HomePage();

	@BeforeClass
	protected void beforeClass() {
		Utilities.openBrowser();
		homePage.open();
	}

	@AfterClass
	protected void afterClass() {
		Constant.WEBDRIVER.quit();
	}

}
