package Railway;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Common.Constant.Constant;
import Common.Constant.Constant.Location;
import Common.Constant.Constant.PageName;
import Common.Constant.Constant.SeatType;
import Common.Constant.Message;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class BookTicketTest extends BasicTest{
	
	
	
	@Test(description="TC14 - User can book 1 ticket at a time")
	public void TC14()
	{
		//pre-condition: Create and activate a new account
		
		//Step
		homePage.gotoPage(PageName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.gotoPage(PageName.BOOKTICKET);
		bookTicketPage.bookTicket("12/9/2018", Location.SAIGON, Location.NHATRANG, SeatType.SOFT_BED_AIR_CONDITIONER, "1");
		assertEquals(bookTicketPage.getHeaderPage(), Message.SUCCESS_BOOK_TICKET);
		assertTrue(bookTicketPage.isBookedTicketDisplayed("12/9/2018", Location.SAIGON, Location.NHATRANG, SeatType.SOFT_BED_AIR_CONDITIONER, "1"));
	}
	
	private HomePage homePage = new HomePage();
	private LoginPage loginPage = new LoginPage();
	private RegisterPage registerPage = new RegisterPage();
	private BookTicketPage bookTicketPage = new BookTicketPage();
	

}
