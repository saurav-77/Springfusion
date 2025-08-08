package me.saurav.springfusion.mapper;

import me.saurav.springfusion.dto.UserProfileDto;
import me.saurav.springfusion.dto.UserRegisterDto;
import me.saurav.springfusion.modal.User;

public final class Mapper {
    public static User toUser(UserRegisterDto rdto) {
        User user = new User();
        user.setAccountVerified(false);
        user.setEmail(rdto.getEmail());
        user.setPassword(rdto.getPassword());
        user.setUsername(rdto.getUsername());
        return user;
    }

    public static UserProfileDto toUserProfileDto(User user) {
        UserProfileDto res = new UserProfileDto();
        res.setUsername(user.getUsername());
        res.setAccountVerified(user.isAccountVerified());
        res.setCreatedAt(user.getCreatedAt());
        res.setUpdatedAt(user.getUpdatedAt());
        res.setEmail(user.getEmail());
        return res;
    }
}
