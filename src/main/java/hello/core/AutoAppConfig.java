package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 이 위치에서부터 찾음
        basePackages = "hello.core",
        // 지정한 클래스의 패키지를 탐색 위치로 시작한다.
        // 지정 안 해주면 패키지 전체 다 뒤진다.
        basePackageClasses = AutoAppConfig.class,
        // 기존에 수동으로 빈 등록한 AppConfig 제외 (Configuration 제외)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
