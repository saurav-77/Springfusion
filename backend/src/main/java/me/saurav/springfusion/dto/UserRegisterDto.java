package me.saurav.springfusion.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterDto {
    @NotBlank(message = "username can't be empty")
    private String username;
    @Email(message = "enter valid email")
    private String email;
    @Size(min = 5, max = 29)
    private String password;
}
