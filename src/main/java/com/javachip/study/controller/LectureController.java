package com.javachip.study.controller;

import com.javachip.study.dto.*;
import com.javachip.study.service.LectureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//사용자 관련 API 요청을 처리하는 컨트롤러 클래스
//사용자 등록, 조회를 지원

@RestController
@RequestMapping("/lecture")
public class LectureController {
    private final LectureService service;

    public LectureController(LectureService service) {
        this.service = service;
    }

    @PostMapping
    public void addLecture(@RequestBody LecturePostDto lecturePostDto) {
        service.addLecture(lecturePostDto);
    }

    @GetMapping
    public List<LectureGetDto> getAllLectures() {
        return service.getAllLectures();
    }

    @PostMapping("/{lectureId}")
    public void updateLecture(@PathVariable Long lectureId, @RequestBody LectureIdPostDto lectureIdPostDto) {
        service.updateLecture(lectureId, lectureIdPostDto);
    }

    @GetMapping("/{lectureId}")
    public LectureIdGetDto getLecture(@PathVariable Long lectureId) {
        return service.getLecture(lectureId);
    }
}
