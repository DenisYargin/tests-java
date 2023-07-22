package com.Test.demo.TestTextBox;

import com.Test.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest extends TestBase {




    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                        .setFirstName("Denis")
                        .setLastName("Yargin")
                        .setUserEmail("deiderd@mail.ru")
                        .setGender()
                        .setUserNumber("+79023770262");

        $("#userNumber").setValue("89023770262");
        $("#currentAddress").setValue("Russia Kazan");
        $("#dateOfBirthInput").click();

        registrationPage.setDate("11", "april", "1994") ;
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports"));
       // $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        //verifyModalAppers
        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResults("Full name", "Denis Yargin")
                        .verifyResults("Email", "deiderd@mail.ru")
                .verifyResults("Point", "Russia Kazan");


    }
}