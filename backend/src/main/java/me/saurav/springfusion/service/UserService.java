package me.saurav.springfusion.service;

import me.saurav.springfusion.dto.UserProfileDto;
import me.saurav.springfusion.dto.UserRegisterDto;


public interface UserService {

    UserProfileDto save(UserRegisterDto rdto);

}
