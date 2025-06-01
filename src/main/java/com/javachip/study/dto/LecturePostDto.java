package com.javachip.study.dto;

import java.time.LocalDateTime;

// lecture POST
public record LecturePostDto(String title, String subtitle, LocalDateTime date, String location) {}
