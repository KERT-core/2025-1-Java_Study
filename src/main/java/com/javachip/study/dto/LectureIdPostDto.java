package com.javachip.study.dto;

import java.time.LocalDateTime;
import java.util.List;

// lecture ID POST
public record LectureIdPostDto(String title, String subtitle, LocalDateTime date, String location, List<ParticipantDto> participants) {}
