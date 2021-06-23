package liveExempale;

import com.codeborne.selenide.SelenideDriver;
import extensions.Chrome;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JunitAdvancedTest {

    @Chrome
    @Test
    void yaTest(SelenideDriver driver) {
        driver.open("https://ya.ru/");
        driver.$("button[type='submit']").shouldHave(text("Найти"));
    }
}
