package Common.Constant;

public class Message {

	// LOGIN
	public static final String INVALID_LOGIN_MESSAGE = "Invalid username or password. Please try again.";
	public static final String EMPTY_VALUE_LOGIN_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
	public static final String LOCK_LOGIN_MESSAGE = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

	// REGISTER
	public static final String SUCCESS_REGISTER_MESSAGE = "Thank you for registering your account";
	public static final String USED_EMAIL_MESSAGE = "This email address is already in use.";
	public static final String FAILED_REGISTER_MESSAGE = "There're errors in the form. Please correct the errors and try again.";
	public static final String ERROR_REGISTER_MESSAGE = "There're errors in the form. Please correct the errors and try again.";
	public static final String INVALID_PASSWORD_REGISTER_MESSAGE = "Invalid password length";
	public static final String INVALID_ID_LENGTH_REGISTER_MESSAGE = "Invalid ID length";
	public static final String CONFIRMED_REGISTRATION_MESSAGE = "Registration Confirmed! You can now log in to the site.";

	// CHANGE PASSWORD
	public static final String FAILED_CHANGE_PASSWORD_MESSAGE = "Password change failed. Please correct the errors and try again.";
	public static final String SUCCESS_CHANGE_PASSWORD_MESSAGE = "Your password has been updated!";

	// RESET PASSWORD
	public static final String FAILED_RESET_PASSWORD_MESSAGE = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
	public static final String EMPTY_RESET_TOKEN_MESSAGE = "The password reset token is invalid.";
	public static final String ERROR_RESET_PASSWORD_MESSAGE = "Could not reset password. Please correct the errors and try again.";
	public static final String NOT_MATCH_RESET_PASSWORD_MESSAGE = "The password confirmation did not match the new password.";

	// BOOK TICKET
	public static final String SUCCESS_BOOK_TICKET = "Ticket booked successfully!";

	// MY TICKET
	public static final String FAILED_FILTER_TICKET = "Sorry, can't find any results that match your filters.\nPlease change the filters and try again.";

}
