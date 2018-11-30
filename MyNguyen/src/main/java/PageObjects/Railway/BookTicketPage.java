package PageObjects.Railway;

import org.openqa.selenium.By;

import Common.Common.Element;
import Common.Constant.Constant.Location;
import Common.Constant.Constant.SeatType;

public class BookTicketPage extends GeneralPage {

	private By cbbDepartDate = By.xpath("//select[@name='Date']");
	private By cbbDepartFrom = By.xpath("//select[@name='DepartStation']");
	private By cbbArriveAt = By.xpath("//select[@name='ArriveStation']");
	private By cbbSeatType = By.xpath("//select[@name='SeatType']");
	private By cbbTicketAmount = By.xpath("//select[@name='TicketAmount']");
	private By btnBookTicket = By.xpath("//input[@value='Book ticket']");
	private String tblBooked = "//table[@class='MyTable']//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";

	public void bookTicket(String departDate, Location departFrom, Location arriveAt, SeatType seatType,
			String ticketAmount) {
		Element.selectInList(cbbDepartDate, departDate);
		Element.selectInList(cbbDepartFrom, departFrom.getValue());
		Element.selectInList(cbbArriveAt, arriveAt.getValue());
		Element.selectInList(cbbSeatType, seatType.getValue());
		Element.selectInList(cbbTicketAmount, ticketAmount);
		Element.click(btnBookTicket);

	}

	public By getBookedTicket(String departDate, String departFrom, String arriveAt, String seatType,
			String ticketAmount) {
		String temp = String.format(tblBooked, departFrom, arriveAt, seatType, departDate, ticketAmount);
		System.out.println(temp);
		By by = By.xpath(temp);
		return by;
	}

	public Boolean isBookedTicketDisplayed(String departDate, Location departFrom, Location arriveAt, SeatType seatType,
			String ticketAmount) {
		return Element.isElementDisplayed(getBookedTicket(departDate, departFrom.getValue(),
				arriveAt.getValue(), seatType.getValue(), ticketAmount));
	}

}
