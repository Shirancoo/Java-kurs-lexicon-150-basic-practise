package Markus.org;


public class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private AppUser credentials;

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    public String getFirstName() {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("firstName cannot be null or empty");
        }
        return firstName;
    }

    public void setFirstName(String firstName) {

            if (firstName == null || firstName.isEmpty()) {
                throw new IllegalArgumentException("firstName cannot be null or empty");
            }
            this.firstName = firstName;
        }

    public String getLastName() {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("lastName cannot be null or empty");
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return  "ID: (" + id + ") | Name: " + getFirstName() + " | LastName: " + getLastName() + " | Email: " + geteMail();

    }
}
