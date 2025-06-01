package com.javachip.study.dto;

import java.time.LocalDateTime;

// lecture Get
public record LectureGetDto(Long lectureId, String title, LocalDateTime date, String location, Integer participantsTotal, Integer participantsPresent) {}
