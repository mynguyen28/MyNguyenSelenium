package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Common.Element;
import Common.Constant.Constant;

public class GeneralPage extends Element {

	private String tabName = "//div[@id='menu']//span[normalize-space()='%s']";
	private String welcomeMsg = "//div[@class='account' and normalize-space()='Welcome %s']";
	private String selectedTab = "//li[@class= 'selected']//span[normalize-space()='%s']";
	private final By headerPage = By.xpath("//h1[@align='center']");

	// Elements
	public By getPageLocator(String pagename) {
		this.tabName = String.format(this.tabName, pagename);
		By tabname = By.xpath(tabName);
		return tabname;
	}

	protected WebElement getPage(String pagename) {
		return findElement(getPageLocator(pagename));
	}

	protected WebElement getSelectedPage(String pagename) {

		this.selectedTab = String.format(this.selectedTab, pagename);
		By selectedtab = By.xpath(selectedTab);
		return findElement(selectedtab);
	}

	protected WebElement getWelcomeMsg() {
		this.welcomeMsg = String.format(this.welcomeMsg, Constant.USERNAME);
		By welmsg = By.xpath(welcomeMsg);
		return findElement(welmsg);
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
		if (isElementPresent(getPageLocator("Log out")) == true) {
			gotoPage("Log out");
		} else
			System.out.println("Not logout");
	}

	public Boolean isPageDisplayed(String pagename) {
		return getPage(pagename).isDisplayed();
	}

	public String getHeaderPage(String pagename)
	{
		return findElement(headerPage).getText();
	}

}
