package Common.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import Common.Constant.Constant;
import Common.Constant.Constant.Browser;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class Utilities {
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public static void openRailWay(Browser browser) {

		String path = "\\src\\main\\java\\Executables\\%s";
		String temp;

		switch (browser) {
		case CHROME: {
			temp = String.format(path, "chromedriver.exe");
			Constant.WEBDRIVER = new ChromeDriver();
			System.setProperty(browser.getValue(), getProjectPath() + temp);
			Constant.WEBDRIVER.manage().window().maximize();
			Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		}

			break;

		case FIREFOX: {
			temp = String.format(path, "gekodriver.exe");
			Constant.WEBDRIVER = new FirefoxDriver();
			System.setProperty(browser.getValue(), getProjectPath() + temp);
			Constant.WEBDRIVER.manage().window().maximize();
			Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		}

			break;

		case IE: {
			temp = String.format(path, "IEDriverServer.exe");
			InternetExplorerDriver driver = new InternetExplorerDriver();
			System.setProperty(browser.getValue(), getProjectPath() + temp);
			driver.manage().window().maximize();
			driver.navigate().to(Constant.RAILWAY_URL);
		}

			break;
		}

	}

	public static String generateEmail() {
		long email = System.currentTimeMillis();
		return (String) "my" + email + "@mailinator.com";
	}

	public static String getPreEmail(String email) {
		return email.substring(0, email.length() - 15);
	}

	public static String generateAlphanumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static String generateNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public static void selectRandomValueInList(By locator) {
		List<WebElement> selects = Constant.WEBDRIVER.findElements(locator);
		Random rand = new Random();
		int list = rand.nextInt(selects.size());
		selects.get(list).click();
	}

}
