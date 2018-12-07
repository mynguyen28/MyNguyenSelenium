package Railway;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.PageName;
import Common.Constant.Message;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class LoginTest extends BasicTest {

	private String invalidPassword = "invalidPss";

	@BeforeMethod
	public void beforeMethod() {
		homePage.gotoPage(PageName.LOGIN);
	}

	@AfterMethod
	public void afterMethod() {

		homePage.logOut();
	}

	@Test(description = "TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		assertTrue(loginPage.isWelcomeMsgDisplayed(Constant.USERNAME));
	}

	@Test(description = "TC02 - User can't login with blank Username textbox")
	public void TC02() {
		loginPage.login("", Constant.PASSWORD);
		assertEquals(loginPage.getLoginError(), Message.EMPTY_VALUE_LOGIN_MESSAGE);
	}

	@Test(description = "TC03 - User cannot log into Railway with invalid password")
	public void TC03() {
		loginPage.login(Constant.USERNAME, invalidPassword);
		assertEquals(loginPage.getLoginError(), Message.INVALID_LOGIN_MESSAGE);
	}

	@Test(description = "TC04 - Login page displays when un-logged User clicks on Book ticket tab")
	public void TC04() {
		homePage.gotoPage(PageName.BOOKTICKET);
		assertTrue(homePage.isPageSelected(PageName.LOGIN));
	}

	@Test(description = "TC05 - System shows message when user enters wrong password several times")
	public void TC05() {
		loginPage.login(Constant.USERNAME, invalidPassword, 4);
		assertEquals(loginPage.getLoginError(), Message.LOCK_LOGIN_MESSAGE);
	}

	@Test(description = "TC06 - Additional pages display once user logged in")
	public void TC06() throws InterruptedException {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage.isPageDisplayed(PageName.MYTICKET), "my ticket tab");
		softAssert.assertTrue(homePage.isPageDisplayed(PageName.CHANGEPASSWORD), "change tab");
		softAssert.assertTrue(homePage.isPageDisplayed(PageName.LOGOUT), "logout tab");
		homePage.gotoPage(PageName.CHANGEPASSWORD);
		softAssert.assertTrue(homePage.isPageSelected(PageName.CHANGEPASSWORD), "change selected");
		loginPage.gotoPage(PageName.MYTICKET);
		softAssert.assertTrue(homePage.isPageSelected(PageName.MYTICKET), "my ticket selected");
	}

	@Test(description = "TC08 - User can't login with an account hasn't been activated")
	public void TC08() throws InterruptedException {
		// pre-conditon: Create a new account but do not activate it
		loginPage.gotoPage(PageName.REGISTER);
		String email = Utilities.generateEmail();
		registerPage.register(email, Constant.PASSWORD);

		// Testcase:
		registerPage.gotoPage(PageName.LOGIN);
		loginPage.login(email, Constant.PASSWORD);
		assertEquals(loginPage.getLoginError(), Message.INVALID_LOGIN_MESSAGE);
	}

	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();
	private RegisterPage registerPage = new RegisterPage();

}
