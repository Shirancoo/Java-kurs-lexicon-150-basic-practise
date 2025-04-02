package Markus.org;

public class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String eMail;

    public Person(int id, String firstName, String lastName, String eMail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
    }


    public int getId() {
        return this.id;
    }

    public void seteMail(String eMail) {

        if (eMail == null || eMail.isEmpty()) {
            throw new IllegalArgumentException("Invalid Email for " + getFirstName() + " You need to add An Email");
        }

        if (!eMail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException ("Invalid email format for " + getFirstName() + ".");
        }
            this.eMail = eMail;
    }


    public String getFirstName() {
        return this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
    }

    public void setLastName(String lastName) {

        this.lastName = capitilaizeLetter(lastName);

    }

    public String getLastName() {
            return this.lastName;

    }

    public void setFirstName(String firstName) {
        this.firstName = capitilaizeLetter(firstName);
    }

    public String getSummay() {

        return "Person Data: ID: " + getId() + ", First Name: " + getFirstName() +
                ", Last Name: " + getLastName() + ", Email: " + eMail;

    }
    private String capitilaizeLetter (String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

}

