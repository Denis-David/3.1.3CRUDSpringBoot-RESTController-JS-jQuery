package net.basil.crudspringboot.util;

import net.basil.crudspringboot.dto.DTOUser;
import net.basil.crudspringboot.model.Role;
import net.basil.crudspringboot.model.User;

import java.util.List;
import java.util.Set;

public interface DTOConverter {

    DTOUser userConvertToDTOUser(User user);

    DTOUser getAuthUserInfo(User user);

    User dtoUserConvertToUser(DTOUser dtoUser);

    List<DTOUser> userListConvertToDTO(List<User> users);

}
