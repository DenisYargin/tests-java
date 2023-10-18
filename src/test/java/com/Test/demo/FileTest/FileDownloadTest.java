package com.Test.demo.FileTest;


import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.*;

public class FileDownloadTest {
    @Test
    void downloadTest() throws Exception {
        open("https://github.com/DenisYargin/ilswebreact/blob/master/README.md");
        File download  =  $("a[href*='/DenisYargin/ilswebreact/raw/master/README.md']").download();

     //   try (InputStream is = new FileInputStream(download)){
        //    byte[] bytes = is.readAllBytes();
          //  String fileAsString = new String(bytes, StandardCharsets.UTF_8);
            //Assertions.assertTrue(fileAsString.contains("Негативные тесты авторизации сайта"));
        }


    @Test
    void uploadTest() throws Exception{
        open("https://tus.io/demo.html");
        $("input[type='file']").uploadFromClasspath("bf0ab79c-53b1-4b0e-824c-a4f41951bd00.jpg");
        $("_root_1as67_1").shouldHave(Condition.text("The upload is complete!"));
    }
}
