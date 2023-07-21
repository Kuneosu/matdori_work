package com.mysite.matdori.information.controller;

import com.mysite.matdori.information.dto.CreateDTO;
import com.mysite.matdori.information.dto.UpdateDTO;
import com.mysite.matdori.information.entity.Information;
import com.mysite.matdori.information.service.InformationService;
import com.mysite.matdori.user.entity.User;
import com.mysite.matdori.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "Information", description = "Information API")
@RequestMapping("/api/information")
@RequiredArgsConstructor
public class InformationController {
    private final InformationService informationService;
    private final UserService userService;

    @PostMapping("/create")
    @Operation(summary ="정보 게시글 생성")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public Information creat(@RequestBody CreateDTO information, HttpServletRequest req){
        Information information1 = Information.builder().subject(information.getSubject())
                .content(information.getContent()).build();
        return informationService.create(information1, req);
    }

    @GetMapping("/all_information")
    @Operation(summary ="모든 실시간 정보 게시글 불러오기")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public List<Information> readAll(){
        return(informationService.allInformation());
    }

    @GetMapping("information/{id}")
    @Operation(summary = "특정 실시간 정보 게시글 불러오기")
    @PreAuthorize("hasRole(ROLE_ADMIN) or hasRole('ROLE_CLIENT')")
    public Information readInformation(@PathVariable("id") Long ID){
        return(informationService.readInformation(ID));
    }

    @PutMapping("update/{id}")
    @Operation(summary = "특정 실시간 정보 업데이트")
    @PreAuthorize("hasRole(ROLE_ADMIN) or hasRole('ROLE_CLIENT')")
    public Information updateInformation(@PathVariable("id") Long ID, @RequestBody UpdateDTO information,
                                         HttpServletRequest req) {
        log.info("hihi");
        User user = userService.whoami(req);
        return (informationService.updateInformation(ID, information, user));
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "특정 실시간 정보 삭제")
    @PreAuthorize("hasRole(ROLE_ADMIN) or hasRole('ROLE_CLIENT')")
    public ResponseEntity<?> deleteInformation(@PathVariable("id") Long id, HttpServletRequest req) {
        // 현재 인증된 사용자 가져오기
        User user = userService.whoami(req);
        informationService.deleteInformation(id, user);
        return ResponseEntity.ok().build();
    }
}
