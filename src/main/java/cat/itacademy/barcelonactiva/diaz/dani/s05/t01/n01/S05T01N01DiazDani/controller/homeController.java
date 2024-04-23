package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "home";
    }
}
