package github;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void  shouldFindSelenideRepositoryAtTheTop(){
        //открыть главную страницу
        open("https://github.com/");

        //ввести в поле поиска selenide и нажать enter
        $("[class='search-input']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        //кликнуть на первый репозиторий из списка найденых
        $$("div[data-testid='results-list']").first().$("a").click();

        //проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }

}
