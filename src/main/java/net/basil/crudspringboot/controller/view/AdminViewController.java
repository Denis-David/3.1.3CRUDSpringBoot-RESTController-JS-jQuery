package net.basil.crudspringboot.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/**")
public class AdminViewController {

    @GetMapping("usertable")
    public ModelAndView viewAdminCP () {
        return new ModelAndView("admin/usertable");
    }

}
