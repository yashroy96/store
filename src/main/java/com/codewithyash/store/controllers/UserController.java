package com.codewithyash.store.controllers;

import com.codewithyash.store.repositories.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

import com.codewithyash.store.dtos.UserDto;
import com.codewithyash.store.mappers.UserMapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.control.MappingControl.Use;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAllUsers(
            @RequestParam(required=false, defaultValue = "") String sort
        ) {
            if(!Set.of("name", "id").contains(sort)){
                sort= "name"; // Default sort by name if invalid sort parameter is provided 
            }

        // Using MapStruct to convert User entities to UserDto
        // This approach leverages the UserMapper to convert each User entity to UserDto
        var users = userRepository
                        .findAll(Sort.by(sort))
                        .stream().map(user -> userMapper.toDto(user))
                        .toList();
        return users;

        // Using Java Streams to convert User entities to UserDto
        // var users = userRepository.findAll().stream().map(user -> new UserDto(
        // user.getId(),
        // user.getName(),
        // user.getEmail())).toList();
        // return users;

        // Alternatively, you can use a for loop to achieve the same result
        // Uncomment the following code if you prefer the for loop approach
        // var users= userRepository.findAll();
        // List<UserDto> userDtos = new ArrayList<>();
        // for (var user : users) {
        // UserDto userDto= new UserDto(user.getId(),user.getName(),user.getEmail());
        // userDtos.add(userDto);
        // }
        // return userDtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        var optionaluser = userRepository.findById(id);
        var user = optionaluser.orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        // Using MapStruct to convert User entity to UserDto
        // This approach leverages the UserMapper to convert the User entity to UserDto
        return ResponseEntity.ok(userMapper.toDto(user));

        // Using MapStruct to convert User entity to UserDto
        // Alternatively, you can use Java Streams to convert User entity to UserDto
        // UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
        // return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto data) {
        // This method is a placeholder for creating a new user
        // You can implement the logic to save the user to the database here
        return data; // Placeholder return statement
    }
}
