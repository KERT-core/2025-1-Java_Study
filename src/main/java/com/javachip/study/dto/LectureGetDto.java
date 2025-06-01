package com.javachip.study.dto;

// lecture Get
public record LectureGetDto(String lectureId, String title, String date, String location, Integer participantsTotal, Integer participantsPresent) {}
