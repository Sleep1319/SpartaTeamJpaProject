package jpaSparta.jpaProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class AdminController {
    // GetMapping
    /**
     * 사이트 이동 맵핑 전용
     * 추후 상세 맵핑 이름 기능 수정 필요
     */

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
    public String memberManagement() {
        return "admin/memberManagement";
    }

    //주문 관리 html
    @GetMapping("orderManagement")
    public String orderManagement() {
        return "admin/orderManagement";
    }

    //상품 관리 html
    @GetMapping("productManagement")
    public String productManagement() {
        return "admin/productManagement";
    }


    // PostMapping
    /**
     * 기능 처리를 위한 맵핑 전용
     */
}
