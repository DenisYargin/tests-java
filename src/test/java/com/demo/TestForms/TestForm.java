package com.demo.TestForms;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demo.TestBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class TestForm extends TestBase {
    String urlForms = "https://demoqa.com/automation-practice-form";
    SelenideElement name = $("#firstName");
    SelenideElement lastName = $("#lastName");
    SelenideElement email = $("#userEmail");
    SelenideElement subjects = $("#subjectsContainer");
    SelenideElement hobbies = $("#hobbies-checkbox-1");
    SelenideElement address = $("#currentAddress");
    SelenideElement date = $("#dateOfBirth");
    SelenideElement submit = $("#submit");
    String dateString = "20 Apr 2023";
    String currentAddress = "dada";
    ElementsCollection gender = $$x("//*[contains(@id,'gender-radio')]");

    @Test
    void checkSetFormsSuccess(){
        open(urlForms);
        name.setValue("Denis");
        lastName.setValue("Yargin");
        email.setValue("deiderd@mail.ru");
      //  subjects.click();
       // subjects.setValue();
        hobbies.setValue("box");
        address.setValue("Kazan");
        date.setValue(dateString);
        address.setValue(currentAddress);
        gender.first().click();

    }
}
