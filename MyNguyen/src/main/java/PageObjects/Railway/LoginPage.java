package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant.Constant;

public class LoginPage extends GeneralPage{
	
	private final String username = "username";
	private final String password = "password";
	private final String login = "//input[@title='Login']";
	private final String loginError = "//p[@class='message error LoginForm']";
	
	public WebElement getEleUsername()
	{
		return Constant.WEBDRIVER.findElement(By.id(username));
	}

	public WebElement getElePassword()
	{
		return Constant.WEBDRIVER.findElement(By.id(password));
	}
	
	public WebElement getEleLogin()
	{
		return Constant.WEBDRIVER.findElement(By.xpath(login));
	}
	
	public WebElement getEleLoginError()
	{
		return Constant.WEBDRIVER.findElement(By.xpath(loginError));
	}
	
	//Methods
	public void login(String username, String password)
	{
		getEleUsername().sendKeys(username);
		getElePassword().sendKeys(password);
		getEleLogin().click();
	}

	public String getLoginError()
	{
		return getEleLoginError().getText();
	}
	
	public void login(String username, String password, int times)
	{
		for (int i = 0; i < times; i++) {
			login(username, password);
		}
	}

}
