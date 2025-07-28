package org.phamtra.ecommercebackend.controller;

import org.phamtra.ecommercebackend.model.User;
import org.phamtra.ecommercebackend.service.UserService;
import org.phamtra.ecommercebackend.service.error.IdInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        User newUser = this.userService.handleCreateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = this.userService.fetchUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok().body(this.userService.fetchAllUser());
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) throws IdInvalidException {
        if (id >= 1500) {
            throw new IdInvalidException("Id khong lon hon 1500");
        }
        this.userService.handleDeleteUser(id);
        return "succesfully";
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User newUser = this.userService.handleUpdateUser(user);
        return ResponseEntity.ok(newUser);
    }
}
