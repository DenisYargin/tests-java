package com.Test.Junit;

import com.Test.Junit.domain.Locale;
import com.codeborne.selenide.CollectionCondition;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Класс с демонстрационными тестами")
public class simpleTest {

    @Test
    @DisplayName("Аннотации") //Можно использовать, когда название метода (теста) не передает сути теста.
    //@Disabled - отключает тест. Можно использовать когда баг минорный, но нужно катить в пром.
    @Tags({ // использовать, например при сортировки тестов для CI
            @Tag("SMOKE"),
            @Tag("WEB")
    })
    void simpleTest(){
        Assertions.assertEquals(3, 1+2);
    }

//для передачи нескольких аргументов
    @CsvSource({
            "selenide, https://selenide.org",
            "JUnit, https://junit.org"
    })
    //для передачи одного аргумента
    @ValueSource(strings = {
            "selenide",
            "junit"
    })

    @Test
    @ParameterizedTest(name = "Для поискового запроса: {0} в выдаче присутствует url: {1}")
    void succesfulSearchTest(String searchQuery, String expectedUrl){
        $("name=q").setValue(searchQuery).pressEnter();
        $("id=serch").shouldHave(text(expectedUrl));
    }


    static Stream<Arguments> selenideLocaleTest(){
        return Stream.of(
                Arguments.of(Locale.EN, Arrays.asList("Quick", "start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Locale.RU, Arrays.asList("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }

    @MethodSource
    @ParameterizedTest
    void selenideLocaleTest(Locale siteLocale, List<String> expectedButtons){
        open("https://selenide.org");
        $$("#languages a").find(text(siteLocale.name())).click();
        $$(".main-menu-pages a").filter(visible).shouldHave(CollectionCondition.texts(expectedButtons));
    }
}
