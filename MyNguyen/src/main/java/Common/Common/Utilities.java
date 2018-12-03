package Common.Common;

import Common.Constant.Constant;
import Common.Constant.Constant.Browser;

public class Utilities {
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public static void openRailWay(Browser browser) {
		WebdriverManager webdriverManager = new WebdriverManager();
		Constant.WEBDRIVER = webdriverManager.getDriver();
		Constant.WEBDRIVER.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

	}

	public static String generateEmail() {
		long email = System.currentTimeMillis();
		return (String) "my" + email + "@mailinator.com";
	}

	public static String getPreEmail(String email) {
		return email.substring(0, email.length() - 15);
	}

}
