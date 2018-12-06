package Railway;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.Common.FileReaderManager;
import Common.Constant.Constant;
import Common.Constant.Constant.PageName;
import Common.Constant.Message;
import DataObjects.Ticket;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class BookTicketTest extends BasicTest {

	@Test(description = "TC14 - User can book 1 ticket at a time")
	public void TC14() {
		homePage.gotoPage(PageName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.gotoPage(PageName.BOOKTICKET);
		Ticket ticket = FileReaderManager.getInstance().getJsonReader().getTicketInfo();
		bookTicketPage.bookTicket(ticket);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(bookTicketPage.getHeaderPage(), Message.SUCCESS_BOOK_TICKET);
		softAssert.assertTrue(bookTicketPage.isBookedTicketDisplayed(ticket));
	}

	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();
	private BookTicketPage bookTicketPage = new BookTicketPage();

}
