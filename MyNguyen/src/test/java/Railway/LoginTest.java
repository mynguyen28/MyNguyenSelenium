package Railway;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import Common.Constant.Constant;
import Common.Constant.Message;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class LoginTest extends  BasicTest{

	private String invalidPassword = "invalidPss";

	@Test(description = "TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		homePage.open();
		homePage.gotoPage("Login");
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		assertTrue(loginPage.isWelcomeMsgDisplayed());
	}

	@Test(description = "TC02 - User can't login with blank Username textbox")
	public void TC02() {
		homePage.open();
		homePage.gotoPage("Login");
		loginPage.login("", Constant.PASSWORD);
		assertEquals(loginPage.getLoginError(), Message.emptyValueMsgLogin);
	}

	@Test(description = "TC03 - User cannot log into Railway with invalid password")
	public void TC03() {
		homePage.open();
		homePage.gotoPage("Login");
		loginPage.login(Constant.USERNAME, invalidPassword);
		assertEquals(loginPage.getLoginError(), Message.invalidMsgLogin);
	}

	@Test(description = "TC04 - Login page displays when un-logged User clicks on Book ticket tab")
	public void TC04() {
		homePage.open();
		homePage.gotoPage("Book ticket");
		assertTrue(homePage.isPageSelected("Login"));
	}

	@Test(description = "TC05 - System shows message when user enters wrong password several times")
	public void TC05() {
		homePage.open();
		homePage.gotoPage("Login");
		loginPage.login(Constant.USERNAME, invalidPassword, 4);
		assertEquals(loginPage.getLoginError(), Message.lockMsgLogin);
	}

	@Test(description = "TC06 - Additional pages display once user logged in")
	public void TC06() {
		homePage.open();
		homePage.gotoPage("Login");
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		assertTrue(loginPage.isPageDisplayed("My ticket"));
		assertTrue(loginPage.isPageDisplayed("Change password"));
		assertTrue(loginPage.isPageDisplayed("Log out"));
		loginPage.gotoPage("My ticket");
		assertTrue(loginPage.isPageSelected("My ticket"));
		loginPage.gotoPage("Change password");
		assertTrue(loginPage.isPageSelected("Change password"));
	}
	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();

}
