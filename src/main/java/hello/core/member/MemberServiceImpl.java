package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    MemberService의 구현체가 MemberServieImpl이고,
//    이 때 대상이 되는 게 MemoryMemberRepository로 찍어낸 객체가 있어야 돌아간다.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
//        MemoryMemberRepository의 save함수 MemberRepository에 Override 되어 쓸 수 있다.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
//        MemoryMemberRepository의 findMember함수 MemberRepository에 Override 되어 쓸 수 있다.
    }
//    구현체가 하나만 있을 때 주로 이름 마지막에 Impl(ements)을 많이 쓴다.
}
