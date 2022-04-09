package hello.core.member;

public interface MemberService {
    //    1. 회원 가입
    void join(Member member);

//    2. 회원 조회 기능
    Member findMember(Long memberId);
}
