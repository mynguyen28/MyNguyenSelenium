package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Common.Common.Utilities;
import Common.Constant.Message;
import Common.Constant.Constant;
import Common.Constant.Constant.PageName;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class ChangePasswordTest extends BasicTest{

	private String passport = Utilities.generateNumber(9);

	@Test(description = "TC09 - User can't change password when New Password and Confirm Password are different.")
	public void TC09() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		loginPage.gotoPage(PageName.CHANGEPASSWORD);
		
		
	}
	private LoginPage loginPage = new LoginPage();
	private RegisterPage registerPage = new RegisterPage();
}
