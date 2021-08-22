package com.example.passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//convention for anything accessing our database
//JPA specifically

//need to put T (type) in the <> and id for type we want

@Repository
public interface PassengerRepository
        extends JpaRepository<Passenger, Long> {

    @Query("SELECT s FROM Student WHERE s.email = ?1")
//    SELECT * FROM student WHERE email = ?
    Optional<Passenger> findPassengerByEmail(String email);

}
