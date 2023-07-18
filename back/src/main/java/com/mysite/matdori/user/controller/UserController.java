package com.mysite.matdori.user.controller;

import com.mysite.matdori.user.dto.SignInDto;
import com.mysite.matdori.user.dto.SignUpDto;
import com.mysite.matdori.user.dto.Token;
import com.mysite.matdori.user.entity.User;
import com.mysite.matdori.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "User", description = "User API")
@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    @Operation(summary = "회원가입")
    public User signup(@RequestBody SignUpDto user) {

        User user1 = User.builder().email(user.getEmail()).userID(user.getUserID()).password(user.getPassword())
                .username(user.getUsername()).nickname(user.getNickname()).build();

        return userService.signup(user1);
    }

    @PostMapping("/signin")
    @Operation(summary = "로그인")
    public Token signin(@RequestBody SignInDto signInDto) {
        Token token = Token.builder()
                .token(userService.singin(signInDto.getUserID(), signInDto.getPassword())).build();
        return token;
    }

    @GetMapping("/check/{id}")
    @Operation(summary = "ID 중복 확인")
    public ResponseEntity<Boolean> checkId(@PathVariable("id") String id) {
        boolean exists = userService.isUserIdExists(id);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}