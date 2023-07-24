package com.Test.demo.TestTextBox;

import com.Test.TestBase;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest extends TestBase {




    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String mail = faker.internet().emailAddress();

        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(mail)
                        .setGender()
                        .setUserNumber("89023770262")
                        .setAddress("Russia Kazan")
                        .setSubject("Math")
                        .setHobbies("Sports");
        registrationPage.setDate("11", "April", "1994");
       // $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        //verifyModalAppers
        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                        .verifyResults("Student Email", mail)
                .verifyResults("Address", "Russia Kazan");


    }
}