package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

//    저장소 생성
    private static Map<Long, Member> store = new HashMap<>();
//    me) 바로바로 꺼내 쓰려고 static?
//    HashMap은 key, value로 이루어진 Dictionary와 비슷한 구조
//    실무에서는 동시성 이슈로 HashMap 대신 ConcurrentHashMap 쓴다.

//    1. 회원 가입 기능
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
//    put(K key, V value) 으로 저장
    }

//    2. 회원 조회 기능
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
//    get(Object key) : 인자로 전달된 key에 해당하는 value값 전달해준다.
    }
}
