package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Common.Common.Utilities;
import Common.Constant.Message;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class RegisterTest extends BasicTest {

	private String passwordRegister = Utilities.generateAlphanumeric(8);
	private String passport = Utilities.generateNumber(9);

	@Test(description = "TC07 - User can create new account")
	public void TC07() {
		homePage.open();
		loginPage.gotoPage("Register");
		registerPage.register(Utilities.generateEmail(6), passwordRegister, passwordRegister, passport);
		assertEquals(registerPage.getHeaderPage("Register"), Message.thanksMsgRegister);
	}

	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();
	private RegisterPage registerPage = new RegisterPage();

}
