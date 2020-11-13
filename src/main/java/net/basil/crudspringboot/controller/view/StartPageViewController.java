package net.basil.crudspringboot.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StartPageViewController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

}
