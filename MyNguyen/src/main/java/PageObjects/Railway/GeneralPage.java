package PageObjects.Railway;

import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Constant.Constant;

public class GeneralPage {

//	Locators
//	private final String tabName = "//div[@id='menu']//span[normalize-space()='%s']";
//	private final String welcomeMsg = "//div[@class='account' and normalize-space()='Welcome "+ Constant.USERNAME +"']";
//	private final String selectedTab = "//li[@class= 'selected']//span[normalize-space()='%s']";
//	Elements
//	protected WebElement getPage(String pagename)
//	{
//		String pageName= String.format(this.tabName,pagename);
//		return Constant.WEBDRIVER.findElement(By.xpath(pageName));
//	}
//
//	protected WebElement getWelcomeMsg()
//	{
//		return Constant.WEBDRIVER.findElement(By.xpath(welcomeMsg));
//	}
//	
//	protected WebElement getSelectedPage(String pagename)
//	{
//		String selectedPage = String.format(this.selectedTab,pagename);
//		return Constant.WEBDRIVER.findElement(By.xpath(selectedPage));
//	}
	
	//example:
	private String tabName = "//div[@id='menu']//span[normalize-space()='%s']";
	private String welcomeMsg = "//div[@class='account' and normalize-space()='Welcome %s']";
	private String selectedTab = "//li[@class= 'selected']//span[normalize-space()='%s']";

	protected By getLocator(String locator, String str)
	{
		locator = String.format(locator, str);
		By by = By.xpath(locator);
		return by;
	}
	
	protected By getLocatorPage(String pagename)
	{
		return getLocator(tabName, pagename);
	}
	
	protected WebElement getPage(String pagename)
	{
		return Constant.WEBDRIVER.findElement(getLocatorPage(pagename));
	}
	
	protected WebElement getWelcomeMsg()
	{
		return Constant.WEBDRIVER.findElement(getLocator(welcomeMsg, Constant.USERNAME));
	}
	
	protected WebElement getSelectedPage(String pagename)
	{
//		this.selectedTab = String.format(this.selectedTab, pagename);
		return Constant.WEBDRIVER.findElement(getLocator(selectedTab, pagename));
	}
	
	
	//Methods
	public void gotoPage(String pagename)
	{
		getPage(pagename).click();
	}

	public Boolean isPageSelected(String tabname)
	{
		return getSelectedPage(tabname).isDisplayed();
	}

	public Boolean isWelcomeMsgDisplayed()
	{
		return getWelcomeMsg().isDisplayed();
	}
	
	public void logOut()
	{
		if (isElementPresent(getLocatorPage("Log out"))==true)
		{
			gotoPage("Log out");
		}
		else System.out.println("Not logout");
		
	}
	
	public Boolean isPageDisplayed(String pagename)
	{
		return getPage(pagename).isDisplayed();
	}


	public Boolean isElementPresent(By by)
	{
	    try
	    {
	        Constant.WEBDRIVER.findElement(by);
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	}
	
	
}

