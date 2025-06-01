package com.javachip.study.dto;

import java.util.List;

// lecture ID POST
public record LectureIdPostDto(String title, String subtitle, String date, String location, List<ParticipantDto> participants) {}
