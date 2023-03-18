package cobyspring.config.autoconfig;


import cobyspring.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@MyAutoConfiguration
public class DispatcherServletConfig {
    @Bean DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }
}
