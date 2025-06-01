package com.javachip.study.service;

import com.javachip.study.dto.*;
import java.util.List;

//Lecture 관련 비즈니스 로직들을 구현하기 위한 인터페이스

public interface LectureService {
    void addLecture(LecturePostDto lecturePostDto);
    List<LectureGetDto> getAllLectures();
    LectureIdGetDto getLecture(Long lectureId);
    void updateLecture(Long lectureId, LectureIdPostDto lectureIdPostDto);
}
