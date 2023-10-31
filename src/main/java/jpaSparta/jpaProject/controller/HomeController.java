package jpaSparta.jpaProject.controller;

import jpaSparta.jpaProject.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class HomeController {


    @GetMapping("/")
    public String hello(Model model) {

        return "home/index";
    }

    @GetMapping(value = "productsDetail.html")
    public String productsDetail() {
        log.info("productsDetail controller");
        return "home/productsDetail";
    }


}
