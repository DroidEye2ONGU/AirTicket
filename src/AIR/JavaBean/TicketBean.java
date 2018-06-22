package AIR.JavaBean;

/**
 * Created by DroidEye on 2017/6/22.
 */
public class TicketBean {

    private String ticketID;
    private String ticketAddress;
    private String ticketPrice;

    public TicketBean() {
    }

    public TicketBean(String ticketID, String ticketAddress, String ticketPrice) {
        this.ticketID = ticketID;
        this.ticketAddress = ticketAddress;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketAddress() {
        return ticketAddress;
    }

    public void setTicketAddress(String ticketAddress) {
        this.ticketAddress = ticketAddress;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
