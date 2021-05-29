package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class StudentRegistrationFormPage {

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void typeFirstName(String value) {
        $("#firstName").setValue(value);
    }

    public void typeSecondName(String value) {
        $("#lastName").setValue(value);
    }

    public void typeEmail(String value) {
        $("#userEmail").setValue(value);
    }

    public void chooseGender(String value) {
        $(byText(value)).click();
    }

    public void typePhoneNumber(String value) {
        $("#userNumber").setValue(value);
    }

    public void chooseDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();
    }

    public void typeSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
    }

    public void chooseHobby(String value){
        $(byText(value)).click();
    }

    public void uploadImage(String value) {
        $("#uploadPicture").uploadFromClasspath("images/" + value);
    }

    public void typeAddress(String value) {
        $("#currentAddress").setValue(value).scrollTo();
    }

    public void chooseStateAndCity(String state, String city) {
        $(byText("Select State")).click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();
    }

    public void pressSubmit() {
        $("#submit").click();
    }

    public void checkResults(String firstName,
                             String lastName,
                             String email,
                             String gender,
                             String mobile,
                             String dayOfBirth,
                             String monthOfBirth,
                             String yearOfBirth,
                             String subject,
                             String hobby,
                             String picture,
                             String currentAddress,
                             String state,
                             String city)
    {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$("tbody tr").filterBy(text("Student name")).shouldHave(texts(firstName + " " + lastName));
        $$("tbody tr").filterBy(text("Student Email")).shouldHave(texts(email));
        $$("tbody tr").filterBy(text("Gender")).shouldHave(texts(gender));
        $$("tbody tr").filterBy(text("Mobile")).shouldHave(texts(mobile));
        $$("tbody tr").filterBy(text("Date of Birth")).shouldHave(texts(dayOfBirth+" "+monthOfBirth+","+yearOfBirth));
        $$("tbody tr").filterBy(text("Subjects")).shouldHave(texts(subject));
        $$("tbody tr").filterBy(text("Hobbies")).shouldHave(texts(hobby));
        $$("tbody tr").filterBy(text("Picture")).shouldHave(texts(picture));
        $$("tbody tr").filterBy(text("Address")).shouldHave(texts(currentAddress));
        $$("tbody tr").filterBy(text("State and City")).shouldHave(texts(state+" "+city));
    }


}
