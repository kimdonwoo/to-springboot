package cobyspring.config.autoconfig;

import cobyspring.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@MyAutoConfiguration
public class PropertyPlaceholderConfig {
    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        // 빈을 정의하고 있는 기본적인 정보를 모은 다음에 후처리기를 돌림
        return new PropertySourcesPlaceholderConfigurer();
    }
}