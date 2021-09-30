package web.dto;

import lombok.Data;
import web.model.Role;

import java.util.Set;

@Data
public class UserDTO {
    private long id;
    private String name;
    private String job;
    private int age;

    private Set<RoleDTO> role;
}