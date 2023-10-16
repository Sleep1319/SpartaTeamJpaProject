package jpaSparta.jpaProject.domain.item;

import jpaSparta.jpaProject.domain.Category;
import jpaSparta.jpaProject.domain.OrderItem;
//import jpaSparta.jpaProject.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Column(name = "item_info")
    private String info;

    //타입 추가 필요?

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();


}
