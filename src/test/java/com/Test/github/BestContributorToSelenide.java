package com.Test.github;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void andreiSolntsevShouldBeTheFirstContributor(){
        //открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");

        //подвести мышку к первому аватару из блока contributors
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();

        //проверка: во всплывающем окне есть текст "Andrei Solntsev"
        $(".Popover").shouldHave(text("Andrei Solntsev"));
    }
}
