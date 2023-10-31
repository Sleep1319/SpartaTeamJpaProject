package jpaSparta.jpaProject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;


    @OneToMany(mappedBy = "category")
    private List<CategoryItem> categoryItem;

//    @ManyToMany
//    @JoinTable(name = "category_item",
//            joinColumns = @JoinColumn(name = "category_id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id"))
//    private List<Item> items = new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parent_id")
//    private Category parent;
//    //우리가 가져온 놈의 값을 저장이니깐 카테고리아이디 일꺼야
//    @OneToMany(mappedBy = "parent")// 얘가 부모인데 지가 지껄 가져오네
//    private List<Category> child = new ArrayList<>();
//
//    //연관관계 메서드
//    public void addChildCategory(Category child) {
//        this.child.add(child);
//        child.setParent(this);
//    }
}
