package net.basil.crudspringboot.util;

import net.basil.crudspringboot.dto.DTOUser;
import net.basil.crudspringboot.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DTOConverterImpl implements DTOConverter {

    @Override
    public DTOUser userConvertToDTOUser(User user) {
        DTOUser dtoUser = new DTOUser();

        dtoUser.setUserID(user.getId());
        dtoUser.setUserName(user.getName());
        dtoUser.setUserPassword(user.getPassword());
        dtoUser.setUserEmail(user.getEmail());
        dtoUser.setRoleSet(user.getRoleSet());

        return dtoUser;
    }

    @Override
    public DTOUser getAuthUserInfo(User user) {
        DTOUser dtoUser = new DTOUser();

        dtoUser.setUserName(user.getName());
        dtoUser.setUserEmail(user.getEmail());
        dtoUser.setRoleSet(user.getRoleSet());
        dtoUser.setUserPassword(user.getPassword());
        dtoUser.setUserID(user.getId());

        return dtoUser;
    }

    @Override
    public User dtoUserConvertToUser(DTOUser dtoUser) {
        User user = new User();

        user.setId(dtoUser.getUserID());
        user.setName(dtoUser.getUserName());
        user.setPassword(dtoUser.getUserPassword());
        user.setEmail(dtoUser.getUserEmail());
        user.setRoleSet(dtoUser.getRoleSet());

        return user;
    }

    @Override
    public List<DTOUser> userListConvertToDTO(List<User> users) {
        List<DTOUser> dtoUsers = new ArrayList<>();
        users.forEach(user -> dtoUsers.add(userConvertToDTOUser(user)));
        return dtoUsers;
    }

}
