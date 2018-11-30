package PageObjects.Railway;

import org.openqa.selenium.By;

import Common.Common.Element;
import Common.Constant.Constant;

public class RegisterPage extends GeneralPage {

	private By txtEmail = By.id("email");
	private By txtPassword = By.id("password");
	private By txtConfirmpassword = By.id("confirmPassword");
	private By txtPassport = By.id("pid");
	private By btnRegister = By.xpath("//input[@title='Register']");
	private By lblRegistrationConfirmed = By.xpath("//div[@id='content']");

	// methods
	public void register(String email, String password, String confirmPassowrd) {
		Element.enter(txtEmail, email);
		Element.enter(txtPassword, password);
		Element.enter(txtConfirmpassword, confirmPassowrd);
		Element.enter(txtPassport, Constant.PASSWORD);
		Element.click(btnRegister);
	}

	public void register(String email, String password) {
		register(email, password, password);
	}

	public String getRegistrationConfirmedMessage()
	{
		return Element.getText(lblRegistrationConfirmed);
	}
}
