package jpaSparta.jpaProject.controller;

import jpaSparta.jpaProject.domain.Member;
import jpaSparta.jpaProject.domain.Order;
import jpaSparta.jpaProject.domain.OrderSearch;
import jpaSparta.jpaProject.domain.item.Food;
import jpaSparta.jpaProject.domain.item.Item;
import jpaSparta.jpaProject.service.ItemService;
import jpaSparta.jpaProject.service.MemberService;
import jpaSparta.jpaProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    // GetMapping
    /**
     * 사이트 이동 맵핑 전용
     * 추후 상세 맵핑 이름 기능 수정 필요
     */

    @GetMapping("adminindex")
    public String adminindex() {
        return "admin/adminindex";
    }


    //게시판 관리 html
    @GetMapping("boardManagement")
    public String boardManagement() {
        return "admin/boardManagement";
    }


    //공지사항 html
    @GetMapping("dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }


    //회원 관리 html
    @GetMapping("memberManagement")
    public String memberManagement(Model model) {
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        return "admin/memberManagement";
    }



    //주문 관리 html
    @GetMapping("orderManagement")
    public String orderManagement(@ModelAttribute("orderSearch") OrderSearch orderSearch,
                                  Model model) {
        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);
        return "admin/orderManagement";
    }
    @PostMapping(value = "/orderManagement/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }


    //상품 관리 html
    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new FoodForm());
        return "admin/productCreate";
    }
    @PostMapping("/items/new")
    public String create(FoodForm form) {
        Food food = new Food();
        food.setName(form.getName());
        food.setPrice(form.getPrice());
        food.setStockQuantity(form.getStockQuantity());
        food.setInfo(form.getInfo());
        food.setAge(form.getAge());

        itemService.saveItem(food);

        return "admin/adminindex";
    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "admin/productManagement";
    }

    @GetMapping("items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        Food item = (Food) itemService.findOne(itemId);

        FoodForm form = new FoodForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setInfo(form.getInfo());
        form.setAge(form.getAge());

        model.addAttribute("form", form);
        return "admin/productUpdate";
    }
    @PostMapping("items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") FoodForm form) {
        itemService.updateItem(itemId, form.getPrice(), form.getName(), form.getStockQuantity());

        return "redirect:/items";
    }
}
