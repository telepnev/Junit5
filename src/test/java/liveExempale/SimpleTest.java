package liveExempale;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class SimpleTest {

    @Tag("web")
    @Test
    void  anyTest() {

    }


    @AfterEach
    void takeScreen(TestInfo testInfo) {
        if (testInfo.getTags().contains("web")) {
            takeScreenWebDriver();
        }
    }

    private void takeScreenWebDriver() {
    }
}
