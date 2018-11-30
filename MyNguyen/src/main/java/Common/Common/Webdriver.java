package Common.Common;

import org.openqa.selenium.WebDriver.TargetLocator;

import Common.Constant.Constant;

public class Webdriver {

	public static void navigateTo(String url) {
		Constant.WEBDRIVER.navigate().to(url);
	}

	public static TargetLocator switchTo() {
		return (TargetLocator) Constant.WEBDRIVER.switchTo();
	}

}
