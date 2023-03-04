package cobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloServiceCountTest {
    @Autowired HelloService helloService;
    @Autowired HelloRepository helloRepository;

    // controller가 service를 사용하고 있움.
    // 즉 Controller 입장에서 테스트
    @Test
    void sayHelloIncreaseConnt(){
        IntStream.rangeClosed(1,10).forEach(count -> {
            helloService.sayHello("donu");
            Assertions.assertThat(helloRepository.countOf("donu")).isEqualTo(count);
        });

        // 지금 한거는 HelloService 빈을 가져와서 실행한거고 API를 통해서도 동작을 할까?

    }
}
