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
//    initializing variables
    private String firstName;
    private String lastName;
    private Long passportId;
    private String email;
//    no argument constructor
    public Passenger() {
    }
//    argument constructor
    public Passenger(String firstName,
                     String lastName,
                     Long passportId,
                     String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
        this.email = email;
    }
//      getters and setters
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
//    toString method
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



