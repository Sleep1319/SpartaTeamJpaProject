package jpaSparta.jpaProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BorderController {

    //GetMapping
    /**
     *
     */

    //게시판(리뷰) 목록 html
    @GetMapping("/boardList")
    public String boardList() {
        return "boarder/boardList";
    }

    //보드 상세정보 html
    @GetMapping("/boardModify")
    public String boardModify() {
        return "boarder/boardModify";
    }

    //글쓰기 html
    @GetMapping("/boardWrite")
    public String boardWrite() {
        return "boarder/boardWrite";
    }

    //고객 지원 html
    @GetMapping("/customerSupport")
    public String customerSupport() {
        return "boarder/customerSupport";
    }

    @GetMapping("/testBoard")
    public String testBoatd() {return "boarder/noticeWrite";}
    //PostMapping
    /**
     *
     */

}
