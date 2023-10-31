package jpaSparta.jpaProject.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginForm {
    @NotBlank
    private String user_id;
    @NotBlank
    private String pw;

}
