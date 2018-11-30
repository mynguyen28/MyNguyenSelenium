package PageObjects.Railway;

import org.openqa.selenium.By;

import Common.Common.Element;

public class ChangePasswordPage extends GeneralPage{
	
	private final By txtCurrentPassword = By.id("currentPassword");
	private final By txtNewPassword = By.id("newPassword");
	private final By txtConfirmPassword = By.id("confirmPassword");
	private final By btnChangePassword = By.xpath("//input[@title='Change password']");
	private final By msgSuccessChangePassword = By.xpath("//p[@class='message success']");

	public void changePassword(String currentPassword, String newPassword, String confirmPassword)
	{
		Element.enter(txtCurrentPassword, currentPassword);
		Element.enter(txtNewPassword, newPassword);
		Element.enter(txtConfirmPassword, confirmPassword);
		Element.click(btnChangePassword);
	}
	public void changePassword(String currentPassword, String newPassword)
	{
		changePassword(currentPassword, newPassword, newPassword);
	}
	
	public String getSuccessMessageChangePassword()
	{
		return Element.getText(msgSuccessChangePassword);
	}
	
}
