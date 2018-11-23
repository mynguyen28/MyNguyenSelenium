package Common.Constant;
import org.openqa.selenium.WebDriver;


public class Constant {
	
	public static WebDriver WEBDRIVER;
	public static final String RAILWAY_URL = "http://localhost:8888/Page/HomePage.cshtml";
	public static final String USERNAME = "my.nguyen@logigear.com";
	public static final String PASSWORD = "123456789";

	public static enum PageName{
		HOMEPAGE("Home"),
		LOGIN("Login"),
		LOGOUT("Log out"),
		REGISTER("Register"),
		MYTICKET("My ticket"),
		CHANGEPASSWORD("Change password"),
		BOOKTICKET("Book ticket");

		private final String value;
		PageName(String value) { this.value = value; }
	    public String getValue() { return value; }
	}
}
