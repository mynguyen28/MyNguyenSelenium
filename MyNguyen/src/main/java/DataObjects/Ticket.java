package DataObjects;

public class Ticket {
	private String departDate;
	private String departFrom;
	private String departArrive;
	private String typeSeat;
	private String ticketAmount;

	public String getTypeSeat() {
		return typeSeat;
	}

	public void setTypeSeat(String typeSeat) {
		this.typeSeat = typeSeat;
	}

	public String getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(String ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getDepartFrom() {
		return departFrom;
	}

	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}

	public String getDepartArrive() {
		return departArrive;
	}

	public void setDepartArrive(String departArrive) {
		this.departArrive = departArrive;
	}

}

