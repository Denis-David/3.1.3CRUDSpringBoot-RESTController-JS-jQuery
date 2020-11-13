package net.basil.crudspringboot.controller.view;

import net.basil.crudspringboot.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/user/**")
public class UserViewController {

    @GetMapping("userinfo")
    public String showUserForm(@AuthenticationPrincipal User user) {
        return "/user/userinfo";
    }

}
