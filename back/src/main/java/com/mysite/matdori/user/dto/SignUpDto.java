package com.mysite.matdori.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {
    @Schema(description = "이메일", example = "test@test.com")
    private String email;

    @Schema(description = "아이디", example = "cjh1234")
    private String userID;

    @Schema(description = "비밀번호", example = "1234")
    private String password;

    @Schema(description = "이름", example = "홍길동")
    private String username;

    @Schema(description = "닉네임", example = "맛도리")
    private String nickname;
}