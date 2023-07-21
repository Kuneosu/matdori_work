package com.mysite.matdori.information.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mysite.matdori.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String subject;

    private String content;

    private LocalDateTime createDate;

    @JsonBackReference
    @ManyToOne
    private User user;
}
