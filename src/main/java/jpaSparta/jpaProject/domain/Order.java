package jpaSparta.jpaProject.domain;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)//
    @JoinColumn(name = "delivery_id")//원투원이여도 외래키 참조는 오더 하나이기에 오더에만 조인컬럼?(멤버는 1대다라서 그렇다 쳐도)
    private Delivery delivery;

    @Column(name = "order_date")
    private LocalDateTime order_date;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    //---------------------------
    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) { // ... = 가변인자 오더아이템들의 들어온 정보수만큼 증가 되게 하기 위합
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);

        for( OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }

        order.setStatus(OrderStatus.ORDER);
        order.setOrder_date(LocalDateTime.now());

        return order;//오더 정보를 리턴
    }

    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송 완료된 상품은 취소가 불가함");
        }

        this.setStatus(OrderStatus.CANCLE);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

        public int getTotalPrice() {
            int totalPrice = 0;
            for( OrderItem orderItem : orderItems ) {
                totalPrice += orderItem.getTotalPrice();
            }
            return totalPrice;
        }
}
