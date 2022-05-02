package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) { // 단축키 'psvm' + enter
//        AppConfig 사용.
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        memberServiceImpl(new memoryMemberRepository)가 memberService에 저장됨.

//        이건 AppConfig사용 전
//        MemberService memberService = new MemberServiceImpl();

//        스프링
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // argument : (이름, 타입)
//        default로 argument (이름)은 @Bean의 메서드 이름을 문자로 바뀐 걸 사용한다.

//        test용
        Member member = new Member(1L, "memberA", Grade.VIP); 
//        id: 1L인 이유는 Longtype이어서. 그냥 1하면 에러난다.
//        단축키 : ctrl+alt+v : 자동 새로운 객체 생성. new Member()을 작성해놓고 이거 하면 Member member = 생성됨.

        memberService.join(member); // 회원가입
        Member findMember = memberService.findMember(1L); // id로 회원 정보 조회

//        'soutv' + enter하고 방향키로 변수 선택
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
