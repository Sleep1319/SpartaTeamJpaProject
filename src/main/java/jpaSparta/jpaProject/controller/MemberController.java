package jpaSparta.jpaProject.controller;

import jpaSparta.jpaProject.domain.Member;
import jpaSparta.jpaProject.form.LoginForm;
import jpaSparta.jpaProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    //GetMapping

    /**
     *
     */

    //회원가입 html
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("memberForm", new LoginForm());
        return "member/signup";
    }

    //로그인 html
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    //로그아웃
    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.invalidate();
        return "home/index";
    }

    //아이디 찾기 html
    @GetMapping("/findId")
    public String findId() {
        return "member/findId";
    }

    //비밀번호 찾시 html
    @GetMapping("/findPwd")
    public String findPwd() {
        return "member/findPwd";
    }

    //유저정보 html
    @GetMapping("/myPage")
    public String myPage(Model model, HttpSession session) {
        Object id = session.getAttribute("member_id");
        if (id instanceof Long) {
            Long member_id = (Long) id;
            Member member = memberService.findOne(member_id);
            model.addAttribute("phone", member.getPhone());
            model.addAttribute("address", member.getAddress());
            return "member/myPage";
        } else {
            model.addAttribute("message", "고유 아이디 확인 실패");
            return "home/index";
        }
    }

    //PostMaping


    //로그인 요청
    @PostMapping("/login")
    public String login(@ModelAttribute @Valid LoginForm form, BindingResult result,
                        Model model, HttpSession session) {
        if(result.hasErrors()){
            model.addAttribute("message", "아이디 또는 비밀번호를 입력해 주십시오.");
            return "member/login";
        }
        Member member = memberService.tryLogin(form.getUser_id(), form.getPw());
        if (member.getUser_id() != null){
            session.setAttribute("member_id", member.getId());//첫 멤버변수값
            session.setAttribute("user_id", member.getUser_id());
            session.setAttribute("name", member.getName());//4번째 값 name
            model.addAttribute("message", "로그인 성공");
            return "home/index";
        } else {
            model.addAttribute("message", "아이디 또는 비밀 번호가 다릅니다!");
            return "member/login";
        }
    }

    //해당 유저정보 요청
//    @PostMapping("/userInfo")
//    public String userInfo(Model model, HttpSession session) {
//        Long member_id = Long.parseLong((String) session.getAttribute("member_id"));
//        Member member = memberService.findOnd(member_id);
//        model.addAttribute("phone", member.getPhone());
//        model.addAttribute("address", member.getAddress());
//        return "member/myPage";
//    }

    //유저 정보 수정
//    @PostMapping("/updateUserInfo")
//    public String updateUserInfo(@RequestParam("phone") String phone,
//                                 @RequestParam("addr") String addr,
//                                 @RequestParam("detail_addr") String detail_addr,
//                                 @RequestParam("zipcode") String zipcode,
//                                 Model model, HttpSession session){
//        Long member_id = Long.parseLong((String) session.getAttribute("member_id"));
//        Address address = new Address(addr, detail_addr, zipcode);
//        int checkUpdate = memberService.updateUserInfo(member_id, phone, address);
//        Member member = memberService.findOne(member_id);
//        if(checkUpdate > 0) {
//            model.addAttribute("message", "정부 수정 완료");
//            model.addAttribute("phone", member.getPhone());
//            model.addAttribute("address", member.getAddress());
//        } else {
//            model.addAttribute("message", "정보 수정 실패");
//        }
//        return "member/myPage";
//    }


}
