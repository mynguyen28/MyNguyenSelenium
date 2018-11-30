package PageObjects.Railway;

import org.openqa.selenium.By;

import Common.Common.Element;

public class LoginPage extends GeneralPage {

	private final By txtusername = By.id("username");
	private final By txtpassword = By.id("password");
	private final By btnlogin = By.xpath("//input[@title='Login']");
	private final By msgloginError = By.xpath("//p[@class='message error LoginForm']");
	private final By lnkForgotPassword = By.xpath("//a[contains(@href,'Forgot')]");

	// Methods
	public void login(String username, String password) {
		Element.enter(txtusername, username);
		Element.enter(txtpassword, password);
		Element.click(btnlogin);
	}

	public String getLoginError() {
		return Element.getText(msgloginError);
	}

	public void login(String username, String password, int times) {
		for (int i = 0; i < times; i++) {
			login(username, password);
		}
	}

	public void gotoForgotPasswordPage() {
		Element.click(lnkForgotPassword);
		//wait for page load
	}
}
