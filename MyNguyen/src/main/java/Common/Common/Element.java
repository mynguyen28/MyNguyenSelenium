package Common.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant.Constant;

public class Element {

	public static By getLocator(String type, String locator) {
		By str = null;
		switch (type) {
		case "xpath":
			str = By.xpath(locator);
			break;

		case "id":
			str = By.id(locator);
			break;

		case "name":
			str = By.name(locator);
			break;
		}
		return str;
	}

	public static WebElement xpathElement(String xpath) {
		return Constant.WEBDRIVER.findElement(getLocator("xpath", xpath));
	}

	public static WebElement idElement(String id) {
		return Constant.WEBDRIVER.findElement(getLocator("id", id));
	}

	public static WebElement nameElement(String name) {
		return Constant.WEBDRIVER.findElement(getLocator("name", name));
	}

}
