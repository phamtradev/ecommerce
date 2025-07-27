package org.phamtra.ecommercebackend.dto.response.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResUserRegisterDTO {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;


}
