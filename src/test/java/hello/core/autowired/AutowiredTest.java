package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    // 스프링 빈으로 등록
    static class TestBean {

        // Bean 없는 거 아무거나 집어 넣는 거임
        @Autowired(required=false) // noBean1 자체가 호출이 안 되었음. 의존관계가 없으면 이 메서드 자체가 호출 안 된다는 뜻!
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        // 자동 주입할 대상이 없으면 null이 반환
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean1 = " + noBean2);
        }

        // 스프링 빈이 없다면 Optional.empty 를 반환
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
