package com.javachip.study.dto;

// participant GET (for /history)
public record ParticipantHistoryDto(String lectureTitle, String date, String status, String memo) {}
