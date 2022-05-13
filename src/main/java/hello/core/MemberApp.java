package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        // 구현체 가지고 와서 join이랑 findMember 가능하게 만듬
        // 멤버 정보, 멤버 아이디

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // ApplicationContext => 스프링 컨테이너
        // AppConfig의 환경설정 정보를 가지고 아래의 Bean들을 전부 스프링 컨테이너에 다 집어 넣어 관리할 수 있다.

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // Bean에 메서드 이름으로 등록됨, 뒤에는 반환 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
