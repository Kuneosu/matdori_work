package com.mysite.matdori.user.repository;

import com.mysite.matdori.user.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 아이디 중복 체크
    boolean existsByEmail(String email);

    // 로그인 메소드
    Optional<User> findByIDAndPassword(String ID, String password);


    // 회원 탈퇴
    @Transactional
    void deleteById(Long ID);

    // 유저 검색
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByID(String ID);

    // 회원가입 메소드
}