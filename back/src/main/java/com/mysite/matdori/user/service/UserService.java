package com.mysite.matdori.user.service;

import com.mysite.matdori.security.jwt.JwtTokenProvider;
import com.mysite.matdori.user.entity.User;
import com.mysite.matdori.user.entity.UserRole;
import com.mysite.matdori.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public String singin(String ID, String password) {
        try {
            User user = userRepository.findByUserID(ID).get();
            log.info("user: {}", user);
            log.info("ID: {}", ID);
            log.info("password: {}", password);
            if (!passwordEncoder.matches(password, user.getPassword())) {
                log.error("Invalid password");
                throw new RuntimeException("Invalid password    ");
            }
            return jwtTokenProvider.createToken(user.getUserID(), user.getRoles());

        } catch (Exception e) {
            log.info(e.getMessage());
            log.error("Invalid username/password supplied");
            throw new RuntimeException("Invalid username/password supplied");
        }
    }

    public User signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Client 역할 부여
        if (user.getRoles() == null) {
            List<UserRole> set = new ArrayList<UserRole>();
            set.add(UserRole.ROLE_CLIENT);
            user.setRoles(set);
        }
        userRepository.save(user);
        user = userRepository.findByUserID(user.getUserID()).get();
        user.setNickname(user.getNickname()+"#"+user.getIdx());

        return userRepository.save(user);
    }

    public User getUserByEmail(String useremail) {
        return userRepository.findByEmail(useremail).get();
    }

    public User getUserByName(String username){
        return userRepository.findByUsername(username).get();
    }

    public User whoami(HttpServletRequest req) {
        log.info(jwtTokenProvider.resolveToken(req));
        return userRepository
                .findByUserID(jwtTokenProvider.getUserID(jwtTokenProvider.resolveToken(req)))
                .get();
    }

    public boolean isUserIdExists(String userID) {
        return userRepository.existsByUserID(userID);
    }

    ///////////////////////admin 유저 생성/////////////////
    @EventListener
    public void createAdminAccount(ApplicationReadyEvent event) {
        // 관리자 계정 정보
        String adminID = "admin";
        String adminEmail = "admin";
        String adminPassword = "admin";
        String adminUsername = "admin";
        String adminUserNickName= "관리자";
        // 이미 관리자 계정이 존재하는지 확인
        if (userRepository.existsByUserID(adminID)) {
            return; // 이미 관리자 계정이 존재하면 생성하지 않음
        }

        // 관리자 계정 생성
        User adminUser = new User();
        adminUser.setUserID(adminID);
        adminUser.setEmail(adminEmail);
        adminUser.setPassword(passwordEncoder.encode(adminPassword));
        adminUser.setUsername(adminUsername);
        adminUser.setNickname(adminUserNickName);
        // admin 역할 부여
        if (adminUser.getRoles() == null) {
            List<UserRole> set = new ArrayList<UserRole>();
            set.add(UserRole.ROLE_ADMIN);
            adminUser.setRoles(set);
        }
        userRepository.save(adminUser);
    }
}