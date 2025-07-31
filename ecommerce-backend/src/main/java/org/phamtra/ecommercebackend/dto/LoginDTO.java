package org.phamtra.ecommercebackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

    @NotBlank(message = "username must not be empty !")
    private String username;

    @NotBlank(message = "password must not be empty !")
    private String password;

}
