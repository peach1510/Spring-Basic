package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 구현 객체를 생성하고 연결하는 책임
// 어플리케이션이 어떻게 구성되는지 기입
@Configuration
public class AppConfig {

//    MemberService 생성.
//    이전에는 MemberService 안에서 생성했었음
//    Bean을 적으면 스프링 컨테이너에 등록된다.

    // @Bean memberService -> new MemoryMemberRepository() 를 호출
    // @Bean orderService -> memberService -> new MemoryMemberRepository()를 호출
    // 두 번... 생성 하는건가? (정말로?)

    // call AppConfig 한 결과 3번의 call이 호출 됨.
    // 호출은 세 번 하는데 메소드는 한 번만 호출됨.
   @Bean
    public MemberService memberService() {
       System.out.println("call AppConfig.memberService");
       return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    //    누군가 AppConfig를 통해서 OrderService를 조회하면 OrderServiceImpl이 반환된다.
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
