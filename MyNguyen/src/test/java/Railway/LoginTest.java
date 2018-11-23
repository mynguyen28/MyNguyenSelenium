package Railway;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.logging.Logger;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.Constant.Constant;
import Common.Constant.Constant.PageName;
import Common.Constant.Message;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class LoginTest extends BasicTest {

	private String invalidPassword = "invalidPss";

	@BeforeMethod
	protected void beforeMethod() {
		homePage.gotoPage(PageName.LOGIN);
	}

	@AfterMethod
	protected void afterMethod() {

		loginPage.logOut();
	}

	@Test(description = "TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		assertTrue(loginPage.isWelcomeMsgDisplayed());
	}

	@Test(description = "TC02 - User can't login with blank Username textbox")
	public void TC02() {
		loginPage.login("", Constant.PASSWORD);
		assertEquals(loginPage.getLoginError(), Message.emptyValueMsgLogin);
	}

	@Test(description = "TC03 - User cannot log into Railway with invalid password")
	public void TC03() {
		loginPage.login(Constant.USERNAME, invalidPassword);
		assertEquals(loginPage.getLoginError(), Message.invalidMsgLogin);
	}

	@Test(description = "TC04 - Login page displays when un-logged User clicks on Book ticket tab")
	public void TC04() {
		homePage.gotoPage(PageName.BOOKTICKET);
		assertTrue(homePage.isPageSelected(PageName.LOGIN));
	}

	@Test(description = "TC05 - System shows message when user enters wrong password several times")
	public void TC05() {
		loginPage.login(Constant.USERNAME, invalidPassword, 4);
		assertEquals(loginPage.getLoginError(), Message.lockMsgLogin);
	}

	@Test(description = "TC06 - Additional pages display once user logged in")
	public void TC06() throws InterruptedException {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		assertTrue(loginPage.isPageDisplayed(PageName.MYTICKET), "my ticket tab");
		assertTrue(loginPage.isPageDisplayed(PageName.CHANGEPASSWORD), "change tab");
		assertTrue(loginPage.isPageDisplayed(PageName.LOGOUT), "logout tab");
		loginPage.gotoPage(PageName.CHANGEPASSWORD);
		assertTrue(loginPage.isPageSelected(PageName.CHANGEPASSWORD), "change selected");
		loginPage.gotoPage(PageName.MYTICKET);
		assertTrue(loginPage.isPageSelected(PageName.MYTICKET), "my ticket selected");
	}

	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();

}
