package com.airline.testData;

public record AirlineRecord(String firstName,
		String lastName,
		String email,
		String password,
		String street,
		String city,
		String zip,
		String passengersCount,
		String expectedPrice) {

}
