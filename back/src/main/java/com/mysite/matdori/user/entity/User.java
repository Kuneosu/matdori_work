package com.mysite.matdori.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mysite.matdori.information.entity.Information;
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
    private String userID;

    private String password;

    private String username;

    private String nickname;

    @ElementCollection(fetch = FetchType.EAGER)
    List<UserRole> roles;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Information> informationList;
}