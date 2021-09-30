package web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import web.dto.RoleDTO;
import web.model.Role;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO toDTO(Role role);
}

