package com.Test.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("ищем репозиторий")
    public void searchRepository(String repo){
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("кликаем по ссылке репозитория")
    public void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }

    @Step("открываем таб Issue")
    public void openIssueTab(String issue){
        $("#issues-tab").click();
    }

    @Step("Проверям наличие Issue с номером")
    public void shouldSeeIssueWithNumber(String issue){
        $(withText(issue)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
