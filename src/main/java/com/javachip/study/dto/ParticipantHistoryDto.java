package com.javachip.study.dto;

import java.time.LocalDateTime;

// participant GET (for /history)
public record ParticipantHistoryDto(String lectureTitle, LocalDateTime date, String status, String memo) {}
