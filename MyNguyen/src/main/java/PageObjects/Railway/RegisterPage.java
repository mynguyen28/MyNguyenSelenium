package PageObjects.Railway;

import org.openqa.selenium.By;

public class RegisterPage extends GeneralPage {

	private final By txtemail = By.id("email");
	private final By txtpassword = By.id("password");
	private final By txtconfirmpassword = By.id("confirmPassword");
	private final By txtpassport = By.id("pid");
	private final By btnregister = By.xpath("//input[@title='Register']");

	// methods
	public void register(String email, String password, String confirmpassowrd, String passport) {
		findElement(txtemail).sendKeys(email);
		findElement(txtpassword).sendKeys(password);
		findElement(txtconfirmpassword).sendKeys(confirmpassowrd);
		findElement(txtpassport).sendKeys(passport);
		findElement(btnregister).click();
	}
}
