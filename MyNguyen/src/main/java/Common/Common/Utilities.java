package Common.Common;

import org.openqa.selenium.chrome.ChromeDriver;
import Common.Constant.Constant;
import org.apache.commons.lang3.RandomStringUtils;

public class Utilities {
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				Utilities.getProjectPath() + "\\src\\main\\java\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static String generateEmail(int length) {

		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
		String temp = RandomStringUtils.random(length, allowedChars);
		String email = temp + "@logigear.org";
		return email;
	}

	public static String generateAlphanumeric(int length)
	{
		return RandomStringUtils.randomAlphanumeric(length);
		
	}

	public static String generateNumber(int length)
	{
		return RandomStringUtils.randomNumeric(length);
	}
}
