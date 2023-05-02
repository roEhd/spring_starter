package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.discount.DiscountPolicy;

public class AppConfig {
    public MemberService memberService(){

        return new MemberServiceImpl(
                getMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                getMemberRepository(),
                getDiscountPolicy());
    }

    private static DiscountPolicy getDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
    private static MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }
}
