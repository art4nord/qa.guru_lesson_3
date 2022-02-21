package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.w3c.dom.events.EventTarget;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import java.io.File;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1080";

    }

    @Test
    void successFillTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("petrov@sony.com");

        //кнопка
        $("[name=gender][value=Male]").parent().click();

        $("#userEmail").setValue("petrov@sony.com");

        $("#userNumber").val("7111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").val("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("./img/1.png");
        $("#currentAddress").setValue("Other address 2");

        $("#state").scrollTo();


        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Oleg"), text("petrov@sony.com"));
    }

}