package jpaSparta.jpaProject.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RegisterForm {
    @NotBlank
    private String user_id;
    @NotBlank
    private String pw;
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
    @NotNull
    private String addr;
    @NotNull
    private String detail_addr;
    @NotNull
    private String zipcode;
}
