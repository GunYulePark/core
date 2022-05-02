package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 애플리케이션의 설정정보(구성정보)
public class AppConfig {

    @Bean
    //각 메서드에 bean 적으면 된다. 그러면 스프링 컨테이너에 저장.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
//        생성자 주입(injection)
    }
//    ctrl + alt + m x2번 : extract method
//밑에 private 부분 자동 생성
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
//        갈아 끼울 때 이것만 변경하면 된다.

    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
        //        갈아 끼울 때 이것만 변경하면 된다.
    }
}
