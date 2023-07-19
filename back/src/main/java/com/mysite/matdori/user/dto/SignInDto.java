package com.mysite.matdori.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SignInDto {
    @Schema(description = "아이디", example = "cjh1234")
    public String userID;

    @Schema(description = "비밀번호", example = "1234")
    public String password;
}
