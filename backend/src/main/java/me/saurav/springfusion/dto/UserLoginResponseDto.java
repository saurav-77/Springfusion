package me.saurav.springfusion.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponseDto {
    private String jwtToken;
    private String username;
    private String email;
    private Instant createdAt;
    private Instant updatedAt;
}