package com.example.igadvocacia.web.dtos.mapper;

import com.example.igadvocacia.entities.User;
import com.example.igadvocacia.web.dtos.UserCreateDTO;
import com.example.igadvocacia.web.dtos.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User toUser(UserCreateDTO userCreateDTO){
        return new ModelMapper().map(userCreateDTO, User.class);
    }

    public static UserResponseDTO toDTO(User user){
        String role = user.getRole().name().substring("ROLE_".length());
        PropertyMap<User, UserResponseDTO> props = new PropertyMap<User, UserResponseDTO>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);

        return mapper.map(user, UserResponseDTO.class);
    }

    public static List<UserResponseDTO> toList(List<User> users){
        return users.stream().map(user -> toDTO(user)).collect(Collectors.toList());
    }

}
