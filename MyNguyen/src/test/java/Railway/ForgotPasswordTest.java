package Railway;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.PageName;
import Common.Constant.Message;
import PageObjects.Railway.EmailSystemPage;
import PageObjects.Railway.ForgotPasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class ForgotPasswordTest extends BasicTest{

	@BeforeMethod
	public void beforeMethod() {
		homePage.gotoPage(PageName.LOGIN);
	}

	@AfterMethod
	public void afterMethod() {

		homePage.logOut();
	}

	@Test(description = "TC12 - Errors display when password reset token is blank")
	public void TC12() {
		// pre-condition: Create and activate a new account
		loginPage.gotoPage(PageName.REGISTER);
		String email = Utilities.generateEmail();
		registerPage.register(email, Constant.PASSWORD);
		emailSystemPage.activeAccountByEmail(email);

		// step
		loginPage.gotoPage(PageName.LOGIN);
		loginPage.gotoForgotPasswordPage();
		forgotPasswordPage.resetInstructionsPassword(email);
		emailSystemPage.resetPasswordByEmail(email);
		assertTrue(forgotPasswordPage.isForgotPasswordFormDisplayed());
		forgotPasswordPage.resetPasswordWithClearToken(Constant.PASSWORD);
		assertEquals(forgotPasswordPage.getErrorMessage(), Message.FAILED_RESET_PASSWORD_MESSAGE);
		assertEquals(forgotPasswordPage.getErrorValidation(), Message.EMPTY_RESET_TOKEN_MESSAGE);
	}

	@Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password")
	public void TC13() {
		// pre-condition: Create and activate a new account
		loginPage.gotoPage(PageName.REGISTER);
		String email = Utilities.generateEmail();
		registerPage.register(email, Constant.PASSWORD);
		emailSystemPage.activeAccountByEmail(email);

		// step
		loginPage.gotoPage(PageName.LOGIN);
		loginPage.gotoForgotPasswordPage();
		forgotPasswordPage.resetInstructionsPassword(email);
		
		//
		emailSystemPage.resetPasswordByEmail(email);
		//
		assertTrue(forgotPasswordPage.isForgotPasswordFormDisplayed());
		forgotPasswordPage.resetPassword(Constant.NEW_PASSWORD, Constant.NEW_PASSWORD+1);
		assertEquals(forgotPasswordPage.getErrorMessage(), Message.ERROR_RESET_PASSWORD_MESSAGE);
		assertEquals(forgotPasswordPage.getErrorValidation(), Message.NOT_MATCH_RESET_PASSWORD_MESSAGE);
	}

	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();
	private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	private RegisterPage registerPage = new RegisterPage();
	private EmailSystemPage emailSystemPage = new EmailSystemPage();
}
