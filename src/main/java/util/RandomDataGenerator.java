package util;

import com.github.javafaker.Faker;
public class RandomDataGenerator {
    private static Faker faker = new Faker();

    public static String getRandomName() {
        return faker.name().fullName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomCompany() {
        return faker.company().name();
    }

    public static String getRandomJobTitle() {
        return faker.job().title();
    }
}
