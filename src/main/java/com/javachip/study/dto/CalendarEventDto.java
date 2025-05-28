package com.javachip.study.dto;

import java.time.LocalDateTime;

public class CalendarEventDto {
    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;

    // 생성자, getter, setter
    public CalendarEventDto(String title, String description, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
