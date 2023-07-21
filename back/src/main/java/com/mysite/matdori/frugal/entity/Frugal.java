package com.mysite.matdori.frugal.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Frugal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String subject;

    private String content;

    private LocalDateTime createDate;

    @Lob
    private byte[] image;
}
