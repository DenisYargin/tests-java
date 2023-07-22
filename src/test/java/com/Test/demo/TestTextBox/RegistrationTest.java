package com.Test.demo.TestTextBox;

import com.Test.TestBase;
import com.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
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
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports"));
       // $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear); //должен появиться
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); // проверяем текст
        $(".table-responsive").shouldHave(text("Denis"), text("Yargin"),
                text("deiderd@mail.ru"), text("Russia Kazan"));
    }
}