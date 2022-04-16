package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    OrderService과 관련한 정보만을 선택해야 하는데, DiscountPolicy까지 선택하는 건 역할을 넘는 것이다.

    //    interface에만 의존하도록
    private final DiscountPolicy discountPolicy;
//    이렇게만 하면, null 뜬다.
//    누군가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해줘야 한다.

    @Override
//    implements 하는 OrderService에 Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
//        설계가 잘 된 이유 : 이 파일은 클라이언트에게 보여지는 파일
//        discountPolicy가 알아서 처리하고,  이 파일(OrderServiceImpl)에서는 결과만 받는다.
//        따라서 할인 정책이 바뀌더라도 클라이언트에게 가는 이 파일은 수정할 필요 없다.
//        SRP(Single Responsibility Principle) 잘 지켰다.

//        argument로 member.getGrade()로 등급만 넘겨도 되는데, 미래의 확장성을 위해 member을 통으로 넘겼다.

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
