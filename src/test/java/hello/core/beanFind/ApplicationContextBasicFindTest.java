package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회하기")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // 검증, 멤버 서비스가 MemberServiceImpl의 인스턴스인지 확인
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로 조회하기")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        // 검증, 멤버 서비스가 MemberServiceImpl의 인스턴스인지 확인
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회하기")
    void findBeanByName2() {
        // 스프링 빈에 등록된 인스턴스의 타입으로 확인하기 때문에 MemberServiceImpl도 작동한다.
        // 그러나 구체 타입으로 조회하면 유연성이 떨어진다.
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        // 검증, 멤버 서비스가 MemberServiceImpl의 인스턴스인지 확인
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
        // 빈 이름으로 조회하는데 없으면 오류가 난다.
        // ac.getBean("xxxx", MemberService.class);

        // 오른쪽의 로직을 실행하면 왼쪽에 있는 예외가 떠 줘야 한다는 뜻.
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }
}
