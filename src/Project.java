/**
 * This Project class is a class that is used to create project objects
 *
 * @author egorzakharov
 * @version 2.0
 * @since 2021-06-09
 */
public class Project {

    /**
     * int variable for project number
     */
    int number;
    /**
     * String variable for project name
     */
    String name;
    /**
     * String variable for building type
     */
    String building;
    /**
     * String variable for project address
     */
    String address;
    /**
     * int variable for project erf number
     */
    int erf;
    /**
     * double variable for the total amount due for the project
     */
    double totalDue;
    /**
     * double variable for the total amount paid for the project
     */
    double totalPaid;
    /**
     * String variable for the deadline date for the project
     */
    String deadline;
    /**
     * Person variable for the architect assigned to the project
     */
    Person architect;
    /**
     * Person variable for the contractor assigned to the project
     */
    Person contractor;
    /**
     * Person variable for the customer assigned to the project
     */
    Person customer;
    /**
     * boolean variable for the finalized status of the project
     */
    boolean finalized;
    /**
     * String variable for the completion date of the project
     */
    String completionDate;

    /**
     * This is a constructor used to create Project objects
     * @param number int parameter for project number
     * @param name String parameter for project name
     * @param building String parameter for building type
     * @param address String parameter for building type
     * @param erf parameter for project erf number
     * @param totalDue double parameter for the total amount due for the project
     * @param totalPaid double parameter for the total amount paid for the project
     * @param deadline String parameter for the deadline date of the project
     * @param architect Person parameter for the architect assigned to the project
     * @param contractor Person parameter for the contractor assigned to the project
     * @param customer Person parameter for the customer assigned to the project
     * @param finalized boolean parameter for the finalized status of the project
     * @param completionDate String parameter for the completion date of the project
     */
    public Project(int number, String name, String building, String address, int erf, double totalDue,
                   double totalPaid, String deadline, Person architect, Person contractor, Person customer,
                   Boolean finalized, String completionDate) {

        // set project attributes

        this.number = number;

        // if name of building is not provided then set name to building type followed by customer surname
        if (name.isBlank()) {
            this.name = building + " " + ((customer.name).split(" "))[1];
        }
        else {
            this.name = name;
        }

        this.building = building;
        this.address = address;
        this.erf = erf;
        this.totalDue = totalDue;
        this.totalPaid = totalPaid;
        this.deadline = deadline;
        this.architect = architect;
        this.contractor = contractor;
        this.customer = customer;
        this.finalized = finalized;
        this.completionDate = completionDate;

    }

    /**
     * This is a void method used to set (update) the due date of the project
     * @param deadline the new deadline for the project
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * This is a void method used to set (update) the total amount paid for the project
     * @param totalAmount the new total amount paid for the project
     */
    public void setTotalAmount(double totalAmount) {
        this.totalPaid = totalAmount;
    }

    /**
     * This is a void method used to set the finalized boolean for the project to true
     * once the project has been finalized by the user
     */
    public void finalizeProject() {
        this.finalized = true;
    }

    /**
     * This is a void method used to set the completion date for the project to current date
     * once the project has been finalized by the user
     * @param completionDate the completion date (current date) of when the project was finalized
     */
    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    /**
     * This is a method used to return an invoice for the customer that the project is assigned to
     * @return returns a string representing an invoice that includes the customers name, contact details and amount due
     */
    public String invoice() {

        return "\nInvoice for " + customer.name +
                "\n\tEmail: " + customer.email +
                "\n\tTelephone number: " + customer.number +
                "\n\tAmount due: " + (totalDue-totalPaid) + "\n";
    }

    /**
     * This is a method used to return a string format of all the project details
     * @return returns a string with all the project details
     */
    public String toString() {

        return "\nProject details for project number " + number +
                "\n\tProject name: " + name +
                "\n\tBuilding type: " + building +
                "\n\tAddress: " + address +
                "\n\tERF: " + erf +
                "\n\tTotal due: " + totalDue +
                "\n\tTotal paid: " + totalPaid +
                "\n\tDeadline: " + deadline +
                "\n\tComplete: " + finalized +
                "\n\tCompletion date: " + completionDate +
                "\n\nArchitect details\n" + architect.toString() +
                "\n\nContractor details\n" + contractor.toString() +
                "\n\nCustomer details\n" + customer.toString();
    }

    /**
     * This is a method that is used to return a string format of all the project details
     * that can be easily stored and read from a text file by the program
     * @return returns a string format with all the project details in an efficient text file format
     */
    public String fileString() {

        return number + "#" + name + "#" + building + "#" + address + "#" + erf + "#" + totalDue + "#" + totalPaid
                + "#" + deadline + "#" + architect.fileString() + "#" + contractor.fileString() + "#"
                + customer.fileString() + "#" + finalized + "#" + completionDate;

    }

}
