package jpaSparta.jpaProject.controller;

import jpaSparta.jpaProject.domain.Category;
import jpaSparta.jpaProject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/testCate")
    public String categoey() {
        return "admin/category";
    }

    //추후 신규 등록에서 처리말고 추가 등록 같은 기능 구분 필요
//    @PostMapping("/CategoryInsert")
//    public String InsertCategory (@RequestParam("categoryName") String category_name,
//                                  @RequestParam("detailInfo") String detailInfo,
//                                  Model model) {
//        Category category = new Category();
//        category.setName(category_name);
//        try {
//            categoryService.saveCategory(category);
//        } catch (IllegalAccessError e) {
//            model.addAttribute("message", "이미등록된거?");
//        } finally {
//            Category childCategory = new Category();
//            childCategory.setName(detailInfo);
//            childCategory.setParent(category);
//            try {
//                categoryService.saveCategory(childCategory);
//            } catch (IllegalAccessError e) {
//                model.addAttribute("message", "이미 등록된 자식 값?");
//            }
//        }
//        return "admin/category";
//    }

    @PostMapping("/CategoryInsert")
    public String InsertCategory (@RequestParam("categoryName") String category_name,
                                  Model model) {
        Category category = new Category();
        category.setName(category_name);
        try {
            categoryService.saveCategory(category);
            model.addAttribute("message", "카테고리 등록 성공");
        } catch (IllegalAccessError e) {
            model.addAttribute("message", "이미등록된거?");
        }
        return "admin/category";
    }
}
