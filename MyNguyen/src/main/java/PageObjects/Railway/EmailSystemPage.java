package PageObjects.Railway;

import org.openqa.selenium.By;

import Common.Common.Element;
import Common.Common.Utilities;
import Common.Constant.Constant;

public class EmailSystemPage {

	private By mailBox = By.xpath("//tr[@class='even pointer ng-scope'][1]");
	private By lnkConfirmRegister = By.xpath("//a[contains(@href,'Confirm')]");
	private By lnkResetPassword = By.xpath("//a[contains(@href,'Reset')]");
	private String iframeMailMessage = "msg_body";

	private String getUrlMail(String email) {
		return String.format(Constant.MAIL_SYSTEM_URL, Utilities.getPreEmail(email));
	}

	private void confirmByEmail(String email, By link) {
		Constant.WEBDRIVER.navigate().to(getUrlMail(email));
		Element.click(mailBox);
		Constant.WEBDRIVER.switchTo().frame(iframeMailMessage);
		Constant.WEBDRIVER.navigate().to(Element.getText(link));
	}

	public void activeAccountByEmail(String email) {
		confirmByEmail(email, lnkConfirmRegister);
	}

	public void resetPasswordByEmail(String email) {
		confirmByEmail(email, lnkResetPassword);
	}

}
