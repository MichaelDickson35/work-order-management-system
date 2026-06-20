package breakout;

/**
 * This class takes a customer object and links it with information reguarding there request
 * This inclusdes, ticketId and CreatedAt
 */
 

public class Ticket implements Printable {

    private Customer customer;
    private String createdAt;
    private String ticketId;

    /*
     * This method creates the ticket object
     * @Param customer
     * @Param createdAt - The time the ticket was created
     * @Param ticketId - The ticket Id number
     */
    public Ticket(Customer customer, String createdAt, String ticketId) {
        this.customer = customer;
        this.createdAt = createdAt;
        this.ticketId = ticketId;
    }

    /*
     * This method serves to set the customer variable
     * @Param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    /*
     * This method serves to set the createdAt variable
     * @Param createdAt - The time the ticket was created
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    /*
     * This method serves to set the ticketId variable
     * @Param ticketId - The ticket Id number
     */
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    
    /*
     * This method serves to return the customer variable
     * @return customer 
     */
    public Customer getCustomer() {
        return customer;
    }
    
    /*
     * This method serves to return the createdAt variable
     * @return createdAt - The time the ticket was created
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /*
     * This method serves to return the ticketId variable
     * @return ticketId - The ticket Id number
     */
    public String getTicketId() {
        return ticketId;
    }

    

    /* 
     * This method implements the Printable interface
     * This method serves to add the ticketId and createdAt variable to the String made by customer.java
     * @return a string containing ticketId, createdAt , first name, and last name
     */
    @Override
    public String getFileData() {
        return customer.getFileData() + "," + ticketId + "," + createdAt;
    }
}