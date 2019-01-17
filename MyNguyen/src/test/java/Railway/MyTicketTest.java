package Railway;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Common.FileReaderManager;
import Common.Constant.Constant;
import Common.Constant.Constant.PageName;
import Common.Constant.Message;
import DataObjects.Ticket;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;

public class MyTicketTest extends BasicTest {

	@BeforeMethod
	public void beforeMethod() {
		homePage.gotoPage(PageName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.gotoPage(PageName.MYTICKET);
		myTicketPage.cancelAllBookedTicketDisplayed();
	}

	@AfterMethod
	public void afterMethod() {
		homePage.logOut();
	}

	@Test(description = "TC16 - User can cancel a ticket")
	public void TC16() {
		myTicketPage.gotoPage(PageName.BOOKTICKET);
		bookTicketPage.bookTicket(ticket);
		bookTicketPage.gotoPage(PageName.MYTICKET);
		myTicketPage.cancelBookedTicket(ticket);
		assertFalse(myTicketPage.isBookedTicketCancelDisplayed(ticket));
	}

	@Test(description = "FTTC01 - User can filter 'Manager ticket' table with Depart Station")
	public void TC_FTTC01() {
		myTicketPage.gotoPage(PageName.BOOKTICKET);
		bookTicketPage.bookMutilpleTicket();
		homePage.gotoPage(PageName.MYTICKET);
		myTicketPage.filterDepartStationFilter(ticket);
		
	}

	@Test(description = "FTTC02 - Error displays when user applies filter with un-existed value of 'Status' in 'Manage ticket' table")
	public void TC_FTTC02() {
		myTicketPage.gotoPage(PageName.BOOKTICKET);
		bookTicketPage.bookMutilpleTicket();
		homePage.gotoPage(PageName.MYTICKET);
		myTicketPage.filterStatusFilter("Paid");
		assertEquals(myTicketPage.getErrorFilter(), Message.FAILED_FILTER_TICKET);
	}

	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();
	private BookTicketPage bookTicketPage = new BookTicketPage();
	private MyTicketPage myTicketPage = new MyTicketPage();
	Ticket ticket = FileReaderManager.getInstance().getJsonReader().getTicketByDepartStation("Huế");

}
