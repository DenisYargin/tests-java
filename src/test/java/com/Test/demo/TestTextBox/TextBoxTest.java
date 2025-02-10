package com.Test.demo.TestTextBox;

import com.Test.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest extends TestBase {
    String url = "text-box";

    @Test
    void successfulFillFormTest() {

        open(url);
//        $("[id=userName]").setValue("Mr Smith");
        $("#userName").setValue("Denis Yargin");
        $("#userEmail").setValue("deiderd@mail.ru");
        $("#currentAddress").setValue("Kazan");
        $("#permanentAddress").setValue("Russia");
        $("#submit").click();

        $("#output").shouldHave(text("Denis Yargin"), text("deiderd@mail.ru"),
                text("Kazan"), text("Russia"));

        $("#output #name").shouldHave(text("Denis Yargin"));
    }
}