package example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Demo extends TestBase{

//    @BeforeAll
//    static void setUp() {
//        System.out.println("Тест в классе запушен!!!");
//        System.out.println("А я не являюсь кусочком теста, я как кусок говна болтаюсь отдельно");
//    }

    @BeforeEach
    void start() {
        System.out.println("Я буду запускаться перед каждым тестом!!! ");
//        System.out.println("И тут нужно добавлять нужные методы - Открыть браузер, Подключить Листнер и т.д!!");
//        System.out.println("Это надо подключать тут, а не в БефорОлл");
//        System.out.println("Потому что я являюсь кусочком теста");

    }

    @Test
    void perviiTest () {
        System.out.println(" Я первый тест !!!");
    }

    @Test
    void vtoroiTest () {
        System.out.println(" Я второй тест !!!");
    }


    @ValueSource(strings = {
            "Вася", "Петя"
    })
    @ParameterizedTest
    void nameOfTron(String name) {
        System.out.println(name);
    }

    @CsvSource(value = {
            "Вася, 666", "Петя, 777"
    })
    @ParameterizedTest
    void nameOfTron(String name, int num) {
        System.out.println(name + num);
    }
}
