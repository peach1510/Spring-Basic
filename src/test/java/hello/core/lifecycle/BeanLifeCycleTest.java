package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void LifeCycleTest() {
        // ApplicationContext 밑에 ConfigurableApplicationContext가 있고 그 아래에 Annotation~ 이 있다.
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(NetworkClient.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            // 외부에서 값을 세팅하고 나서 초기화를 호출해야 할 때가 굉장히 많다.
            // 외부에서 수정자 주입을 통해 setUrl()이 호출되어야 url이 존재하게 된다.
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
