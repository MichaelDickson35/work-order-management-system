package breakout;

/*
 * This class holds variables shared by Customer.java, Tier2Employee.java, and Employee.java 
 * This includes firstName, lastName, address, phoneNumber, and email
 * It allows the previously listed files to access this info without repeat code
 */

public class Person implements Printable {

	//laying out the private variable
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;


    /*
     * This Method is a constructor for a Person object
     * @param firstName - The person's first name
     * @param lastName - The Person's last name
     * @param address - the Person's address
     * @param phoneNumber - the person's phone number
     * @param email - the Person's email 
     */
    public Person(String firstName, String lastName, String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /*
     * This Method serves to set the firstName variable 
     * @param firstName - The person's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /*
     * This Method serves to set the lastName variable
     * @param lastName - The Person's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /*
     * This Method serves to set the address variable
     * @param address - the Person's address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /*
     * This Method serves to set the phoneNumber variable
     * @param phoneNumber - the person's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /*
     * This Method serves to set the email variable
     * @param email - The person's email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /*
     * This Method serves to return the firstName variable
     * @return firstName - the person's last name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /*
     * This Method serves to return the lastName variable
     * @return lastName - the person's last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /*
     * This Method serves to return the address variable
     * @return address - the person's adress
     */
    public String getAddress() {
        return address;
    }
    
    /*
     * This Method serves to return the phoneNumber variable
     * @return phoneNumber - The persons phone Number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /*
     * This Method serves to return the email variable
     * @return email - The person's email
     */
    public String getEmail() {
        return email;
    }

    /*
     * This method implements the Printable interface
     * It serves to format the person's first and last name into a string separated by a comma
     * This offers a shortcut for Customer.java, Tier2Employee.java, and Employee.java, to use this text
     */
    @Override
    public String getFileData() {
        return firstName + "," + lastName;
    }
}