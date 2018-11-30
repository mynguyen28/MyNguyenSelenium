package Common.Constant;

import org.openqa.selenium.WebDriver;

import Common.Common.Utilities;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static final String RAILWAY_URL = "http://localhost:8888/Page/HomePage.cshtml";
	public static final String USERNAME = "my.nguyen@logigear.com";
	public static final String PASSWORD = "123456789";
	public static String MAIL_SYSTEM_URL = "https://www.mailinator.com/v3/index.jsp?zone=public&query=%s#/#inboxpane";
	public static String NEW_PASSWORD = Utilities.generateAlphanumeric(8);

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
		CHROME("webdriver.chrome.driver"), FIREFOX("webdriver.gecko.driver"), IE("webdriver.ie.driver");

		private final String browser;

		Browser(String browser) {
			this.browser = browser;
		}

		public String getValue() {
			return browser;
		}
	}

	public static enum Location {
		SAIGON("Sài Gòn"), PHANTHIET("Phan Thiết"), NHATRANG("Nha Trang"), DANANG("Đà Nẵng"), HUE("Huế"), QUANGNGAI(
				"Quảng Ngãi");

		private final String location;

		Location(String location) {
			this.location = location;
		}

		public String getValue() {
			return location;
		}
	}

	public static enum SeatType
	{
		HARD_SEAT("Hard seat"), SOFT_SEAT("Soft seat"), SOFT_SEAT_AIR_CONDITIONER(
				"Soft seat with air conditioner"), HARD_BED(
						"Hard bed"), SOFT_BED("Soft bed"), SOFT_BED_AIR_CONDITIONER("Soft bed with air conditioner");

		private final String type;

		SeatType(String type) {
			this.type = type;
		}

		public String getValue() {
			return type;
		}
	}
}
