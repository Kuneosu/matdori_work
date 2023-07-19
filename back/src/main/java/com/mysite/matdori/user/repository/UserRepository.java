package com.mysite.matdori.user.repository;

import com.mysite.matdori.user.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 아이디 중복 체크
    boolean existsByUserID(String userID);

    // 로그인 메소드
    Optional<User> findByUserIDAndPassword(String userID, String password);


    // 회원 탈퇴
    @Transactional
    void deleteById(Long userID);

    // 유저 검색
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByUserID(String userID);

    // 회원가입 메소드
}