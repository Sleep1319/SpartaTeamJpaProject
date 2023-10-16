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
    @GetMapping("boardManagement")
    public String boardManagement() {
        return "admin/boardManagement";
    }

    @GetMapping("dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("memberManagement")
    public String memberManagement() {
        return "admin/memberManagement";
    }

    @GetMapping("oderManagement")
    public String oderManagement() {
        return "admin/oderManagement";
    }

    @GetMapping("productManagement")
    public String productManagement() {
        return "admin/productManagement";
    }


    // PostMapping
    /**
     * 기능 처리를 위한 맵핑 전용
     */
}
