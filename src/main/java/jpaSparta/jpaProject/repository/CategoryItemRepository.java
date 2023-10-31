package jpaSparta.jpaProject.repository;

import jpaSparta.jpaProject.domain.CategoryItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class CategoryItemRepository {
    @PersistenceContext
    EntityManager em;

    public void save(CategoryItem categoryItem) {
        em.persist(categoryItem);
    }
}
