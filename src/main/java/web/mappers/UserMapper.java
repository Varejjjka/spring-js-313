package web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import web.dto.UserDTO;
import web.model.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);
}