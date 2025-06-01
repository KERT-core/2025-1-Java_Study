package com.javachip.study.controller;

import com.javachip.study.domain.ParticipantEntity;
import com.javachip.study.dto.UserDto;
import com.javachip.study.service.HistoryService;
import com.javachip.study.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//사용자 관련 API 요청을 처리하는 컨트롤러 클래스
//사용자 등록, 조회를 지원

@RestController
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService service;

    public HistoryController(HistoryService service) {
        this.service = service;
    }

    @GetMapping("/{studentId}")
    public List<ParticipantEntity> getParticipantHistory(@PathVariable String studentId) {
        return service.getParticipantHistory(studentId);
    }
}
