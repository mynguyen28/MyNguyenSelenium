package PageObjects.Railway;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import Common.Common.Element;
import DataObjects.Ticket;

public class BookTicketPage extends GeneralPage {

	private By cbbDepartDate = By.xpath("//select[@name='Date']");
	private By cbbDepartFrom = By.xpath("//select[@name='DepartStation']");
	private By cbbArriveAt = By.xpath("//select[@name='ArriveStation']");
	private By cbbSeatType = By.xpath("//select[@name='SeatType']");
	private By cbbTicketAmount = By.xpath("//select[@name='TicketAmount']");
	private By btnBookTicket = By.xpath("//input[@value='Book ticket']");
	private String lblBookedTicketColumn = "//table//td[count(//th[text()='%s']/preceding-sibling::th)+1]";
	private String lblSelectedValue = "//select[@name='%s']/option[@selected='selected']";
	private String btnCancel = "//table[@class='MyTable']//tr[td[2][text()='%s']][td[3][text()='%s']][td[4][text()='%s']][td[5][text()='%s']][td[9][text()='%s']]//input[@value='Cancel']";

	public void bookTicket(Ticket ticket) {
		Element.selectInList(cbbDepartDate, ticket.getDepartDate());
		Element.selectInList(cbbDepartFrom, ticket.getDepartFrom());
		Element.selectInList(cbbArriveAt, ticket.getDepartArrive());
		Element.selectInList(cbbSeatType, ticket.getTypeSeat());
		Element.selectInList(cbbTicketAmount, String.valueOf(ticket.getTicketAmount()));
		Element.click(btnBookTicket);

	}

	public String getValueBookedTicketColumn(String column) {
		String str = String.format(lblBookedTicketColumn, column);
		return Element.getText(By.xpath(str));
	}

	public String getSelectValue(String field) {
		String str = String.format(lblSelectedValue, field);
		return Element.getText(By.xpath(str));
	}

	public Boolean isBookedTicketDisplayed(Ticket ticket) {

		String[] columnList = new String[] { "Depart Station", "Arrive Station", "Seat Type", "Depart Date", "Amount" };
		String[] values = new String[] { ticket.getDepartFrom(), ticket.getDepartArrive(), ticket.getTypeSeat(),
				ticket.getDepartDate(), String.valueOf(ticket.getTicketAmount()) };
		Boolean result = null;
		for (int i = 0; i < columnList.length; i++) {
			result = getValueBookedTicketColumn(columnList[i]).equals(values[i]);
			System.out.println(result);
			if (result == false)
				break;
		}
		return result;

	}

	public Boolean isSelectedValueDisplayed(Ticket ticket) {
		String[] fieldList = new String[] { "DepartStation", "ArriveStation" };
		String[] values = new String[] { ticket.getDepartFrom(), ticket.getDepartArrive() };
		Boolean result = false;
		for (int i = 0; i < fieldList.length; i++) {
			result = getSelectValue(fieldList[i]).equals(values[i]);
			if (result == false)
				break;
		}
		return result;
	}

	public void cancelBookedTicket(Ticket ticket) {
		String str = String.format(btnCancel, ticket.getDepartFrom(), ticket.getDepartArrive(), ticket.getTypeSeat(),
				ticket.getDepartDate(), String.valueOf(ticket.getTicketAmount()));
		Element.click(By.xpath(str));

	}

	public void cancelBookedTicket(Ticket ticket, int times) {

	}
}
