package jpaSparta.jpaProject.repository;

import jpaSparta.jpaProject.domain.item.Item;

import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //저장소 선언
@RequiredArgsConstructor //생성자 주입 파이널!!!!!!
public class ItemRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Item item) {
        if(item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    public Item findOnd(Long id) { return em.find(Item.class, id); }

    public List<Item> findAll() {
        return em.createQuery("SELECT i FROM Item i", Item.class)
                .getResultList();
    }

    public int UpdateItem (Item item) {
        return em.createQuery("UPDATE Item i SET i.name = :name, i.price = :price, i.stockQuantity = :quantity, i.info = :info WHERE i.id =: id")
                .setParameter("name", item.getName()).setParameter("price", item.getPrice()).setParameter("quantity", item.getStockQuantity())
                .setParameter("info", item.getInfo()).setParameter("id",item.getId())
                .executeUpdate();
    }

    public int DeleteItem (Long id) {
        return em.createQuery("DELETE Item i WHERE i.id = :id")
                .setParameter("id", id).executeUpdate();
    }

}
