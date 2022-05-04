package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//        memberService가 MemberServiceImpl의 인스턴스면 성공!
//        의문?? 오히려 memberService가 MemberServiceImpl의 interface 아닌가?
//        답 : AppConfig에 MemberService는 MemberServiceImpl를 불러온다.
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//        Assertions.assertThat 를 alt + Enter로 static import
    }

    @Test
    @DisplayName("구체(구현체) 타입으로 조회")
    void findBeanByName2() {
//        구현체로 적을 수 있지만, 좋지 않다. 역할에 의존하게 해야 좋다.(구체에 의존하면 안된다.)
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
//        ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
//        org.junit.jupiter.api.Assertions.assertThrows() 이거 후 alt+Enter로 static import
//        NoSuchBeanDefinitionException : 예외가 터져야 테스트가 성공. 안터지면 실패
    }
}
