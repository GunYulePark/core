package hello.core.member;

import hello.core.AppConfig;

public class MemberServiceImpl implements MemberService{
    //    구현체가 하나만 있을 때 주로 이름 마지막에 Impl(ements)을 많이 쓴다.
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    me) 이건 메모리 저장소로서 상수로 변하면 안된다. 그래서 final 써줘야 한다.
//    MemberService의 구현체가 MemberServieImpl이고,
//    이 때 대상이 되는 게 MemoryMemberRepository로 찍어낸 객체가 있어야 돌아간다.
//    MemberRepository는 interface 이지만, MemoryMemberRepository가 구현체이다.
//    구현체가 바뀔 때마다 해당 코드를 바꿔야 한다. 또한 구현체에 의존하고 있다.
//    따라서 MemberService는 OCP와 DIP원칙에 어긋난다.


    //    AppConfig 이후
    private final MemberRepository memberRepository;
//    MemberRepository interface만 사용. 구체화한 건 AppConfig에서 넣어줌

    //    AppConfig를 위해서 interface만 하려면 Constructor 써줘야 한다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
//        MemoryMemberRepository의 save함수 MemberRepository에 Override 되어 쓸 수 있다.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
//        findById(): Id를 통해 entitiy의 모든 정보 가져다 준다.
//        MemoryMemberRepository의 findMember함수 MemberRepository에 Override 되어 쓸 수 있다.
    }
}
