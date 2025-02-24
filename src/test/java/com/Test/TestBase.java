package com.Test;

import com.codeborne.selenide.Configuration;
import com.pages.RegistrationPage;
import com.pages.components.CalendarCompanent;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    public RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
         Configuration.pageLoadStrategy = "none";
         Configuration.holdBrowserOpen = true;
//        Configuration.browser = "chrome";
//        Configuration.timeout = 3000;
    }
}