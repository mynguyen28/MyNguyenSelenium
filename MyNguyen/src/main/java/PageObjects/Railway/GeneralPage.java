package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Common.Element;
import Common.Constant.Constant.PageName;

public class GeneralPage {

	private String tabName = "//div[@id='menu']//span[normalize-space()='%s']";
	private String welcomeMsg = "//div[@class='account' and normalize-space()='%s']";
	private String selectedTab = "//li[@class= 'selected']//span[normalize-space()='%s']";
	private By lblheaderPage = By.xpath("//h1[@align='center']");
	private By msgError = By.xpath("//p[@class='message error']");
	private By lblErrorValidation = By.xpath("//label[@class='validation-error']");

	// Elements
	public By getPageLocator(String pageName) {
		String str = String.format(this.tabName, pageName);
		;
		return (By) By.xpath(str);
	}

	protected WebElement getPage(String pageName) {
		return Element.findElement(getPageLocator(pageName));
	}

	protected By getSelectedPage(String pageName) {

		String str = String.format(this.selectedTab, pageName);
		return (By) By.xpath(str);
	}

	protected By getWelcomeMsg(String userName) {
		String str = String.format(this.welcomeMsg, "Welcome " + userName);
		return (By) By.xpath(str);
	}

	// Methods
	public String getErrorMessage() {
		return Element.getText(msgError);
	}

	public void gotoPage(PageName pageName) {
		getPage(pageName.getValue()).click();
	}

	public Boolean isPageSelected(PageName pageName) {
		return Element.isElementDisplayed(getSelectedPage(pageName.getValue()));
	}

	public Boolean isWelcomeMsgDisplayed(String userName) {
		return Element.isElementDisplayed(getWelcomeMsg(userName));
	}

	public Boolean isPageDisplayed(PageName pageName) {
		return Element.isElementDisplayed(getPageLocator(pageName.getValue()));
	}

	public void logOut() {
		if (Element.isElementDisplayed(getPageLocator(PageName.LOGOUT.getValue())) == true) {
			gotoPage(PageName.LOGOUT);
		} else
			System.out.println("Not logout");
	}

	public String getHeaderPage() {
		return Element.getText(lblheaderPage);
	}

	public String getErrorValidation() {
		return Element.getText(lblErrorValidation);
	}
}
