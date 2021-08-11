// import packages
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;

/**
 * The Poised program is a project management system for a small structural engineering firm called Poised
 *
 * @author egorzakharov
 * @version 1.0
 * @since 2021-06-09
 */
public class Poised {

    /**
     * List variable of type project used to store all projects
     */
    static List<Project> projectList = new ArrayList<>();

    /**
     * This is a method that is used to create a new architect that is a Person object
     * by getting user input and calling the constructor in the Person class
     * @return returns an object of type Person representing an architect
     */
    public static Person newArchitect() {
        // temporary scanner object
        Scanner temp = new Scanner(System.in);
        // variables for details about architect
        String architectName;
        String architectNumber;
        String architectEmail;
        String architectAddress;
        System.out.println("Architect details");
        // while loop to get all architect details
        while (true) {
            // output instruction and get user input
            System.out.print("Enter the architect's name and surname: ");
            architectName = temp.nextLine();
            System.out.print("Enter the architect's telephone number: ");
            architectNumber = temp.nextLine();
            System.out.print("Enter the architect's email address: ");
            architectEmail = temp.nextLine();
            System.out.print("Enter the architect's physical address: ");
            architectAddress = temp.nextLine();
            // if any input is blank output message
            if (architectName.isEmpty()
                    || architectNumber.isEmpty()
                    || architectEmail.isEmpty()
                    || architectAddress.isEmpty())
                System.out.println("One or more of the fields above were left empty. Re-enter the architect's details.");
            // else if all the input is entered correctly break out of loop
            else
                break;
        }
        // output message and return new Person object
        System.out.println("Architect successfully stored\n");
        return new Person(architectName, architectNumber, architectEmail, architectAddress);
    }

    /**
     * This is a method that is used to create a new contractor that is a Person object
     * by getting user input and calling the constructor in the Person class
     * @return returns an object of type Person representing a contractor
     */
    public static Person newContractor() {
        // temporary scanner object
        Scanner temp = new Scanner(System.in);
        // variables for details about contractor
        String contractorName;
        String contractorNumber;
        String contractorEmail;
        String contractorAddress;
        System.out.println("Contractor details");
        // while loop to get all architect details
        while (true) {
            // output instruction and get user input
            System.out.print("Enter the contractor's name and surname: ");
            contractorName = temp.nextLine();
            System.out.print("Enter the contractor's telephone number: ");
            contractorNumber = temp.nextLine();
            System.out.print("Enter the contractor's email address: ");
            contractorEmail = temp.nextLine();
            System.out.print("Enter the contractor's physical address: ");
            contractorAddress = temp.nextLine();
            // if any input is blank output message
            if (contractorName.isBlank()
                    || contractorNumber.isBlank()
                    || contractorEmail.isBlank()
                    || contractorAddress.isBlank())
                System.out.println("One or more of the fields above were left blank. Re-enter the contractor's details.");
            // else if all the input is entered correctly break out of loop
            else
                break;
        }
        // output message and return new Person object
        System.out.println("Contractor successfully stored\n");
        return new Person(contractorName, contractorNumber, contractorEmail, contractorAddress);
    }

    /**
     * This is a method that is used to create a new customer that is a Person object
     * by getting user input and calling the constructor in the Person class
     * @return returns an object of type Person representing a customer
     */
    public static Person newCustomer() {
        // temporary scanner object
        Scanner temp = new Scanner(System.in);
        System.out.println("Customer details");
        // variable for customer name
        String customerName;
        System.out.print("Enter the customer's name and surname: ");
        // while loop until try block is executed
        // ensures both name and surname of customer is entered
        // (in the case that the project name is left empty and surname is needed)
        while (true) {
            // try split the string entered to see if it consists of two names then break out of loop
            try {
                customerName = temp.nextLine();
                String[] nameArr = customerName.split(" ");
                String surname = nameArr[1];
                break;
            }
            // catch if fails and print out error message
            catch (Exception e) {
                System.out.print("Invalid - enter the customer's name AND surname separated by a space: ");
            }
        }
        // variables about customer details
        String customerNumber;
        String customerEmail;
        String customerAddress;
        // while loop to get all customer details
        while (true) {
            System.out.print("Enter the customer's telephone number: ");
            customerNumber = temp.nextLine();
            System.out.print("Enter the customer's email address: ");
            customerEmail = temp.nextLine();
            System.out.print("Enter the customer's physical address: ");
            customerAddress = temp.nextLine();
            // if any input is blank output message
            if (customerNumber.isBlank()
                    || customerEmail.isBlank()
                    || customerAddress.isBlank())
                System.out.println("One or more of the fields above were left blank. Re-enter the customer's details.");
            // else if all the input is entered correctly break out of loop
            else
                break;
        }
        // output message and return new Person object
        System.out.println("Customer successfully stored\n");
        return new Person(customerName, customerNumber, customerEmail, customerAddress);
    }

    /**
     * This is a method that is used to create a new Project object
     * by getting user input and calling the constructor in the Project class
     * @param architect architect Person object assigned to the project being created
     * @param contractor contractor Person object assigned to the project being created
     * @param customer customer Person object assigned to the project being created
     * @return returns a new project object of type Project
     */
    public static Project newProject(Person architect, Person contractor, Person customer) {
        // temporary scanner object
        Scanner temp = new Scanner(System.in);
        System.out.println("Project details");
        // variables for numerical fields
        int projectNumber;
        int erfNumber;
        double projectFee;
        double amountPaid;
        // Arraylist variable of type integer to store all current project numbers
        ArrayList<Integer> projectNums = new ArrayList<>();
        for (Project project: projectList)
            projectNums.add(project.number);
        // while loop until try block is executed
        // ensures only numerical values are entered
        while (true) {
            // try get a numerical value for each field and break out of while loop
            try {
                System.out.print("Enter the project number: ");
                projectNumber = temp.nextInt();
                // while loop to ensure project number does not already exist and is bigger than zero
                while (projectNums.contains(projectNumber) || projectNumber <= 0) {
                    System.out.print("Invalid number or project number already exists. " +
                            "Enter a different project number (integer bigger than zero): ");
                    projectNumber = temp.nextInt();
                }
                System.out.print("Enter the ERF number: ");
                erfNumber = temp.nextInt();
                System.out.print("Enter the total fee being charged for the project: ");
                projectFee = temp.nextDouble();
                System.out.print("Enter total amount paid to date: ");
                amountPaid = temp.nextDouble();
                break;
            }
            // catch if numerical value is not entered and output message
            catch (Exception e) {
                // skip empty line entered by user
                temp.nextLine();
                System.out.println("Invalid input. A numerical value is needed for the field(s) above.");
            }
        }
        // skip empty line entered by user
        temp.nextLine();
        // project name can be blank
        System.out.print("Enter the project name: ");
        String projectName = temp.nextLine();
        // other string variables for project
        String buildingType;
        String projectAddress;
        // while loop to ensure input is not blank
        while (true) {
            System.out.print("What type of building is being designed? E.g. House, apartment block or store, etc.: ");
            buildingType = temp.nextLine();
            System.out.print("Enter the physical address for the project: ");
            projectAddress = temp.nextLine();
            if (buildingType.isBlank() || projectAddress.isBlank())
                System.out.println("One or more of the fields above were left blank. Please try again.");
            else
                break;
        }

        System.out.print("Enter the deadline for the project in the format YYYY-MM-DD: ");
        String strDeadLine;
        // while loop to ensure date is entered in the required format
        while (true) {
            try {
                strDeadLine = temp.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date deadline = sdf.parse(strDeadLine);
                break;

            } catch (Exception e) {
                System.out.print("Invalid input - enter the deadline for the project in the format YYYY-MM-DD: ");
            }
        }
        // output message and return new project object
        System.out.println("Project successfully stored");
        // finalized is set to false and completion date to incomplete
        return new Project(projectNumber, projectName, buildingType, projectAddress, erfNumber, projectFee, amountPaid,
                strDeadLine, architect, contractor, customer, false, "Incomplete");
    }

    /**
     * This is a method that is used to update details about a project (including details about some Person objects)
     * based on user input
     * @param project project Project object that is being updated
     */
    public static void update(Project project) {
        // temporary scanner object
        Scanner temp = new Scanner(System.in);
        // while loop while user does not exit menu
        while (true) {
            // output menu with operations
            System.out.println("""
                    Enter 1 to change the due date of the project
                    Enter 2 to change the total amount of the fee paid to date
                    Enter 3 to update a contractor's contact details
                    Enter 0 to exit out of change/update section""");
            //
            int operation;
            // loop until an integer is entered
            while (true) {
                try {
                    // if int then break out of loop
                    operation = temp.nextInt();
                    break;
                }
                // catch and output error message
                catch (Exception e) {
                    temp.nextLine();
                    System.out.print("Invalid input  - enter an integer command corresponding " +
                            "to the operation to perform: ");
                }
            }
            // skip empty line entered by user
            temp.nextLine();
            // if type is 1 output instruction, get new due date and set new deadline for project
            if (operation == 1) {
                System.out.print("Enter a new due date for the project in the format YYYY-MM-DD: ");
                String strDeadline;
                // loop until valid date format is entered
                while (true) {
                    try {
                        strDeadline = temp.nextLine();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date deadline = sdf.parse(strDeadline);
                        break;

                    } catch (Exception e) {
                        System.out.print("Invalid input - enter the deadline for the project in the format YYYY-MM-DD: ");
                    }
                }
                // update deadline (which will update the object in the List)
                project.setDeadline(strDeadline);
            }

            // if type is 2 output instruction, get new amount and set new total amount for project
            else if (operation == 2) {
                System.out.print("Enter the total amount of the fee paid to date: ");
                double newAmount;
                // loop until a double is entered
                while (true) {
                    try {
                        newAmount = temp.nextDouble();
                        break;
                    }
                    catch (Exception e) {
                        System.out.println("Invalid input - enter a numerical value");
                    }
                }
                // update new amount (which will update the object in the List)
                project.setTotalAmount(newAmount);
            }

            // if type is 3
            else if (operation == 3) {
                // output instruction
                System.out.println("""
                        Enter 1 to update a contractor's email address
                        Enter 2 to update a contractor's telephone number
                        """);
                int update;
                // loop until integer is entered
                while (true) {
                    try {
                        update = temp.nextInt();
                        break;
                    }
                    catch (Exception e) {
                        // skip next line entered by user
                        temp.nextLine();
                        System.out.println("Invalid input - enter a numerical value");
                    }
                }
                // if choice is 1, output message, get new email and set new email for contractor
                if (update == 1) {
                    System.out.print("Enter an updated contractor's email address: ");
                    String newEmail = temp.nextLine();
                    // loop until new email entered is not blank
                    while (newEmail.isBlank())
                        newEmail = temp.nextLine();
                    // update new email (which will update the object in the List)
                    project.contractor.setEmail(newEmail);
                }

                // if choice is 2, output message, get new number and set new number for contractor
                else if (update == 2) {
                    System.out.print("Enter an updated contractor's telephone number: ");
                    String newNumber = temp.nextLine();
                    // loop until new number entered is not blank
                    while (newNumber.isBlank())
                        newNumber = temp.nextLine();
                    // update new number (which will update the object in the List)
                    project.contractor.setNumber(newNumber);
                }
                // else output error message
                else
                    System.out.println("Invalid input");
            }
            // break out of loop
            else if (operation == 0)
                break;
            // else output error message
            else
                System.out.println("Invalid choice");
        }
    }

    /**
     * This is a method that is used to finalize a project object and write the finalized object to a text file
     * @param project project Project object that is being finalized
     */
    public static void finalize(Project project) {
        // if the project has not been finalized yet
        if (!project.finalized) {
            // finalize the project
            project.finalizeProject();
            // get current date and set it as the completion date using the setCompletionDate method
            LocalDate localDate = LocalDate.now();
            project.setCompletionDate(String.valueOf(localDate));
            // check if project is paid for in full.
            // If paid in full output message else output invoice by calling the invoice method in the Project class
            if (project.totalPaid == project.totalDue) {
                System.out.println("Paid in full");
            } else {
                System.out.println(project.invoice());
            }
            // try write finalized project to new text file
            try {
                // open text file, write to text file, close text file and output message
                FileWriter outputFile = new FileWriter("Completed project.txt");
                outputFile.write(project.fileString() + "\n");
                outputFile.close();
                System.out.println("Project finalized and added to text file called 'Completed project.txt'\n");
            }
            // catch if fails and output message
            catch (Exception e) {
                System.out.println("An error occurred when storing projects");
            }
        }
        // output message if project already finalized
        else
            System.out.println("Project has already been finalized");
    }

    /**
     * This is a method that is used to read a list of projects from a text file
     * and store the projects in a List of type Project
     * @param projectList projectList List that is used to store Project objects in
     */
    public static void getProjects(List<Project> projectList) {
        // try opening text file
        try {
            // open text file
            File inputFile = new File("projects.txt");
            // create scanner object
            Scanner temp = new Scanner(inputFile);
            // while text file has a next line
            while (temp.hasNextLine()) {
                // create a string array with project details
                String[] projArray = temp.nextLine().replace("\n", "").split("#");
                // parse and store all numerical values in projArray
                int number = Integer.parseInt(projArray[0]);
                int erf = Integer.parseInt(projArray[4]);
                double totalDue = Double.parseDouble(projArray[5]);
                double totalPaid = Double.parseDouble(projArray[6]);
                // create a string array for each Person object
                String[] architectArray = projArray[8].split("\\|");
                String[] contractorArray = projArray[9].split("\\|");
                String[] customerArray = projArray[10].split("\\|");
                // create 3 Person objects by passing through parts of the arrays above accordingly
                Person architect = new Person(architectArray[0], architectArray[1],
                        architectArray[2], architectArray[3]);
                Person contractor = new Person(contractorArray[0], contractorArray[1],
                        contractorArray[2], contractorArray[3]);
                Person customer = new Person(customerArray[0], customerArray[1],
                        customerArray[2], customerArray[3]);
                // parse boolean value for finalised
                Boolean finalized = Boolean.parseBoolean(projArray[11]);
                // create new Project object
                Project project = new Project(number, projArray[1], projArray[2], projArray[3], erf, totalDue,
                        totalPaid, projArray[7] ,architect, contractor, customer, finalized, projArray[12]);
                // add project object to list
                projectList.add(project);
            }
        }
        // catch if failed to open text file or text file does not exist
        catch (FileNotFoundException e) {
            System.out.println("An error occurred when fetching projects.");
        }
    }

    /**
     * This is a method that is used to write a list of projects from a List of type Project to a text file
     * @param projectList projectList List that is used to read Project objects from
     */
    public static void storeProjects(List<Project> projectList) {
        // try open text file
        try {
            // open text file
            FileWriter outputFile = new FileWriter("projects.txt");
            // write each project in the list to text file
            for (Project project: projectList)
                outputFile.write(project.fileString()+"\n");
            // close the text file
            outputFile.close();

        }
        // catch if opening text file fails and output message
        catch (Exception e) {
            System.out.println("An error occurred when storing projects");
        }
    }

    /**
     * This is the main method that is used to run the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scanner object
        Scanner scanner = new Scanner(System.in);
        // fill list with projects in text file
        getProjects(projectList);
        System.out.println("Lets build");
        // initialise variable for menu choice
        int choice;
        // loop while user does not quit
        while (true) {
            // output menu
            System.out.print("""
                                        
                    Enter 1 to add a new project
                    Enter 2 to select and update/finalize an existing project
                    Enter 3 to see a list of projects that still need to be completed
                    Enter 4 to see a list of projects that are overdue
                    Enter 0 to save and exit
                                        
                    """);
            // try read integer
            try {
                // read int
                choice = scanner.nextInt();
                // if choice is 1
                if (choice == 1) {
                    // call methods to create new architect, contractor and customer
                    Person architect = newArchitect();
                    Person contractor = newContractor();
                    Person customer = newCustomer();
                    // call method to create new project by passing through the objects created above
                    Project project = newProject(architect, contractor, customer);
                    // add new project to list
                    projectList.add(project);
                }
                // if choice is 2
                else if (choice == 2) {
                    // temporary scanner object
                    Scanner temp = new Scanner(System.in);
                    System.out.print("Enter the project name or number: ");
                    // string variable for proj number/name
                    String proj = temp.nextLine();
                    // boolean for proj being an integer
                    boolean isNum;
                    // try parse proj to an integer and set isNum to true
                    try {
                        Integer.parseInt(proj);
                        isNum = true;
                    }
                    // catch if fails and set isNum to false
                    catch (Exception e) {
                        isNum = false;
                    }
                    // set index for project to zero
                    int index = 0;
                    // boolean for if project is found
                    boolean found = false;
                    // loop through every project in list
                    for (Project project: projectList) {
                        // if an integer was entered initially
                        if (isNum) {
                            // compare project number to integer entered
                            if (project.number == Integer.parseInt(proj)) {
                                // if they match store index of the project
                                index = projectList.indexOf(project);
                                // set found to true
                                found = true;
                                // break out of loop
                                break;
                            }
                        }
                        // else if string was entered
                        else {
                            // compare project name to string entered
                            if (project.name.equalsIgnoreCase(proj)){
                                // if they match store index of the project
                                index = projectList.indexOf(project);
                                // set found to true
                                found = true;
                                // break out of loop
                                break;
                            }
                        }
                    }
                    // if project was found
                    if (found) {
                        // print the project details
                        System.out.println(projectList.get(index) + "\n");
                        // Output instruction and get choice to change/update details
                        System.out.print("Enter 'x' to change/update details or any other key to skip: ");
                        String choice1 = temp.nextLine();
                        // if user chooses to change/update details
                        if (choice1.equalsIgnoreCase("x")) {
                            // check if project has been finalized and output message if it has
                            if (projectList.get(index).finalized)
                                System.out.println("Project has already been finalized");
                            // else call the update method and pass the project as a parameter
                            else
                                update(projectList.get(index));
                        }
                        // output message and get input to finalize project or not
                        System.out.print("Enter 'f' to finalize the project or enter any other key to skip: ");
                        String finalizeChoice = temp.nextLine();
                        // if user chooses to finalize project
                        // finalize the project by calling finalizeProject and pass through the project as a parameter
                        if (finalizeChoice.equalsIgnoreCase("f")) {
                            finalize(projectList.get(index));
                        }
                    }
                    // output message if project not found
                    else
                        System.out.println("Unable to find project");
                }
                // if choice is 3
                else if (choice == 3) {
                    System.out.println("Incomplete projects:");
                    // loop through list of projects
                    for (Project project: projectList) {
                        // if project is not yet finalised output the project number and name
                        if (!project.finalized)
                            System.out.println("\t-Project " + project.number + ": " + project.name);
                    }
                }
                // if choice is 4
                else if (choice == 4) {
                    System.out.println("Overdue projects:");
                    // loop through list of projects
                    for (Project project: projectList) {
                        // get due date in date format by parsing string due date
                        Date due = new SimpleDateFormat("yyyy-MM-dd").parse(project.deadline);
                        // get present date in date format by parsing string of local date (current date)
                        Date present = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(LocalDate.now()));
                        // if the due date is before the present date output the project number and name
                        if (due.before(present))
                            System.out.println("\t-Project " + project.number + ": " + project.name);
                    }
                }
                // if choice is 0
                else if (choice == 0){
                    // output message and break out of loop
                    System.out.println("Writing projects to file and exiting\n");
                    break;
                }
                // output message if invalid input
                else {
                    System.out.println("Invalid input\n");
                }
            }
            // catch if integer is not entered and output error message
            catch (Exception e) {
                scanner.nextLine();
                System.out.println("Invalid input\n");
            }

        }
        // call method to store projects in text file passing through project list as a parameter
        storeProjects(projectList);
    }
}