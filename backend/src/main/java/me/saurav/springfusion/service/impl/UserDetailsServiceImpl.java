package me.saurav.springfusion.service.impl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.saurav.springfusion.modal.User;
import me.saurav.springfusion.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByEmailIgnoreCase(email);
        if (user.isEmpty())
            throw new UsernameNotFoundException("user does not exist");

        return new UserPrincipalImpl(user.get());
    }

}
