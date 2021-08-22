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

    public List<Passenger> getPassenger(){

        return passengerRepository.findAll();
    }

    public void addNewPassenger(Passenger passenger) {

        Optional<Passenger> passengerOptional = passengerRepository
                .findPassengerByEmail(passenger.getEmail());
        if(passengerOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        passengerRepository.save(passenger);
    }

    public void deletePassenger(Long passportId) {
        boolean exists = passengerRepository.existsById(passportId);
        if(!exists){
            throw new IllegalStateException(
                    "student with id" + passportId
                            + "does not exist");
        }
        passengerRepository.deleteById(passportId);
    }

    @Transactional
    public void updatePassenger(String firstName,
                                String lastName,
                                Long passengerId,
                                String email) {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + passengerId + " does not exist"
                ));
        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(passenger.getFirstName(), firstName)){
            passenger.setFirstName(firstName);
        }
        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(passenger.getLastName(), lastName)){
            passenger.setLastName(lastName);
        }
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

