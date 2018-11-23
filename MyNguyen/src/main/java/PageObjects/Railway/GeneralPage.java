package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Common.Element;
import Common.Constant.Constant;
import Common.Constant.Constant.PageName;

public class GeneralPage extends Element {

	private String tabName = "//div[@id='menu']//span[normalize-space()='%s']";
	private String welcomeMsg = "//div[@class='account' and normalize-space()='Welcome %s']";
	private String selectedTab = "//li[@class= 'selected']//span[normalize-space()='%s']";
	private final By lblheaderPage = By.xpath("//h1[@align='center']");

	// Elements
	public By getPageLocator(String pagename) {
		String str = String.format(this.tabName, pagename);
		By tabname = By.xpath(str);
		return tabname;
	}

	protected WebElement getPage(String pagename) {
		return findElement(getPageLocator(pagename));
	}

	protected By getSelectedPage(String pagename) {

		String str = String.format(this.selectedTab, pagename);
		By selectedtab = By.xpath(str);
		return selectedtab;
	}

	protected By getWelcomeMsg() {
		this.welcomeMsg = String.format(this.welcomeMsg, Constant.USERNAME);
		By welmsg = By.xpath(welcomeMsg);
		return welmsg;
	}

	// Methods
	public void gotoPage(PageName pagename) {
		getPage(pagename.getValue()).click();
	}

	public Boolean isPageSelected(PageName pagename) {
		return isElementDisplayed(getSelectedPage(pagename.getValue()));
	}

	public Boolean isWelcomeMsgDisplayed() {
		return isElementDisplayed(getWelcomeMsg());
	}

	public Boolean isPageDisplayed(PageName pagename)
	{
		return isElementDisplayed(getPageLocator(pagename.getValue()));
	}
	public void logOut() {
		if (isElementDisplayed(getPageLocator(PageName.LOGOUT.getValue())) == true) {
			gotoPage(PageName.LOGOUT);
		} else
			System.out.println("Not logout");
	}

	public String getHeaderPage(String pagename)
	{
		return findElement(lblheaderPage).getText();
	}

}
