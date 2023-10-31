package jpaSparta.jpaProject.controller;

import jpaSparta.jpaProject.domain.Category;
import jpaSparta.jpaProject.domain.CategoryItem;
import jpaSparta.jpaProject.domain.item.Food;
import jpaSparta.jpaProject.domain.item.Item;
import jpaSparta.jpaProject.domain.item.Snack;
import jpaSparta.jpaProject.domain.item.Supplies;
import jpaSparta.jpaProject.dto.ItemDTO;
import jpaSparta.jpaProject.repository.CategoryItemRepository;
import jpaSparta.jpaProject.repository.CategoryRepository;
import jpaSparta.jpaProject.service.CategoryItemService;
import jpaSparta.jpaProject.service.CategoryService;
import jpaSparta.jpaProject.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final CategoryService categoryService;
    private final CategoryItemService categoryItemService;

    @GetMapping("/itemManagement")
    public String itemManagement(Model model) {
        List<Item> itemAllList = itemService.findItems();
        model.addAttribute("itemList", itemAllList);
        return "admin/itemManagement";
    }

    @GetMapping("/itemInsert")
    public String createForm(Model model) {
        model.addAttribute("form", new ItemDTO());
        return "admin/productCreate";
    }
    @PostMapping("/itemInsert")
    public String InsertItem(@ModelAttribute @Valid ItemDTO itemDTO,
                             Model model) {
        Category category = categoryService.findByOne(itemDTO.getCategory());
        if(category == null) {
            model.addAttribute("message", "카테고리 조회 에러");
            return "admin/itemManagement";
        }
        CategoryItem categoryItem = new CategoryItem();
        //카테고리를 읽어서 추가할수 있는 구문 개발 필요
        if (itemDTO.getCategory().equals("Food")) {
            Food foodItem = new Food();
            foodItem.setName(itemDTO.getName());
            foodItem.setPrice(itemDTO.getPrice());
            foodItem.setStockQuantity(itemDTO.getStockQuantity());
            foodItem.setInfo(itemDTO.getInfo());
            foodItem.setAge(itemDTO.getCateDetail());

            try {
                itemService.saveItem(foodItem);
                categoryItem.setCategory(category);
                categoryItem.setItem(foodItem);
                categoryItemService.saveCateItem(categoryItem);

                model.addAttribute("message", "푸드 아이템 등록 성공");
                return "admin/itemManagement";
            } catch (IllegalAccessError e) {
                model.addAttribute("message", "푸드 등록 에러");
                return "admin/itemManagement";
            }
        } else if (itemDTO.getCategory().equals("Snack")) {
            Snack snackItem = new Snack();
            snackItem.setName(itemDTO.getName());
            snackItem.setPrice(itemDTO.getPrice());
            snackItem.setStockQuantity(itemDTO.getStockQuantity());
            snackItem.setInfo(itemDTO.getInfo());
            snackItem.setMatalyer(itemDTO.getCateDetail());

            try {
                itemService.saveItem(snackItem);
                categoryItem.setCategory(category);
                categoryItem.setItem(snackItem);
                categoryItemService.saveCateItem(categoryItem);
                model.addAttribute("message", "간식 아이템 등록 성공");
                return "admin/itemManagement";
            } catch (IllegalAccessError e) {
                model.addAttribute("message", "간식 등록 에러");
                return "admin/itemManagement";
            }
        } else if (itemDTO.getCategory().equals("Supplies")) {
            Supplies suppliesItem = new Supplies();
            suppliesItem.setName(itemDTO.getName());
            suppliesItem.setPrice(itemDTO.getPrice());
            suppliesItem.setStockQuantity(itemDTO.getStockQuantity());
            suppliesItem.setInfo(itemDTO.getInfo());
            suppliesItem.setUsage(itemDTO.getCateDetail());

            try {
                itemService.saveItem(suppliesItem);
                categoryItem.setCategory(category);
                categoryItem.setItem(suppliesItem);
                categoryItemService.saveCateItem(categoryItem);
                model.addAttribute("message", "용품 아이템 등록 성공");
                return "admin/itemManagement";
            } catch (IllegalAccessError e) {
                model.addAttribute("message", "용품 등록 에러");
                return "admin/itemManagement";
            }
        } else {
            model.addAttribute("message", "카테고리가 없어!");
            return "admin/itemManagement";
        }


        //        Item item = new Item();
//        item.setId(itemDTO.getId());
//        item.setName(itemDTO.getName());
//        item.setPrice(itemDTO.getPrice());
//        item.setStockQuantity(itemDTO.getStockQuantity());
//        item.setInfo(itemDTO.getInfo());
//
//        Category category = categoryService.findByOne(itemDTO.getCateDetail());
//        if(category == null) {
//            model.addAttribute("message", "등록오류(카테고리 정보 가져오기 불가)");
//            return "admin/itemManagement";
//        }
//
//        category.getItems().add(item);
//
//        //서비스단 연결 수정 필요?
////        categoryRepository.save(category);
//
//        try {
//            itemService.saveItem(item);
//            model.addAttribute("message", "아이템 등록 성공");
//            return "redirect:/itemManagement";
//        } catch (IllegalAccessError e){
//            model.addAttribute("message", "아이템 등록 에러");
//            return "admin/itemManagement";
//        }
    }
}
