package jpaSparta.jpaProject.api;

import jpaSparta.jpaProject.domain.Address;
import jpaSparta.jpaProject.domain.Member;
import jpaSparta.jpaProject.dto.MemberDTO;
import jpaSparta.jpaProject.form.MemberUpdateForm;
import jpaSparta.jpaProject.form.RegisterForm;
import jpaSparta.jpaProject.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody @Valid RegisterForm form, BindingResult result) {
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            response.put("message", "비어 있거나 공백이 있는 내용이 있습니다");
            response.put("status", 400);
            return ResponseEntity.ok(response);
        }

        Address address = new Address(form.getAddr(), form.getDetail_addr(), form.getZipcode());

        Member member = new Member();
        member.setUser_id(form.getUser_id());
        member.setPw(form.getPw());
        member.setName(form.getName());
        member.setPhone(form.getPhone());
        member.setAddress(address);

//        if (member.getUser_id() == null) {
//
//            response.put("message", "값이 null로 넘어옴 실패");
//            response.put("status", 400);
//            return ResponseEntity.ok(response);
//        }
        try {
            memberService.join(member);
            response.put("message", "회원가입 성공");
            response.put("status", 200);
            return ResponseEntity.ok(response);
        } catch (IllegalAccessError e) {
            response.put("message", "회원가입 실패");
            response.put("status", 400);
            return ResponseEntity.ok(response);
        }
    }

    //마이페이지//


    //수정
        @PutMapping  ("/myPage/api")
        public ResponseEntity<Map<String, Object>> UpdateMemberInfo(@RequestBody @Valid MemberUpdateForm form, BindingResult result, HttpSession session) {
            Map<String, Object> response = new HashMap<>();

            if(result.hasErrors()){
                response.put("message", "비어 있거나 공백이 있는 내용이 있습니다");
                response.put("status", 400);
                return ResponseEntity.ok(response);
            }

            Long member_id = 0L;
            //세션 아이디 Long형인지 체크
            Object id = session.getAttribute("member_id");
            if (id instanceof Long) {
                member_id = (Long) id;
            } else {
                response.put("message", "수정 실패");
                response.put("status", 400);
                return ResponseEntity.ok(response);
            }
            
            Address address = new Address(form.getAddr(), form.getDetail_addr(), form.getZipcode());

            Member member = new Member();
            member.setId(member_id);
            member.setPhone(form.getPhone());
            member.setAddress(address);
            try {
                memberService.updateUserInfo(member);
                response.put("message", "수정 성공");
                response.put("status", 200);
                return ResponseEntity.ok(response);

            } catch (IllegalAccessError e) {
                response.put("message", "디비 에러");
                response.put("status", 400);
                return ResponseEntity.ok(response);
            }
        }

    @Data
    static class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

//    @Data
//    static class MemberRequest {
////        private String member_id;
//        private String user_id;
//        private String pw;
//        private String name;
//        private String phone;
//        private String addr;
//        private String detail_addr;
//        private String zipcode;
//    }
//
//    @Data
//    static class CreateMemberRequestLogin {
//        private String user_id;
//        private String pw;
//    }

//    @Data
//    static class UpdateMemberRequest {
//        private String user_id;
//        private String pw;
//        private String name;
//        private String  phone;
//        private String addr;
//        private String detail_addr;
//        private String zipcode;
//    }
}
