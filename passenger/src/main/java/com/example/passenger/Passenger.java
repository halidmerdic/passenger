package com.example.passenger;

import javax.persistence.*;

@Entity
@Table
public class Passenger {

    @Id
    @SequenceGenerator(
            name = "passenger_sequence",
            sequenceName = "passenger_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "passenger_sequence"
    )
    private String firstName;
    private String lastName;
    private Long passportId;
    private String email;

    public Passenger(String firstName,
                     String lastName,
                     long passportId,
                     String email) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportId=" + passportId +
                ", email='" + email + '\'' +
                '}';
    }
}



