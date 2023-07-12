package com.Test.dragNDrop;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class dragAndDrop {
    @Test
    void dragAndDropA(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").$("header").shouldHave(Condition.text("A"));
        $("#column-b").$("header").shouldHave(Condition.text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").$("header").shouldHave(Condition.text("B"));
        $("#column-b").$("header").shouldHave(Condition.text("A"));

    }
}
