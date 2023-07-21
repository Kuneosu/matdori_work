package com.mysite.matdori.frugal.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDto {
    @Schema(description = "제목",example = "첫번째 알뜰백과 입니다.")
    public String subject;

    @Schema(description = "내용", example = "안녕하세요")
    public String content;

    @Schema(description = "이미지", example = "")
    public Blob image;
}