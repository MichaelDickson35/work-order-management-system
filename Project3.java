/**
 * Author: Michael Dickson
 * Course: COP3503
 * Project #: 3
 * Due Date: 4/8/2026
 * This project serves as a work order management system take reads files containing employee data and 
 * ticket data from CSV file, is organizes that into a new csv file as well as creating a log txt file
 */
package breakout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class serves as the main zone where the different classes are called from
 * It contains the csv file names as well as the designated ArrayLists and Queues
 */
public class Project3 {

   
    // These Strings give the exact file names
    public static String employeeFileName = "employee_data.csv";
    public static String tier1TicketFileName = "tier1_ticket_data.csv";
    public static String tier2TicketFileName = "tier2_ticket_data.csv";
    public static String workOrderFileName = "workorder_data.csv";

    public static ArrayList<Employee> employeeList = new ArrayList<>();
    public static Queue<Ticket> tier1TicketFile = new LinkedList<>();
    public static Queue<Ticket> tier2TicketFile = new LinkedList<>();
    public static ArrayList<WorkOrder> workOrderList = new ArrayList<>();

    /**
     * This method serves as the area in which each class is called
     * It handles workflow such as Title display, Data loading, Processing, and Saving
     * @param args Command line arguments 
     */
    public static void main(String[] args) {
        
        System.out.println("Project 3 Work Order Generator\n");
        
        //This loads the emplooyee data
        FileHandler.readEmployeeData(employeeFileName);

        // This puts The 2 ticket files in their own queue
        System.out.println("Loading Ticket Data"); // Print once to console
        tier1TicketFile.addAll(FileHandler.readTicketData(tier1TicketFileName));
        tier2TicketFile.addAll(FileHandler.readTicketData(tier2TicketFileName));

        // This triggers the employee to customer system
        createWorkOrders();

        // This sends created data to the FileHandler to be exported
        FileHandler.writeData(workOrderFileName);
    }

    /**
     * This method finds the employees that are qualified to work with tier 2 tickets
     * It then assigns the tickets, tier 2 then tier 1
     */
    public static void createWorkOrders() {
        System.out.println("Creating Work Orders");

        // These lines seperate tier 1 employees from tier 2
        ArrayList<Employee> tier1Employees = new ArrayList<>();
        ArrayList<Tier2Employee> tier2Employees = new ArrayList<>();

        for (Employee emp : employeeList) {
            if (emp instanceof Tier2Employee) {
                tier2Employees.add((Tier2Employee) emp);
            } else {
                tier1Employees.add(emp);
            }
        }

        // sets up date formatter for tracking
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");


        // This assigns tier 2 tickets
        int t2Index = 0;
        while (!tier2TicketFile.isEmpty()) {
            Ticket currentTicket = tier2TicketFile.poll(); 
            
            if (!tier2Employees.isEmpty()) {
                Tier2Employee assignedEmp = tier2Employees.get(t2Index % tier2Employees.size());
                String createdAt = formatter.format(new Date());
                
                WorkOrder wo = new WorkOrder(assignedEmp, currentTicket, createdAt);
                workOrderList.add(wo);
                t2Index++;
            }
        }

        // this assigns tier 1 tickets
        int t1Index = 0;
        while (!tier1TicketFile.isEmpty()) {
            Ticket currentTicket = tier1TicketFile.poll();
            
            if (!tier1Employees.isEmpty()) {
                Employee assignedEmp = tier1Employees.get(t1Index % tier1Employees.size());
                String createdAt = formatter.format(new Date());
                
                WorkOrder wo = new WorkOrder(assignedEmp, currentTicket, createdAt);
                workOrderList.add(wo);
                t1Index++;
            }
        }
    }
}