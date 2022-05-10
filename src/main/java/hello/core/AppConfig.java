package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

//    MemberService 생성.
//    이전에는 MemberService 안에서 생성했었음
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

//    누군가 AppConfig를 통해서 OrderService를 조회하면 OrderServiceImpl이 반환된다.
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
