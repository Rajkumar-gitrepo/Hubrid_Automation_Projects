package com.qa.utilities;

import com.github.javafaker.Faker;

public class FakerDataGenerator {

	Faker faker = new Faker();

	public String fullName = faker.name().fullName();
	public String firstName = faker.name().firstName();
	public String lastName = faker.name().lastName();
    public String userName = faker.name().username();
	public String password = faker.internet().password();
	public String cellPhone = faker.phoneNumber().cellPhone();
    public String email = faker.internet().safeEmailAddress();
}
