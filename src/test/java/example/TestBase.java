package example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUp() {
        System.out.println("Главный тест запушен!!!");
//        System.out.println("А я не являюсь кусочком теста, я как кусок говна болтаюсь отдельно");
    }

   @AfterAll
    static void terDown() {
       System.out.println("Я из главного класса и все закрою за вами!!!");
//       System.out.println("А я не являюсь кусочком теста, я как кусок говна болтаюсь отдельно");
   }
}
