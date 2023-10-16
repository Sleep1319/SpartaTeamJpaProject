package jpaSparta.jpaProject.domain;

import jpaSparta.jpaProject.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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
    //뇌절 나도 씹테고리 이거 찬햄꺼는 아주 복잡한게 아름답네요
    //엔티티에서 보는거로 하면 category category_item 을 만들어야 할거 같은데 
    //여기서 다끝내버리시네 이걸로 해도 되나.. 부모 자식새끼...
    //ㅋㅋㅋㅋ  //이렇게 끝내 버리시던데..
    // ------ 여기 아래부터 정리 다시해야함 item

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;
    //우리가 가져온 놈의 값을 저장이니깐 카테고리아이디 일꺼야
    @OneToMany(mappedBy = "parent")// 얘가 부모인데 지가 지껄 가져오네
    private List<Category> child = new ArrayList<>();

    //연관관계 메서드
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
