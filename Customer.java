package breakout;

/*
 * This class serves to create Customer objects 
 * It then takes the shared data from Person.java and adds the data for customerId, and accountNumber
 */
public class Customer extends Person {

    private String customerId;
    private String accountNumber;

    /*
     * This method serves to initialize a new customer object
     * It grabs the data from the constructor of person.java and adds the data for customerId, and accountNumber
     * @param firstName The customer's first name
     * @param lastName The customer's last name
     * @param address The customer's address
     * @param phoneNumber The customer's phone number
     * @param email The customer's email
     * @param Customer Id the customer's ID The employee's Id
     * @param accountNumber  The customer's account number
     */
    public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String customerId, String accountNumber) {
        // Pass the common info to the Person constructor
        super(firstName, lastName, address, phoneNumber, email);
        
        this.customerId = customerId;
        this.accountNumber = accountNumber;
    }

    /*
     * This method serves to set the customer Id variable
     * @Param customerId - The customer's order Id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    /*
     * This method serves to set the accountNumber variable
     * @Param accountNumber - The Customers account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    /*
     * This method serves to return the customerId variable
     * @return customerId - The customer's order Id
     */
    public String getCustomerId() {
        return customerId;
    }
    
    /*
     * This method serves to return the accountNumber variable
     * @return accountNumber - The Customers account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    
    /* 
     * This method implements the Printable interface
     * This method serves to add the customerId variable to the String made by Person.java
     * @return a string containing customer Id , first name, and last name
     */
    @Override
    public String getFileData() {
        return customerId + "," + super.getFileData();
    }
}