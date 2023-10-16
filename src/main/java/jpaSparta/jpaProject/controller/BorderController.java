package jpaSparta.jpaProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BorderController {

    //GetMapping
    /**
     *
     */

    @GetMapping("boardList")
    public String boardList() {
        return "boarder/boardList";
    }

    @GetMapping("boardModify")
    public String boardModify() {
        return "boarder/boardModify";
    }

    @GetMapping("boardWrite")
    public String boardWrite() {
        return "boarder/boardWrite";
    }

    @GetMapping("customerSupport")
    public String customerSupport() {
        return "boarder/customerSupport";
    }

    //PostMapping
    /**
     *
     */

}
