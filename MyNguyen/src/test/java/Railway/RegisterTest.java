package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.PageName;
import Common.Constant.Message;
import PageObjects.Railway.EmailSystemPage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class RegisterTest extends BasicTest {

	@Test(description = "TC07 - User can create new account")
	public void TC07() {
		loginPage.gotoPage(PageName.REGISTER);
		String email = Utilities.generateEmail();
		registerPage.register(email, Constant.PASSWORD);
		assertEquals(registerPage.getHeaderPage(), Message.SUCCESS_REGISTER_MESSAGE);
		emailSystemPage.activeAccountByEmail(email);
	}

	@Test(description = "TC10 - User can't create account with an already in-use email")
	public void TC10() {
		loginPage.gotoPage(PageName.REGISTER);
		registerPage.register(Constant.USERNAME, Constant.PASSWORD);
		assertEquals(registerPage.getErrorMessage(), Message.USED_EMAIL_MESSAGE);
	}

	@Test(description = "TC11 - User can't create account while password and PID fields are empty")
	public void TC11() {
		loginPage.gotoPage(PageName.REGISTER);
		registerPage.register(Constant.USERNAME, "");
		assertEquals(registerPage.getErrorMessage(), Message.ERROR_REGISTER_MESSAGE);
		assertEquals(registerPage.getErrorValidation(), Message.INVALID_PASSWORD_REGISTER_MESSAGE);
		assertEquals(registerPage.getErrorValidation(), Message.INVALID_ID_LENGTH_REGISTER_MESSAGE);
	}

	private LoginPage loginPage = new LoginPage();
	private RegisterPage registerPage = new RegisterPage();
	private EmailSystemPage emailSystemPage = new EmailSystemPage();

}
