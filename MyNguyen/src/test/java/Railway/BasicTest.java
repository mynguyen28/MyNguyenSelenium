package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.Browser;

public class BasicTest {

	@BeforeClass
	protected void beforeClass() {
		Utilities.openRailWay(Browser.CHROME);
	}

	@AfterClass
	protected void afterClass() {
		 Constant.WEBDRIVER.quit();
	}

}
