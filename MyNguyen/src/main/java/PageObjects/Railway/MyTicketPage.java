package PageObjects.Railway;

import org.openqa.selenium.By;

import Common.Common.Element;
import Common.Constant.Constant;
import DataObjects.Ticket;

public class MyTicketPage extends GeneralPage {

	private String btnCancelTicket = "//table[@class='MyTable']//tr[td[2][text()='%s']][td[3][text()='%s']][td[4][text()='%s']][td[5][text()='%s']][td[9][text()='%s']]//input[@value='Cancel']";
	private By btnCancel = By.xpath("//input[@value='Cancel']");
	private By cbbDepartStationFilter = By.xpath("//select[@name='FilterDpStation']");
	private By cbbStatus = By.xpath("//select[@name='FilterStatus']");
	private By btnFilter = By.xpath("//input[@value='Apply filter']");
	private By lblError = By.xpath("//div[@class='error message']");

	public By getCancelBookedTicket(Ticket ticket) {
		String str = String.format(btnCancelTicket, ticket.getDepartFrom(), ticket.getDepartArrive(),
				ticket.getTypeSeat(), ticket.getDepartDate(), String.valueOf(ticket.getTicketAmount()));
		return By.xpath(str);
	}

	public void cancelBookedTicket(Ticket ticket) {

		int num = Element.countElements(getCancelBookedTicket(ticket));
		for (int i = 0; i < num; i++) {
			Element.click(getCancelBookedTicket(ticket));
			Constant.WEBDRIVER.switchTo().alert().accept();
		}
	}

	public void cancelAllBookedTicketDisplayed() {
		while (Element.isElementDisplayed(btnCancel)) {
			Element.click(btnCancel);
			Constant.WEBDRIVER.switchTo().alert().accept();
		}
	}

	public Boolean isBookedTicketCancelDisplayed(Ticket ticket) {
		return Element.isElementDisplayed(getCancelBookedTicket(ticket));
	}

	public void filter(By locator, String value) {
		Element.selectInList(locator, value);
		Element.click(btnFilter);
	}

	public void filterDepartStationFilter(Ticket ticket) {
		filter(cbbDepartStationFilter, ticket.getDepartFrom());
	}

	public void filterStatusFilter(String status) {
		filter(cbbStatus, status);
	}

	public String getErrorFilter() {
		return Element.getText(lblError);
	}

}
