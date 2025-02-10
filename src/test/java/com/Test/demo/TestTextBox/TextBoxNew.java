package com.Test.demo.TestTextBox;

import com.Test.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxNew extends TestBase {
    String url = "text-box";
    @Test
    void testOne(){
        open(url);
        $("#userName").setValue("Denis Yargin");
    }

}
