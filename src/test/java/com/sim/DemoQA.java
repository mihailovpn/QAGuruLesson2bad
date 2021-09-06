package com.sim;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import java.io.File;

public class DemoQA {
    @BeforeAll
    static void openMaximized() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillTheForm () {
        open("/automation-practice-form");
        String firstName = "Pavel";
        String lastName = "Mikhaylov";
        String userEmail = "mih@test.ru";
        String gender = "Male";
        String userNumber = "9999999999";
        //String date = "06 Sep 2021";
        String subjectsInput = "Hindi";
        String hobbie = "Reading";
        File file = new File("src/GoogleTestsSuccess.png");
        String fileName = "GoogleTestsSuccess.png";
        String currentAddress = "SPB.ru";



        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select [value=\"4\"]").click();
        $(".react-datepicker__year-select [value=\"2001\"]").click();
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $(byText(hobbie)).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);


        $("#close-fixedban").click();
        $("#submit").click();

        $("tr:nth-child(1) > td:nth-child(2)").shouldHave(text(firstName + " " + lastName));
        $("tr:nth-child(2) > td:nth-child(2)").shouldHave(text(userEmail));
        $("tr:nth-child(3) > td:nth-child(2)").shouldHave(text(gender));
        $("tr:nth-child(4) > td:nth-child(2)").shouldHave(text(userNumber));
        //$("tr:nth-child(5) > td:nth-child(2)").shouldHave(text("")); // Не знаю как проверить число
        $("tr:nth-child(6) > td:nth-child(2)").shouldHave(text(subjectsInput));
        $("tr:nth-child(7) > td:nth-child(2)").shouldHave(text(hobbie));
        $("tr:nth-child(8) > td:nth-child(2)").shouldHave(text(fileName));
        $("tr:nth-child(9) > td:nth-child(2)").shouldHave(text(currentAddress));

        sleep(5000);
    }

}
