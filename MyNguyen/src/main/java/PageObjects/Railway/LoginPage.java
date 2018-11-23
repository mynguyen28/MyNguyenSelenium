package PageObjects.Railway;

import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {

	private final By txtusername = By.id("username");
	private final By txtpassword = By.id("password");
	private final By btnlogin = By.xpath("//input[@title='Login']");
	private final By msgloginError = By.xpath("//p[@class='message error LoginForm']");

	// Methods
	public void login(String username, String password) {
		findElement(txtusername).sendKeys(username);
		findElement(txtpassword).sendKeys(password);
		findElement(btnlogin).click();
	}

	public String getLoginError() {
		return findElement(msgloginError).getText();
	}

	public void login(String username, String password, int times) {
		for (int i = 0; i < times; i++) {
			login(username, password);
		}
	}

}
