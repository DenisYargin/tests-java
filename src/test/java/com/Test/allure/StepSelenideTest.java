package com.Test.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepSelenideTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "#80";
    @Test
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("ищем репозиторий" + REPOSITORY, () ->{
            $(".search-input").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("кликаем по ссылке репозитория" + REPOSITORY,() ->{
            $(linkText(REPOSITORY)).click();
        });
        step("открываем таб Issue", ()->{
            $("#issues-tab").click();
        });
        step("Проверям наличие Issue с номером");
        $(withText(ISSUE)).should(Condition.exist);
    }

    @Test
    public void testAnnotatedStep(){
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssueTab(ISSUE);
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}
