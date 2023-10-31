package jpaSparta.jpaProject.dto;

import jpaSparta.jpaProject.domain.Address;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MemberDTO {
    private Long id;//자동 생성 키이기 떄문에 @NotBlank 제외 시켜둠
    private String user_id;
    private String pw;
    private String name;
    private String phone;
    private String addr;
    private String detail_addr;
    private String zipcode;

}
