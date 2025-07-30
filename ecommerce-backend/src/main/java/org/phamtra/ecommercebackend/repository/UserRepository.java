package org.phamtra.ecommercebackend.repository;

import org.phamtra.ecommercebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
