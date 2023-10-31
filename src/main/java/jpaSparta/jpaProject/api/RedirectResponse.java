package jpaSparta.jpaProject.api;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RedirectResponse {
    private int status;
    private String message;


    public RedirectResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
