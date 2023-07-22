package com.pages;

import com.codeborne.selenide.SelenideElement;
import com.pages.components.CalendarCompanent;
import com.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class RegistrationPage {
    //SelenideElements / locator / etc

    public CalendarCompanent calendarCompanent = new CalendarCompanent();
    ResultsModal resultsModal = new ResultsModal();

    String url = "automation-practice-form";
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumber = $("#userNumber"),
            gender = $("#gender-radio-1"),
            formHeaderText = $(".practice-form-wrapper");


    public RegistrationPage openPage() {
        open(url);
        formHeaderText.shouldHave(text("Student Registration Form"));

        return this;
    }


    // Actions
    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);

        return this;
    }

    public RegistrationPage setLastName(String name) {
        lastNameInput.setValue(name);

        return this;
    }

    public RegistrationPage setUserNumber(String number) {
        userNumber.setValue(number);

        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    public RegistrationPage setGender() {
        gender.parent().click();

        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        calendarCompanent.setDate("11", "april", "1994");

        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        resultsModal.verifyResult(key, value);


        return this;
    }


    public RegistrationPage verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();

        return this;
    }

}


