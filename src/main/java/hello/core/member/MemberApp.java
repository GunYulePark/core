package hello.core.member;

public class MemberApp {
    public static void main(String[] args) { // 단축키 'psvm' + enter

        MemberService memberService = new MemberServiceImpl();
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
