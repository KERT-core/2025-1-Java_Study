package com.javachip.study.dto;

import java.time.LocalDateTime;

public record CalendarEventDto(
        String title,
        String description,
        LocalDateTime start,
        LocalDateTime end
) {}
