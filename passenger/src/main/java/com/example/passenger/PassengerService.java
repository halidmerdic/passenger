package com.example.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
//      getting all the passengers
    public List<Passenger> getPassenger(){

        return passengerRepository.findAll();
    }
//      adding a new passenger
    public void addNewPassenger(Passenger passenger) {

        Optional<Passenger> passengerOptional = passengerRepository
                .findPassengerByEmail(passenger.getEmail());
        if(passengerOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        passengerRepository.save(passenger);
    }
//      deleting passenger
    public void deletePassenger(Long passportId) {
        boolean exists = passengerRepository.existsById(passportId);
        if(!exists){
            throw new IllegalStateException(
                    "student with id" + passportId
                            + "does not exist");
        }
        passengerRepository.deleteById(passportId);
    }
//      updating passenger
    @Transactional
    public void updatePassenger(String firstName,
                                String lastName,
                                Long passportId,
                                String email) {
//        checking is there passenger with specific passport ID
        Passenger passenger = passengerRepository.findById(passportId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id "
                                + passportId
                                + " does not exist"
                ));
//        checking is there useful first name and updating it
        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(passenger.getFirstName(), firstName)){
            passenger.setFirstName(firstName);
        }
//        checking is there useful last name and updating it
        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(passenger.getLastName(), lastName)){
            passenger.setLastName(lastName);
        }
//        checking is there useful email and updating it
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(passenger.getEmail(), email)){
            Optional<Passenger> passengerOptional = passengerRepository
                    .findPassengerByEmail(email);
            if(passengerOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            passenger.setEmail(email);
        }
    }

}

