package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Common.Element;
import Common.Common.Utilities;
import DataObjects.Ticket;

public class BookTicketPage extends GeneralPage {

	private By cbbDepartDate = By.xpath("//select[@name='Date']");
	private By cbbDepartFrom = By.xpath("//select[@name='DepartStation']");
	private By cbbArriveAt = By.xpath("//select[@name='ArriveStation']");
	private By cbbSeatType = By.xpath("//select[@name='SeatType']");
	private By cbbTicketAmount = By.xpath("//select[@name='TicketAmount']");
	private By btnBookTicket = By.xpath("//input[@value='Book ticket']");
//	private String tblBooked = "//table[@class='MyTable']//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
	private String lblBookedTicketColumn ="//th[normalize-space()='%s']/ancestor::tbody//tr/td[normalize-space()='%s']";
	
	public void bookTicket(Ticket ticket) {
		Element.selectInList(cbbDepartDate, ticket.getDepartDate());
		Element.selectInList(cbbDepartFrom, ticket.getDepartFrom());
		Element.selectInList(cbbArriveAt, ticket.getDepartArrive());
		Element.selectInList(cbbSeatType, ticket.getTypeSeat());
		Element.selectInList(cbbTicketAmount,ticket.getTicketAmount());
		Element.click(btnBookTicket);

	}

	
	public Boolean getValueBookedTicketColumn(String column, String value) {
		String str = String.format(lblBookedTicketColumn, column, value); ;
		return Element.isElementDisplayed(By.xpath(str));
	}

	public Boolean isBookedTicketDisplayed(Ticket ticket) {
		
		getValueBookedTicketColumn("Depart Station", ticket.getDepartFrom());
		getValueBookedTicketColumn("Arrive Station", ticket.getDepartArrive());
		getValueBookedTicketColumn("Seat Type", ticket.getTypeSeat());
		getValueBookedTicketColumn("Depart Date", ticket.getDepartDate());
		getValueBookedTicketColumn("Amount", ticket.getTicketAmount());
		
	}

}
