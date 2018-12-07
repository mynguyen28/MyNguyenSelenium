package PageObjects.Railway;

import org.openqa.selenium.By;

import Common.Common.Element;

public class ForgotPasswordPage extends GeneralPage {

	private By txtEmail = By.id("email");
	private By btnSendInstructions = By.xpath("//input[@value='Send Instructions']");
	private By lblForgotPasswordForm = By.xpath("//legend[normalize-space()='Password Change Form']");
	private By txtNewPassword = By.id("newPassword");
	private By txtConfirmPassword = By.id("confirmPassword");
	private By btnResetPasswod = By.xpath("//input[@title='Reset password']");
	private By txtResetToken = By.id("resetToken");

	public void resetInstructionsPassword(String email) {
		Element.enter(txtEmail, email);
		Element.click(btnSendInstructions);
	}

	public Boolean isForgotPasswordFormDisplayed() {
		return Element.isElementDisplayed(lblForgotPasswordForm);
	}

	public void resetPassword(String password, String confirmPassword) {
		Element.enter(txtNewPassword, password);
		Element.enter(txtConfirmPassword, confirmPassword);
		Element.click(btnResetPasswod);
	}

	public void resetPassword(String password) {
		resetPassword(password, password);
	}

	public void resetPasswordWithClearToken(String password) {
		Element.enter(txtNewPassword, password);
		Element.enter(txtConfirmPassword, password);
		Element.clear(txtResetToken);
		Element.click(btnResetPasswod);
	}

}
