package me.saurav.springfusion.controller;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.saurav.springfusion.dto.UserLoginDto;
import me.saurav.springfusion.dto.UserLoginResponseDto;
import me.saurav.springfusion.dto.UserProfileDto;
import me.saurav.springfusion.dto.UserRegisterDto;
import me.saurav.springfusion.jwt.JwtUtils;
import me.saurav.springfusion.service.UserService;
import me.saurav.springfusion.service.impl.UserPrincipalImpl;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final JwtUtils jwtUtils;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRegisterDto rto) {
        UserProfileDto res = userService.save(rto);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserLoginDto loginRequest) {
        Authentication authentication;

        authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

        UserPrincipalImpl up = (UserPrincipalImpl) userDetails;

        UserLoginResponseDto response = new UserLoginResponseDto(jwtToken, up.getName(), up.getUsername(),
                up.createdAt(), up.updatedAt());

        return ResponseEntity.ok(response);
    }
}
