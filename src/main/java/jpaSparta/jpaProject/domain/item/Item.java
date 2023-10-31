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
@Table(name = "item")
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

//    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
//    private List<CategoryItem> categoryItem;

//    @ManyToMany(mappedBy = "items")
//    private List<Category> categories = new ArrayList<Category>();

    //타입 추가 필요?

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;//지금 수량에서 빠질 수를 빼서 restStock에 저장
        if ( restStock < 0 ) {
            throw new NotEnoughStockException("재고 부족");
        }
        this.stockQuantity = restStock; //0개 미만이 아닐때 다시 재고에 저장
    }
}
