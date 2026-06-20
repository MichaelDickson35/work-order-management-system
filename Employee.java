package breakout;

/*
 * This class serves to create Employee objects 
 * It then takes the shared data from Person.java and adds the data for EmployeeId, Clocked In, and hiredDate
 */
public class Employee extends Person {

    private String employeeId;
    private String clockedin;
    private String hiredDate;

    /*
     * This method serves to initialize a new Tier1 employee
     * It grabs the data from the constructor of person.java and adds the data for EmployeeId, Clocked In, and hiredDate
     * @param firstName The employee's first name
     * @param lastName The employee's last name
     * @param address The employee's address
     * @param phoneNumber The employee's phone number
     * @param email The employee's email
     * @param employeeId The employee's Id
     * @param clockedin The employee's clock in time
     * @param hiredDate The employee's hired date
     */
    public Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedin, String hiredDate) {
        //calls the constructor of person.java
        super(firstName, lastName, address, phoneNumber, email);
        
        this.employeeId = employeeId;
        this.clockedin = clockedin;
        this.hiredDate = hiredDate;
    }

    /*
     * This method serves to set the employeeId variable
     * @Param EmployeeId - The Employee's Id
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    	}
    
    /*
     * This method serves to set the clockedin variable
     * @Param clockedin - The Employee's clock in time
     * 
     */
    public void setClockedin(String clockedin) {
        this.clockedin = clockedin;
    }
    
    /*
     * This method serves to set the hiredDate variable
     * @Param hiredDate - The Employee's hiring date
     */
    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }
    
    /*
     * This method serves to return the employeeId variable
     * @return EmployeeId - The Employee's Id
     */
    public String getEmployeeId() {
        return employeeId;
    }

    
    /*
     * This method serves to return the clockedin variable
     * @return clockedin - The Employee's clock in time
     */
    public String getClockedin() {
        return clockedin;
    }

    
    /*
     * This method serves to return the hiredDate variable
     * @return hiredDate - The Employee's hiring date
     */
    public String getHiredDate() {
        return hiredDate;
    }

    
    /* 
     * This method implements the Printable interface
     * This method serves to add the employeeId variable and clockedin variable to the String made by Person.java
     * @return a string containing employee first name, last name, Id, and clock in time
     */
    @Override
    public String getFileData() {
        return employeeId + "," + super.getFileData() + "," + clockedin;
    }
 
}