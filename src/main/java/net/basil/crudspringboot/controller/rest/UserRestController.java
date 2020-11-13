package net.basil.crudspringboot.controller.rest;

import net.basil.crudspringboot.dto.DTOUser;
import net.basil.crudspringboot.model.User;
import net.basil.crudspringboot.service.RoleService;
import net.basil.crudspringboot.service.UserService;
import net.basil.crudspringboot.util.DTOConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/**")
public class UserRestController {

    private UserService userService;
    private DTOConverter dtoConverter;

    public UserRestController(UserService userService, DTOConverter dtoConverter) {
        this.userService = userService;
        this.dtoConverter = dtoConverter;
    }

    @GetMapping("authUser")
    public ResponseEntity<DTOUser> getAuthUser() {
        DTOUser dtoUser = dtoConverter.getAuthUserInfo(userService.getAuthUser());
        return dtoUser != null
                ? new ResponseEntity<>(dtoUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
