package PageObjects.Railway;

import org.openqa.selenium.By;

import Common.Common.Element;
import DataObjects.Ticket;

public class TimeTablePage {
	
	private final String lnkBookTicket = "//table[@class='MyTable WideTable']//td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/following-sibling::td/a[contains(@href,'Book')]";

	
	public void gotoBookTicketPageByLink(Ticket ticket)
	{
		String str = String.format(lnkBookTicket, ticket.getDepartFrom(), ticket.getDepartArrive());
		Element.click(By.xpath(str));
	}
}
