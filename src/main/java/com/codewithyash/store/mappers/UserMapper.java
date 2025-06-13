package com.codewithyash.store.mappers;

import org.mapstruct.Mapper;

import com.codewithyash.store.dtos.UserDto;
import com.codewithyash.store.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
