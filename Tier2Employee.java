package breakout;

/*
 * This class serves to create Tier2Employee objects if a employee has a certification
 * It then takes the shared data from Employee.java and adds a the correct certification to the end
 */
public class Tier2Employee extends Employee {

    private String certification;

    /*
     * This method serves to initialize a new Tier2 employee
     * It grabs the data from the constructor of Employee.java and adds the data for certification
     * @param firstName The employee's first name
     * @param lastName The employee's last name
     * @param address The employee's address
     * @param phoneNumber The employee's phone number
     * @param email The employee's email
     * @param employeeId The employee's Id
     * @param clockedin The employee's clock in time
     * @param hiredDate The employee's hired date
     * @param certification The employee's certification type
     */
    public Tier2Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedin, String hiredDate, String certification) {
        //calls the constructor of the parent class Employee.java
        super(firstName, lastName, address, phoneNumber, email, employeeId, clockedin, hiredDate);
        
        this.certification = certification;
    }
    
    /* 
     * This method serves to set the certification variable
     * @param certification The employee's certification type
     */
    public void setCertification(String certification) {
        this.certification = certification;
    }
    
    /* 
     * This method serves to return the certification variable
     * @return The type of certification an employee has.
     */
    public String getCertification() {
        return certification;
    }


    /* 
     * This method implements the Printable interface
     * This method serves to add the certification variable to the end of the String made by Employee.java
     * @return a string containing employee first name, last name, Id, clock in time, and certification
     */
    @Override
    public String getFileData() {
        return super.getFileData() + "," + certification;
    }
}