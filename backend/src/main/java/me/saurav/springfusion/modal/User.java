package me.saurav.springfusion.modal;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "users")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String username;

    @Indexed(unique = true)
    private String email;

    private String password;

   
    private Instant createdAt;

    private Instant updatedAt;

    private String verifyOtp;

    private boolean isAccountVerified;

    private long verifyOtpExpiredAt;

    private String resetOtp;

    private long resetOtpExpiredAt;

}
