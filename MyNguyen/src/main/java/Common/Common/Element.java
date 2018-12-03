package Common.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Constant.Constant;

public class Element {

	public static WebElement findElement(By locator) {
		waitForElementIsVisible(locator, Constant.DEFAULT_TIME);
		return Constant.WEBDRIVER.findElement(locator);
	}

	public static void waitForElementIsVisible(By locator, int timout) {
		(new WebDriverWait(Constant.WEBDRIVER, timout)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static Boolean isElementDisplayed(By locator) {
		try {
			WebElement element = Constant.WEBDRIVER.findElement(locator);
			boolean display = element.isDisplayed();
			return display;
		} catch (NoSuchElementException e) {
			return false;
		} catch (ElementNotVisibleException e) {
			return false;
		}

	}

	public static void enter(By locator, String value) {
		findElement(locator).clear();
		findElement(locator).sendKeys(value);
	}

	public static void click(By locator) {
		findElement(locator).click();
	}

	public static void clear(By locator)
	{
		findElement(locator).clear();
	}
	public static String getText(By locator) {
		return findElement(locator).getText();
	}

	public static void selectInList(By locator, String value) {
		Select drp = new Select(Element.findElement(locator));
		drp.selectByVisibleText(value);
	}

}
