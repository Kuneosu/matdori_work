package com.mysite.matdori.information.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDTO {
    @Schema(description = "제목",example = "예시 게시글 입니다.")
    public String subject;

    @Schema(description = "내용", example = "안녕하세요")
    public String content;
}
