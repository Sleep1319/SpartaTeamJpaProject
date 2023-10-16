package jpaSparta.jpaProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    //GetMapping

    /**
     *
     */

    @GetMapping("findId")
    public String findId() {
        return "member/findId";
    }

    @GetMapping("findPwd")
    public String findPwd() {
        return "member/findPwd";
    }

    @GetMapping("login")
    public String login() {
        return "member/login";
    }

    @GetMapping("myPage")
    public String myPage() {
        return "member/myPage";
    }

    @GetMapping("signup")
    public String signup() {
        return "member/signup";
    }

    //PostMapping
    /**
     *
     */
}
