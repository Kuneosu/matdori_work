package com.mysite.matdori.security;

import com.mysite.matdori.user.entity.User;
import com.mysite.matdori.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
        final User user = userRepository.findByUserID(userID).get();

        if (user == null) {
            throw new UsernameNotFoundException("User '" + userID + "' not found");
        }

        return org.springframework.security.core.userdetails.User//
                .withUsername(userID)//
                .password(user.getPassword())//
                .authorities(user.getRoles())//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();
    }
}
