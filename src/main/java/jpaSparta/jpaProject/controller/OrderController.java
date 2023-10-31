package jpaSparta.jpaProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    //GetMapping

    /**
     *
     */

    //주문 정보 html
    @GetMapping("/orderHistory")
    public String orderHistory() {
        return "order/orderHistory";
    }

    //장바구니 html
    @GetMapping("/cart")
    public String cart() {
        return "order/cart";
    }

    //주문 배송 html
    @GetMapping("/orderDelivery")
    public String orderDelivery() {
        return "order/orderDelivery";
    }

    //결제 정보 html
    @GetMapping("/payment")
    public String payment() {
        return "order/payment";
    }

    //환불 html
    @GetMapping("/refund")
    public String refund() {
        return "order/refund";
    }

    //PostMapping

    /**
     *
     */
}
