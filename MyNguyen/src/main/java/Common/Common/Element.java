package Common.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Constant.Constant;

public class Element {

	public static WebElement findElement(By by) {
		return Constant.WEBDRIVER.findElement(by);
	}

	public static void waitForElementIsVisible(By by, int timout) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, timout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public Boolean isElementPresent(By by) {
		try {
			findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
