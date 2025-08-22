package com.leopoldo.ebook.ebook.mappers;
import java.util.List;

import org.mapstruct.Mapper;
import com.leopoldo.ebook.ebook.dtos.User.UserDetailsDto;
import com.leopoldo.ebook.ebook.dtos.User.UserSumaryDto;
import com.leopoldo.ebook.ebook.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDetailsDto userToUserDetailsDto(User user);
    UserSumaryDto userToUserSumaryDto(User user);
    List<UserSumaryDto> userToUserSumaryDto(List<User> users);
}
