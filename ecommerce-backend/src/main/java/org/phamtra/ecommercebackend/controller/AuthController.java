package org.phamtra.ecommercebackend.controller;

import org.phamtra.ecommercebackend.dto.response.user.ResUserRegisterDTO;
import org.phamtra.ecommercebackend.model.User;
import org.phamtra.ecommercebackend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void createNewUser(@RequestBody ResUserRegisterDTO resUserRegisterDTO) {

        User user = new User();
        user.setUsername(resUserRegisterDTO.getUsername());
        user.setPassword(resUserRegisterDTO.getPassword());
        user.setEmail(resUserRegisterDTO.getEmail());
        user.setFirstName(resUserRegisterDTO.getFirstName());
        user.setLastName(resUserRegisterDTO.getLastName());

        this.userService.handleSaveUser(user);
    }
}
