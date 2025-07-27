package org.phamtra.ecommercebackend.service;

import org.phamtra.ecommercebackend.model.User;
import org.phamtra.ecommercebackend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleSaveUser(User user) {

        return this.userRepository.save(user);
    }
}
