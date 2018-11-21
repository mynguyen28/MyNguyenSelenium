package PageObjects.Railway;
public class RegisterPage extends GeneralPage{
	
	//locators
	private final String emailSignup = "email";
	private final String passwordSignup = "password";
	private final String confirmpasswordSignup = "confirmPassword";
	private final String passportSignup = "pid";
	private final String registerSignup = "//input[@title='Register']";
	
	
	//elements

	//methods
	public void register(String email, String password, String confirmpassowrd, String passport)
	{
		idElement(emailSignup).sendKeys(email);
		idElement(passwordSignup).sendKeys(password);
		idElement(confirmpasswordSignup).sendKeys(confirmpassowrd);
		idElement(passportSignup).sendKeys(passport);
		xpathElement(registerSignup).click();
	}
	
	public void getSuccessMessageRegister()
	{
		
	}
	
	

}
