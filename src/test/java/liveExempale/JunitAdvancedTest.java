package liveExempale;

import com.codeborne.selenide.SelenideDriver;
import extensions.Chrome;
import extensions.FF;
import extensions.SelenideDriverParametrResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.text;

@ExtendWith(SelenideDriverParametrResolver.class)
public class JunitAdvancedTest {

    @Chrome
    @Test
    void yaTest(SelenideDriver driver) {
        driver.open("https://ya.ru/");
        driver.$("button[type='submit']").shouldHave(text("Найти"));
    }

    @FF
    @Test
    void yaFFTest(SelenideDriver driver) {
        driver.open("https://ya.ru/");
        driver.$("button[type='submit']").shouldHave(text("Найти"));
    }
}
