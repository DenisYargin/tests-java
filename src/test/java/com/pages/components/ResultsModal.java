package com.pages.components;

import com.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {
    public void verifyModalAppears() {
        $(".modal-dialog").should(appear); //должен появиться
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); // проверяем текст
    }
    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));
    }
}
