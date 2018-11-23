package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Message;
import Common.Constant.Constant.PageName;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class RegisterTest extends BasicTest {

	private String passwordRegister = Utilities.generateAlphanumeric(8);
	private String passport = Utilities.generateNumber(9);

//	@Test(description = "TC07 - User can create new account")
//	public void TC07() {
//		loginPage.gotoPage(PageName.REGISTER);
//		registerPage.register(Utilities.generateEmail(6), passwordRegister, passwordRegister, passport);
//		assertEquals(registerPage.getHeaderPage("Register"), Message.thanksMsgRegister);
//	}
//
//	@Test(description = "TC08 - User can't login with an account hasn't been activated")
//	public void TC08() {
//		//pre-conditon: Create a new account but do not activate it
//		loginPage.gotoPage(PageName.REGISTER);
//		registerPage.register(Utilities.generateEmail(6), passwordRegister, passwordRegister, passport);
//		
//		//Testcase:
//		registerPage.gotoPage(PageName.LOGIN);
//		loginPage.login(Utilities.generateEmail(6), passwordRegister);
//		assertEquals(loginPage.getLoginError(), Message.invalidMsgLogin);
//	}
//	
	@Test(description = "TC10 - User can't create account with an already in-use email")
	public void TC10() {
		loginPage.gotoPage(PageName.REGISTER);
		registerPage.register(Constant.USERNAME, Constant.PASSWORD, Constant.PASSWORD, passport);
		assertEquals(loginPage.getLoginError(), Message.existMsgEmail);
	}
	private LoginPage loginPage = new LoginPage();
	private RegisterPage registerPage = new RegisterPage();

}
