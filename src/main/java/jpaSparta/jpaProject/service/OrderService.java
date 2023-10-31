package jpaSparta.jpaProject.service;

import jpaSparta.jpaProject.domain.*;
import jpaSparta.jpaProject.domain.item.Item;
import jpaSparta.jpaProject.repository.ItemRepository;
import jpaSparta.jpaProject.repository.MemberRepository;
import jpaSparta.jpaProject.repository.OrderRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOnd(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());//킵

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);

        return order.getId();
    }

    /**
     * 주문 최소
     * */

    @Transactional
    public void cancelOrder(Long orderId) {
        //주문 엔티티 취소
        Order order = orderRepository.findOne(orderId);

        //주문 취소
        order.cancel();
        //JPa의 변경내역 감지에 의해서 Entity의 바뀐 필드값을 읽어 update query가 날라간다.
    }

    /**
     * 검색
     * */
    public List<Order> findOrders(OrderSearch orderSearch) { return orderRepository.findAllByString(orderSearch);}
}
