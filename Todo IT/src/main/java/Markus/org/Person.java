package Markus.org;


import Markus.models.AppUser;

public class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private AppUser credentials;


    public Person(String firstName, String lastName, String eMail) {
        this.id = IdGenerator.generateId();
        setFirstName(firstName);
        setLastName(lastName);
        seteMail(eMail);
    }

    public int getId() {
        return id;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("firstName cannot be null or empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("lastName cannot be null or empty");
        }
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        if (eMail == null || eMail.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.eMail = eMail;

    }

    public String getSummary() {
        return "ID: (" + id + ") | Name: " + getFirstName() + " | LastName: " + getLastName() + " | Email: " + geteMail();

    }

    @Override
    public String toString() {
        return "Person{" +
                "credentials=" + credentials +
                ", eMail='" + eMail + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }

}
