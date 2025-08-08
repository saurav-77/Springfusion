package me.saurav.springfusion.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
    @JsonAlias({ "email" })
    private String email;
    private String password;
}
