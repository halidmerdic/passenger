package com.example.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @RestController makes the class restfull
// can have end points
public class PassengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengerApplication.class, args);

//    try {
//       Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student",
//             "postgres", "password");
//    } catch (SQLException e) {
//       e.printStackTrace();
//    }


	}

}

