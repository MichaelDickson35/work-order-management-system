package breakout;

/**
 * This class Serves to Be the final links between the customer, ticket, and Employee and put them together
 * It also generated a time Stamp of when it was created
 */
public class WorkOrder implements Printable {
    
    private Employee employee;
    private Ticket ticket;
    private String createdAt;

    /**
     * This method serves to create the new WorkOrder Object
     * @param employee - The assigned employee
     * @param ticket - The Customers submitted Ticket 
     * @param createdAt - When the work order was made 
     */
    public WorkOrder(Employee employee, Ticket ticket, String createdAt) {
        this.employee = employee;
        this.ticket = ticket;
        this.createdAt = createdAt;
    }

    
    /**
     * This method serves to set the employee variable
     * * @param employee -the given employee object
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    

    /**
     * This method serves to set the ticket variable
     * * @param ticket - ticket being handled
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * This method serves to set the CreatedAt variable
     * * @param createdAt createdAtA - when the work was created
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * This method serves to set return Employee variable
     * * @return employee - the given employee object
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * This method serves to return the ticket variable
     * * @return ticket - ticket being handled
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * This method serves to return the createdAt variable
     * * @return createdAtA - when the work was created
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * This method returns a comma-seperated String for file output containing
     * variables from Ticket.java and Employee.java, along this the createdAt variable
     */
    @Override
    public String getFileData() {
        return ticket.getFileData() + "," + this.createdAt + "," + employee.getFileData();
    }
}
