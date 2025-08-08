package me.saurav.springfusion.service.impl;

import java.time.Instant;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.saurav.springfusion.dto.UserProfileDto;
import me.saurav.springfusion.dto.UserRegisterDto;
import me.saurav.springfusion.mapper.Mapper;
import me.saurav.springfusion.modal.User;
import me.saurav.springfusion.repository.UserRepository;
import me.saurav.springfusion.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserProfileDto save(UserRegisterDto rdto) {
        User user = Mapper.toUser(rdto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Instant now = Instant.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        User ruser = userRepository.save(user);
        return Mapper.toUserProfileDto(ruser);
    }

}
