package cobyspring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloDecorator implements HelloService{
    private final HelloService helloService;

    // 생성자를 통해 주입받음
    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name){
        return "*" + helloService.sayHello(name)+ "*";
    }

    @Override
    public int countOf(String name) {
        return helloService.countOf(name);
    }
}
