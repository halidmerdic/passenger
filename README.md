# BASIC PASSENGER SERVICE
This project is made to register passengers and then we can find out who they are whether all of them or just one, update them or delete them.


## Acknowledgements

 - [YouTube Video](https://www.youtube.com/watch?v=9SGDpanrc8U)
 - [Stack Overflow](https://stackoverflow.com/)
 - Other Internet Resources
 
 
## API Reference

#### Get all the passengers

```http
  public List<Passenger> getAllPassengers(){

        return passengerRepository.findAll();
    }
```


#### Get specific passenger

```http
  public Optional<Passenger> getPassenger(String email){

        return passengerRepository.findPassengerByEmail(email);
    }
```


#### Add new passenger

```http
  public void addNewPassenger(Passenger passenger) {

        Optional<Passenger> passengerOptional = passengerRepository
                .findPassengerByEmail(passenger.getEmail());
        if(passengerOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        passengerRepository.save(passenger);
    }

#### Delete specific passenger

````http
    public void deletePassenger(Long passportId) {
        boolean exists = passengerRepository.existsById(passportId);
        if(!exists){
            throw new IllegalStateException(
                    "student with id" + passportId
                            + "does not exist");
        }
        passengerRepository.deleteById(passportId);
    }

#### Update passenger

```http
        public void updatePassenger(String firstName,
                                String lastName,
                                Long passportId,
                                String email) {
        Passenger passenger = passengerRepository.findById(passportId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id "
                                + passportId
                                + " does not exist"
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
  
  
## Appendix

I could not connect my database to the application.
  
## Author

- [@halidmerdic](https://github.com/halidmerdic)

## Tech Stack

**Client:** Java, IntelliJ IDEA, PostgreSQL



  
