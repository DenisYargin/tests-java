package com.Test.demo.FileTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class FileParsingTest {
    private  ClassLoader cl = FileDownloadTest.class.getClassLoader();

    @Test
    void pdfParseTest() throws Exception{
        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
        File download = $("a[href*='junit-user-guide-5.10.0.pd']").download();
        PDF pdf = new PDF(download);
        Assertions.assertEquals("Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein", pdf.author);
    }

   @Test
    void csvParseTest() throws Exception {
       try (InputStream is = cl.getResourceAsStream("list.csv");
            InputStreamReader isr = new InputStreamReader(is)) {
           CSVReader csvReader = new CSVReader(isr);
           List<String[]> strings = csvReader.readAll();
           Assertions.assertArrayEquals(new String[]{"Денис", "Яргин"}, strings.get(1));
       }
   }

   @Test
    void  jsonTest() throws Exception {
       Gson gson = new Gson();
       try (InputStream is = cl.getResourceAsStream("human.json");
            InputStreamReader isr = new InputStreamReader(is)) {
           JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);
           Assertions.assertTrue(jsonObject.get("isClever").getAsBoolean());
           Assertions.assertEquals(29, jsonObject.get("age").getAsInt());
       }
   }

   @Test
       void  jsonCleverTest() throws Exception{
           Gson gson = new Gson();
           try (InputStream is = cl.getResourceAsStream("human.json");
                InputStreamReader isr = new InputStreamReader(is)) {
               Human human = gson.fromJson(isr, Human.class);
               Assertions.assertTrue(human.isClever);
               Assertions.assertEquals(29,human.age);
           }

   }


}
