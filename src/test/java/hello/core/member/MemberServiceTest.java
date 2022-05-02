package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {


    MemberService memberService;

    // 테스트 전에 무조건 실행되게
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

//    AppConfig 이전
//    MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
//        memberService.findMember(1L) 기능 : return memberRepository.findById(memberId); memberID

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
        // Assertions는 import할 때 org.assertj 써야 한다. 편리한 api 많다.
        // member와 findMember이 같은 값이면 정상작동 / 다르면 error 발생.


//        member과 findMember이 같은지 확인해주는 역할
//        System.out.println("new member = " + member.getName());
//        System.out.println("find member = " + findMember.getName());
//        거의 이거 두개 출력해서 같은지 사람이 비교하는 역할
//        녹색불 뜨면 같은 것
    }
}
