package com.example.user.controller;
import com.example.user.dto.UserDto;
import com.example.user.model.User;
import com.example.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/v1/user")
@Slf4j
@Tag(name = "User API")
public class UserController {


    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public UserDto get(@PathVariable Long id){
        UserDto dto = userService.getUser(id);
        return dto;
    }

    @GetMapping()
    public List<User> getAll(){
        return userService.getAllUsers();
    }


    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> add(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
    log.info("deleting user {}",id);
        try {
            userService.delete(id);
        }
        catch( EmptyResultDataAccessException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
