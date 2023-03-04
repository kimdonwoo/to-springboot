package cobyspring.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConditionalTest {
    @Test
    void conditional(){
        // true
//        ApplicationContextRunner contextRunner = new ApplicationContextRunner();
//        contextRunner.withUserConfiguration(Config1.class)
//                .run(context -> {
//                    assertThat(context).hasSingleBean(MyBean.class);
//                    assertThat(context).hasSingleBean(Config1.class);
//                });

//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
//        ac.register(Config1.class);
//        ac.refresh();
//        MyBean bean = ac.getBean(MyBean.class);

        // false
//        new ApplicationContextRunner().withUserConfiguration(Config2.class)
//                .run(context -> {
//                    assertThat(context).doesNotHaveBean(MyBean.class);
//                    assertThat(context).doesNotHaveBean(Config1.class);
//                });

//        AnnotationConfigApplicationContext ac2 = new AnnotationConfigApplicationContext();
//        ac2.register(Config2.class);
//        ac2.refresh();
//
//        MyBean bean2 = ac2.getBean(MyBean.class);
        // 그런 Bean은 찾을 수 없다는 에러가 뜸 (즉, @Conditional이 false라 Bean이 생성이 안됨)


    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(TrueCondition.class)
    @interface TrueConditional{}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(FalseCondition.class)
    @interface FalseConditional{}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(BooleanCondition.class)
    @interface BooleanConditional{
        boolean value();

    }

    @Configuration
    @BooleanConditional(true)
    static class Config1 {
        @Bean
        MyBean myBean(){
            return new MyBean();
        }
    }

    @Configuration
    @BooleanConditional(false)
    static class Config2 {
        @Bean
        MyBean myBean(){
            return new MyBean();
        }
    }

    static class MyBean {}

    static class TrueCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

            return true;
        }
    }

    static class FalseCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }

    static class BooleanCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional.class.getName());
            Boolean value = (Boolean) annotationAttributes.get("value");

            return value;
        }
    }
}
