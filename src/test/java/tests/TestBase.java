package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    public static void testBase() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920*1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterAll
    public static void browserClose() {
        Selenide.closeWebDriver();
    }
}
