package jpaSparta.jpaProject.service;

import jpaSparta.jpaProject.domain.CategoryItem;
import jpaSparta.jpaProject.repository.CategoryItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryItemService {
    private final CategoryItemRepository categoryItemRepository;
    @Transactional
    public void saveCateItem(CategoryItem categoryItem) {
        categoryItemRepository.save(categoryItem);
    }
}
