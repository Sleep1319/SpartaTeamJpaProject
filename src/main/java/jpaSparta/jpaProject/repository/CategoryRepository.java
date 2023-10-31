package jpaSparta.jpaProject.repository;

import jpaSparta.jpaProject.domain.Category;
import jpaSparta.jpaProject.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //저장소 선언
@RequiredArgsConstructor
public class CategoryRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Category category){
        if(category.getName() == null) {
            em.persist(category);
        } else {
            em.merge(category);
        }
    }

    public List<Category> findByName(String name) {
        return em.createQuery("SELECT c FROM Category c WHERE c.name = :name", Category.class)
                .setParameter("name", name)
                .getResultList();
    }

    public Category findByOne(String name) {
        return em.createQuery("SELECT c FROM Category c WHERE c.name = :name", Category.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
