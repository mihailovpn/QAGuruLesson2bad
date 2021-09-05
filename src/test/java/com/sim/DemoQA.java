package com.sim;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQA {
    @BeforeAll
    static void openMaximized() {
        Configuration.startMaximized = true;
    }
    @Test
    void fillTheForm () {
        open("https://demoqa.com/automation-practice-form");
        String firstName = "Pavel";
        String lastName = "Mikhaylov";
        String userEmail = "mih@test.ru";
        String userNumber = "9999999999";
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(userNumber);
        $("#submit").click();
    }

}
