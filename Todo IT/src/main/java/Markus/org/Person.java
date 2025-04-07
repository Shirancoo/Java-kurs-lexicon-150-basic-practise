package Markus.org;


public class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String eMail;


    public String getFirstName() {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        return lastName;
    }

    public String setLastName(String lastName) {
        return lastName;
    }


    public String geteMail() {
        if (eMail == null) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Person(String firstName, String lastName, String eMail) {
        this.id = IdGenerator.generateId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
    }

    public String getSummary() {
        return " ID: " + id + " | Name: " + getFirstName() + " | LastName: " + getLastName() + " | Email: " + geteMail();
    }
}
