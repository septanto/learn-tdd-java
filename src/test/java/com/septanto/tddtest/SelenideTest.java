package com.septanto.tddtest;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class SelenideTest {
    @Test
    public void wikipediaSearchFeature() throws InterruptedException {

        // Opening Wikipedia page
        open("https://en.wikipedia.org/wiki/Main_Page");

        // Searching TDD
        $(By.name("search")).setValue("Test-driven development");

        // Clicking search button
        $(By.name("go")).click();

        // Checks
        assertThat(title(), startsWith("Test-driven development"));
    }
}
