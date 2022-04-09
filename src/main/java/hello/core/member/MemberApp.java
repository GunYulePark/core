package hello.core.member;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
//        test용
        Member member = new Member(1L, "memberA", Grade.VIP); 
//        id: 1L인 이유는 Longtype이어서. 그냥 1하면 에러난다.
        memberService.join(member); // 회원가입
        Member findMember = memberService.findMember(1L); // id로 회원 정보 조회
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
