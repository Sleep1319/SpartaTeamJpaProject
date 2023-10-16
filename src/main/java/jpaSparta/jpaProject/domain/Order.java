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
    private LocalDateTime localDateTime;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    //---------------------------
    public void setMember(Member member){
        this.member = member;
    }
}
