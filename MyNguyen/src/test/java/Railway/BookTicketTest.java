package Railway;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import PageObjects.Railway.TimeTablePage;

public class BookTicketTest extends BasicTest {

	@BeforeMethod
	public void beforeMethod() {
		homePage.gotoPage(PageName.LOGIN);
	}

	@AfterMethod
	public void afterMethod() {

		homePage.logOut();
	}

	@Test(description = "TC14 - User can book 1 ticket at a time")
	public void TC14() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.gotoPage(PageName.BOOKTICKET);
		bookTicketPage.bookTicket(ticket);
		assertEquals(bookTicketPage.getHeaderPage(), Message.SUCCESS_BOOK_TICKET);
		assertTrue(bookTicketPage.isBookedTicketDisplayed(ticket));
	}

	@Test(description = "TC15 - User can open Book ticket page by clicking on Book ticket link in Train timetable page")
	public void TC15() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.gotoPage(PageName.TIMETABLE);
		timeTablePage.gotoBookTicketPageByLink(ticket);
		assertTrue(bookTicketPage.isSelectedValueDisplayed(ticket));
	}

	@Test(description = "TC16 - User can cancel a ticket")
	public void TC16() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.gotoPage(PageName.BOOKTICKET);
		bookTicketPage.bookTicket(ticket);
		bookTicketPage.gotoPage(PageName.MYTICKET);
		assertTrue(bookTicketPage.isSelectedValueDisplayed(ticket));
	}

	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();
	private BookTicketPage bookTicketPage = new BookTicketPage();
	private TimeTablePage timeTablePage = new TimeTablePage();
	Ticket ticket = FileReaderManager.getInstance().getJsonReader().getTicketInfo();

}
