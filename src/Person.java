/**
 * This Person class is a class that is used to create person objects
 *
 * @author egorzakharov
 * @version 2.0
 * @since 2021-06-09
 */
public class Person {

    /**
     * String name of the person
     */
    String name;
    /**
     * String telephone number of the person
     */
    String number;
    /**
     * String email address of the person
     */
    String email;
    /**
     * String physical address of the person
     */
    String address;

    /**
     * This is a constructor used to create Person objects
     * @param name String parameter for person name
     * @param number String parameter for person telephone number
     * @param email String parameter for person email address
     * @param address String parameter for person physical address
     */
    public Person(String name, String number, String email, String address) {

        // set Person attributes
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;

    }

    /**
     * This is a method used to set (update) the email address of a person
     * @param email String parameter of the new email address to be set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This is a method used to set (update) the telephone number of a person
     * @param number String paramter of the new telephone number to be set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * This is a method used to return a string format of all the person details
     * @return returns a string with all the person's details
     */
    public String toString() { return "\tName: " + name + "\n\tNumber: " + number
            + "\n\tEmail: " + email + "\n\tAddress: " + address;}

    /**
     * This is a method that is used to return a string format of all the person details
     * that can be easily stored and read from a text file by the program
     * @return returns a string format with all the person's details in an efficient text file format
     */
    public String fileString() {
        return name + "|" + number + "|" + email + "|" + address;
    }

}
