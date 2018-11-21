package PageObjects.Railway;

import org.openqa.selenium.WebElement;
import Common.Common.Element;
import Common.Constant.Constant;

public class GeneralPage extends Element{

	private String tabName = "//div[@id='menu']//span[normalize-space()='%s']";
	private String welcomeMsg = "//div[@class='account' and normalize-space()='Welcome %s']";
	private String selectedTab = "//li[@class= 'selected']//span[normalize-space()='%s']";

	// Element
	public String getPageLocator(String pagename) {
		return this.tabName = String.format(this.tabName, pagename);
	}

	protected WebElement getPage(String pagename) {
		return xpathElement(getPageLocator(pagename));
	}

	protected WebElement getWelcomeMsg() {
		this.welcomeMsg = String.format(this.welcomeMsg, Constant.USERNAME);
		return xpathElement(this.welcomeMsg);
	}

	protected WebElement getSelectedPage(String pagename) {

		this.selectedTab = String.format(this.selectedTab, pagename);
		return xpathElement(this.selectedTab);
	}

	// Methods
	public void gotoPage(String pagename) {
		getPage(pagename).click();
	}

	public Boolean isPageSelected(String tabname) {
		return getSelectedPage(tabname).isDisplayed();           
	}

	public Boolean isWelcomeMsgDisplayed() {
		return getWelcomeMsg().isDisplayed();
	}

	public void logOut() {
		if (isElementPresent("xpath", getPageLocator("Log out")) == true) 
		{
			gotoPage("Log out");
		} else
			System.out.println("Not logout");

	}

	public Boolean isPageDisplayed(String pagename) {
		return getPage(pagename).isDisplayed();
	}

	public Boolean isElementPresent(String type, String locator) {
		try {
			Constant.WEBDRIVER.findElement(getLocator(type, locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
