package jpaSparta.jpaProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    //GetMapping

    /**
     *
     */

    @GetMapping("cart")
    public String cart() {
        return "order/cart";
    }

    @GetMapping("orderDelivery")
    public String orderDelivery() {
        return "order/orderDelivery";
    }

    @GetMapping("orderHistory")
    public String orderHistory() {
        return "order/orderHistory";
    }

    @GetMapping("payment")
    public String payment() {
        return "order/payment";
    }

    @GetMapping("refund")
    public String refund() {
        return "order/refund";
    }

    //PostMapping

    /**
     *
     */
}
