package breakout;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileReader;

/**
 * This class serves to take care of all of the File operations
 * This includes reading raw data, and parsing it into objects
 * It also handles the writing of the Output CSV as well as the System log
 */
public class FileHandler {

    /**
     * This method writes a timeStamped entry to the log.txt file
     * * @param log - the method/string needing to be added
     */
    private static void logger(String log) {
        try {
            FileWriter fileWriter = new FileWriter("log.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String timestamp = dateFormatter.format(new Date());
            
            printWriter.println("log: " + timestamp + " : " + log);
            
            printWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log: " + e.getMessage());
        }
    }

    /**
     * This method reads the employee data from CSV and generates Employee or Tier2Employee based on certificate
     * It then adds those objects to employee list in project3.java

     * * @param employeeFileName - the file name for employee data
     */
    public static void readEmployeeData(String employeeFileName) {
        logger("Loading Employee Data"); //
        System.out.println("Loading Employee Data");

        try {
            Scanner scanner = new Scanner(new FileReader(employeeFileName));
            
            //This line ignores header
            if (scanner.hasNextLine()) {
                scanner.nextLine(); 
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fileData = line.split(","); 

                String firstName = fileData[1];
                String lastName = fileData[2];
                String address = fileData[4];
                String phoneNumber = fileData[5];
                String email = fileData[3];
                String employeeId = fileData[0];
                String clockedin = fileData[6];
                String hiredDate = fileData[7];
                String employeeTier = fileData[8]; 

                if (employeeTier.equalsIgnoreCase("tier2") || employeeTier.contains("tier2")) {
                    String certification = fileData[9]; 
                    Tier2Employee t2EmployeeData = new Tier2Employee(firstName, lastName, address, phoneNumber, email, employeeId, clockedin, hiredDate, certification);
                    Project3.employeeList.add(t2EmployeeData); 
                } else {
                    Employee emp = new Employee(firstName, lastName, address, phoneNumber, email, employeeId, clockedin, hiredDate);
                    Project3.employeeList.add(emp); 
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Employee file not found: " + e.getMessage());
        }
    }

    /**
     * This method reads CSV data to make customer objects
     * It then links them to ticket objects
     * Reads ticket data from a specified CSV file, constructs Customer objects, 
     * and links them via composition to new Ticket objects.
     * * @param ticketFileName - the CSV file containing ticket data
     * @return A LinkedList containing all worked though ticket objects
     */
    public static LinkedList<Ticket> readTicketData(String ticketFileName) {
         
        LinkedList<Ticket> ticketList = new LinkedList<>();
        
        logger("Loading Ticket Data");

        try {
            Scanner scanner = new Scanner(new FileReader(ticketFileName));
            
            if (scanner.hasNextLine()) {
                scanner.nextLine(); 
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fileData = line.split(",");

                String customerId = fileData[0];
                String firstName = fileData[1];
                String lastName = fileData[2];
                String address = fileData[4];
                String phoneNumber = fileData[5];
                String email = fileData[3];
                String accountNumber = fileData[6];
                String ticketId = fileData[7];
                String createdAt = fileData[8];

                Customer customer = new Customer(firstName, lastName, address, phoneNumber, email, customerId, accountNumber);
                
                Ticket ticket = new Ticket(customer, createdAt, ticketId);
                
                ticketList.add(ticket);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ticket file not found: " + e.getMessage());
        }
        
        return ticketList; //
    }

    /**
     * This method sends the lines from WorkOrders to the new CSV file
     * * @param workOrderFileName The file for the work orders
     */
    public static void writeData(String workOrderFileName) {
        logger("Writing Work Order Data to File"); 
        System.out.println("Writing Work Order Data to File"); 

        try {
            FileWriter fileWriter = new FileWriter(workOrderFileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String header = "customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,employee_id,employee_first_name,employee_last_name,clocked_in,certification";
            printWriter.println(header); 

            for (WorkOrder workOrder : Project3.workOrderList) {
                String rowData = workOrder.getFileData(); 
                
                printWriter.println(rowData); 
                
                logger(rowData); 
            }

            printWriter.close();
            
            logger("Work Orders Created. Program Exiting");
            System.out.println("Work Order file Created. Program Exiting");

        } catch (IOException e) {
            System.out.println("An error occurred while writing work order data: " + e.getMessage());
        }
    }
}