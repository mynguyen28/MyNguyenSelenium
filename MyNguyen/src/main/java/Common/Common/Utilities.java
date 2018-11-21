package Common.Common;

import org.openqa.selenium.chrome.ChromeDriver;

import Common.Constant.Constant;

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
	
	public static void generateEmail()
	{
		
	}

}
