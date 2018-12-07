package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.Constant.Message;
import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.PageName;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.EmailSystemPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class ChangePasswordTest extends BasicTest {

	@BeforeMethod
	public void beforeMethod() {
		homePage.gotoPage(PageName.LOGIN);
	}

	@AfterMethod
	public void afterMethod() {

		loginPage.logOut();
	}

	@Test(description = "TC09 - User can change password")
	public void TC09() {
		loginPage.gotoPage(PageName.REGISTER);
		String email = Utilities.generateEmail();
		registerPage.register(email, Constant.PASSWORD);
		emailSystemPage.activeAccountByEmail(email);

		registerPage.gotoPage(PageName.LOGIN);
		loginPage.login(email, Constant.PASSWORD);
		loginPage.gotoPage(PageName.CHANGEPASSWORD);
		changePasswordPage.changePassword(Constant.PASSWORD, Constant.NEW_PASSWORD);
		assertEquals(changePasswordPage.getSuccessMessageChangePassword(), Message.SUCCESS_CHANGE_PASSWORD_MESSAGE);
	}

	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();
	private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
	private RegisterPage registerPage = new RegisterPage();
	private EmailSystemPage emailSystemPage = new EmailSystemPage();
}
