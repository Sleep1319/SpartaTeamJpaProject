package jpaSparta.jpaProject.service;

import jpaSparta.jpaProject.domain.Category;
import jpaSparta.jpaProject.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public void saveCategory(Category category) {
        validateDuplicateCategory(category);
        categoryRepository.save(category);
    }

    @Transactional
    public void save(Category category) {
        categoryRepository.save(category);
    }

    private void validateDuplicateCategory(Category category) {
        List<Category> findCategory = categoryRepository.findByName(category.getName());
        if(!findCategory.isEmpty()) {
            throw new IllegalStateException("이미 등록된 카테고리");
        }
    }

//    public List<Category> findByName(String name) {
//        return categoryRepository.findByName(name);
//    }

    public Category findByOne(String name) {
        return categoryRepository.findByOne(name);
    }
}
