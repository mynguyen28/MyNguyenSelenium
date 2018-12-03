package Common.Constant;

import org.openqa.selenium.WebDriver;

import Common.Common.Utilities;

public class Constant {

	public static WebDriver WEBDRIVER;
	// public static final String RAILWAY_URL =
	// "http://localhost:8888/Page/HomePage.cshtml";
//	public static final String RAILWAY_URL = "https://dbdeec00.ngrok.io";
	public static final String USERNAME = "my.nguyen@logigear.com";
	public static final String PASSWORD = "123456789";
	public static String MAIL_SYSTEM_URL = "https://www.mailinator.com/v3/index.jsp?zone=public&query=%s#/#inboxpane";
	// public static String NEW_PASSWORD = Utilities.generateAlphanumeric();

	// TIME OUT
	public static final int DEFAULT_TIME = 5;
	public static final int SHORT_TIME = 10;
	public static final int LONG_TIME = 20;

	public static enum PageName {
		HOMEPAGE("Home"), LOGIN("Login"), LOGOUT("Log out"), REGISTER("Register"), MYTICKET(
				"My ticket"), CHANGEPASSWORD("Change password"), BOOKTICKET("Book ticket");

		private final String value;

		PageName(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public static enum Browser {
		FIREFOX, CHROME, INTERNETEXPLORER
	}

}
