package com.mysite.matdori.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users") //데이터 베이스에 존재하는 user랑 안겹치게?
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String ID;

    private String password;

    private String username;

    private String nickname;

    @ElementCollection(fetch = FetchType.EAGER)
    List<UserRole> roles;
}