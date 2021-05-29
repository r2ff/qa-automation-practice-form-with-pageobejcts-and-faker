package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.javafaker.Faker;
import pages.StudentRegistrationFormPage;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.*;

public class StudentRegistrationFormTests extends TestBase {

    Faker faker = new Faker();
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            monthOfBirth = getRandomMonth(),
            yearOfBirth = "2004",
            dayOfBirth = getRandomDay(),
            subject = "Chemistry",
            hobby = getRandomHobby(),
            picture = "1.png",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    void checkAutomationPracticeForm() {
        studentRegistrationFormPage.openPage();
        studentRegistrationFormPage.typeFirstName(firstName);
        studentRegistrationFormPage.typeSecondName(lastName);
        studentRegistrationFormPage.typeEmail(email);
        studentRegistrationFormPage.chooseGender(gender);
        studentRegistrationFormPage.typePhoneNumber(mobile);
        studentRegistrationFormPage.chooseDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        studentRegistrationFormPage.typeSubject(subject);
        studentRegistrationFormPage.chooseHobby(hobby);
        studentRegistrationFormPage.uploadImage(picture);
        studentRegistrationFormPage.typeAddress(currentAddress);
        studentRegistrationFormPage.chooseStateAndCity(state, city);
        studentRegistrationFormPage.pressSubmit();

        studentRegistrationFormPage.checkResults(
                firstName,
                lastName,
                email,
                gender,
                mobile,
                dayOfBirth,
                monthOfBirth,
                yearOfBirth,
                subject,
                hobby,
                picture,
                currentAddress,
                state,
                city);
    }

}
