package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerTestData {
    Faker faker = new Faker(new Locale("en-GB"));

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            yearOfBirth = String.format("%s", faker.number().numberBetween(1950, 2010)),
            monthOfBirth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            dayOfBirth = String.format("%s", faker.number().numberBetween(10, 28)),
            subjects = faker.options().option("Accounting", "Chemistry", "Arts", "Social Studies",
                    "Biology", "Chemistry", "Computer Science", "Commerce", "Economics", "Civics", "Hindi",
                    "English", "History"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("photo.jpg"),
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = selectCity(state);

    public String selectCity(String state) {
        return switch (this.state) {
            case "NSR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}









