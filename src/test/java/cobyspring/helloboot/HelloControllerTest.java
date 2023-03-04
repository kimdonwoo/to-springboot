package cobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class HelloControllerTest {
    @Test
    void helloController(){
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test");

        Assertions.assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failsHelloController(){
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(()->{
            helloController.hello(null); // null이면 예외 던짐
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->{
            helloController.hello(""); // 공백일때 예외 던짐
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
