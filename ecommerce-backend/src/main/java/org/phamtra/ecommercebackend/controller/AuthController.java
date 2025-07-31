package org.phamtra.ecommercebackend.controller;

import jakarta.validation.Valid;
import org.phamtra.ecommercebackend.dto.LoginDTO;
import org.phamtra.ecommercebackend.dto.ResLoginDTO;
import org.phamtra.ecommercebackend.util.SecurityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final SecurityUtil securityUtil;

    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, SecurityUtil securityUtil) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.securityUtil = securityUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<ResLoginDTO> login(@Valid @RequestBody LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        //create token
        String acces_token = this.securityUtil.createToken(authentication);
        ResLoginDTO res = new ResLoginDTO();
        res.setAccessToken(acces_token);
        return ResponseEntity.ok().body(res);
    }
}
