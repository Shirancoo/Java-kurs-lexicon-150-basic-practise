package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

    private Integer id;
    private String name;
    private String phoneNumber;
    private String vehiclePlate;

    public Customer(Integer id, String name, String phoneNumber, String vehiclePlate) {
        setId(id);
        setName(name);
        setPhoneNumber(phoneNumber);
        setVehiclePlate(vehiclePlate);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null) throw new IllegalArgumentException("should id not be null");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name should not be null or empty");
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty())
            throw new IllegalArgumentException("PhoneNumber should not be null or empty");
        this.phoneNumber = phoneNumber;

        final String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) throw new IllegalArgumentException("Invalid Phone Number");
        this.phoneNumber = phoneNumber;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        if (vehiclePlate == null || vehiclePlate.trim().isEmpty())
            throw new IllegalArgumentException("VehiclePlate should not be null or empty");
        // todo: you can add regex for validating the plate number
        this.vehiclePlate = vehiclePlate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", vehiclePlate='" + vehiclePlate + '\'' +
                '}';
    }
}
