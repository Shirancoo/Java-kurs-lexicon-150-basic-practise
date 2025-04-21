package org.example;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private String reservationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Customer customer;
    private ParkingSpot parkingSpot;
    private Status status;

    public Reservation(Customer customer, ParkingSpot parkingSpot, int hours) {
        this.reservationId = UUID.randomUUID().toString();
        this.startTime = LocalDateTime.now();
        this.endTime = startTime.plusHours(hours);
        this.customer = customer;
        this.parkingSpot = parkingSpot;
    }

    public String getReservationId() {
        return reservationId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Status getStatus() {
        return status;
    }

    public void setEndTime(int hours) {
        if (hours <= 0) throw new IllegalArgumentException("Houres must be greater than 0");
        this.endTime = this.endTime.plusHours(hours);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", customer=" + customer +
                ", parkingSpot=" + parkingSpot +
                ", status=" + status +
                '}';
    }
}
