package jpaSparta.jpaProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    //GetMapping

    /**
     *
     */

    //회원가입 html
    @GetMapping("signup")
    public String signup() {
        return "member/signup";
    }

    //로그인 html
    @GetMapping("login")
    public String login() {
        return "member/login";
    }

    //아이디 찾기 html
    @GetMapping("findId")
    public String findId() {
        return "member/findId";
    }

    //비밀번호 찾시 html
    @GetMapping("findPwd")
    public String findPwd() {
        return "member/findPwd";
    }

    //유저정보 html
    @GetMapping("myPage")
    public String myPage() {
        return "member/myPage";
    }

    //PostMapping
    /**
     *
     */
}
