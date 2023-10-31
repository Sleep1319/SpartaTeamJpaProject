package jpaSparta.jpaProject.domain;

import jpaSparta.jpaProject.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "category_item")
@Getter
@Setter
public class CategoryItem {
    @Id @GeneratedValue
    @Column(name = "catecory_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
