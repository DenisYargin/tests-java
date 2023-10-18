package com.Test.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class LabelsTest {
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Яргин Денис")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизированного пользователя")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авторизированного пользователя"));
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "Яргин Денис");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.label("Testing", "https://testing.github.com ");
    }
}
