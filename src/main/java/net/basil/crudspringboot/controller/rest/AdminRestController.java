package net.basil.crudspringboot.controller.rest;

import net.basil.crudspringboot.dto.DTOUser;
import net.basil.crudspringboot.service.RoleService;
import net.basil.crudspringboot.service.UserService;
import net.basil.crudspringboot.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/**")
public class AdminRestController {

    private UserService userService;
    private RoleService roleService;
    private DTOConverter dtoConverter;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService, DTOConverter dtoConverter) {
        this.userService = userService;
        this.roleService = roleService;
        this.dtoConverter = dtoConverter;
    }

    @GetMapping("userList")
    public ResponseEntity<List<DTOUser>> listOfUsers() {
        List<DTOUser> dtoUsers = dtoConverter.userListConvertToDTO(userService.getAllUsers());
        return dtoUsers != null && !dtoUsers.isEmpty()
                ? new ResponseEntity<>(dtoUsers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<DTOUser> getUserById(@PathVariable(name = "id") Long id) {
        DTOUser dtoUser = dtoConverter.userConvertToDTOUser(userService.getUserById(id));
        return dtoUser != null
                ? new ResponseEntity<>(dtoUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("newUser")
    public ResponseEntity<DTOUser> newUser(@RequestBody DTOUser dtoUser) {
        try {
            userService.addUser(dtoConverter.dtoUserConvertToUser(dtoUser));
            return new ResponseEntity<>(dtoUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateUser")
    public ResponseEntity<DTOUser> updateUser(@RequestBody DTOUser dtoUser) {
        try {
            userService.updateUser(dtoConverter.dtoUserConvertToUser(dtoUser));
            return new ResponseEntity<>(dtoUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
