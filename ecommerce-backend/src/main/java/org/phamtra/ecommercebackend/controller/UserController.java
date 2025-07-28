package org.phamtra.ecommercebackend.controller;

import org.phamtra.ecommercebackend.model.User;
import org.phamtra.ecommercebackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        User newUser = this.userService.handleCreateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id) {
        return this.userService.fetchUserById(id);
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return this.userService.fetchAllUser();
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable long id) {
        this.userService.handleDeleteUser(id);
        return "succesfully";
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        User newUser = this.userService.handleUpdateUser(user);
        return newUser;
    }
}
