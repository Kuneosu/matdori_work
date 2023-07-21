package com.mysite.matdori.information.service;

import com.mysite.matdori.information.dto.CreateDTO;
import com.mysite.matdori.information.dto.UpdateDTO;
import com.mysite.matdori.information.entity.Information;
import com.mysite.matdori.information.repository.InformationRepository;
import com.mysite.matdori.user.entity.User;
import com.mysite.matdori.user.repository.UserRepository;
import com.mysite.matdori.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class InformationService {

    private final InformationRepository informationRepository;
    private final UserService userService;

    public Information create(Information information, HttpServletRequest req) {
        User user = userService.whoami(req);
        information.setUser(user);
        return(informationRepository.save(information));
    }

    public List<Information> allInformation(){
        return(informationRepository.findAll());
    }

    public Information readInformation(Long ID){
        Information information = informationRepository.findById(ID).get();
        return(information);
    }

    public Information updateInformation(Long ID, UpdateDTO newinformation, User user){

        Information information1 = informationRepository.findById(ID).get();

        if(user.getUserID().equals(information1.getUser().getUserID())) {
            information1.setContent(newinformation.getContent());
            information1.setSubject(newinformation.getSubject());
            return(informationRepository.save(information1));
        }
        throw new RuntimeException("수정할 권한이 없습니다.");
    }

    public void deleteInformation(Long ID, User user) {
        Information information = informationRepository.findById(ID)
                .orElseThrow(() -> new RuntimeException("해당 게시글을 찾지 못함"));

        if (!information.getUser().getIdx().equals(user.getIdx())) {
            throw new RuntimeException("삭제할 권한이 없습니다.");
        }
        informationRepository.delete(information);
    }
}
