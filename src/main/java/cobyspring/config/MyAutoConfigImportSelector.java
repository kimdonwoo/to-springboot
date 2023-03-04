package cobyspring.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class MyAutoConfigImportSelector implements DeferredImportSelector{

    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //ImportCandidates candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
        // Spring container가 빈을 생성하기위해 빈 클래스를 로딩할 때 사용하는 거
        // candidates에는 파일에다가 설정해둘 자동 구성에 사용할 Configuration의 목록들이 들어있음

        List<String> autoConfigs = new ArrayList<>();

        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);

        return autoConfigs.toArray(new String[0]);
        //return autoConfigs.stream().toArray(String[]::new);
        //return Arrays.copyOf(autoConfigs.toArray(),autoConfigs.size(),String[].class);

    }
}
