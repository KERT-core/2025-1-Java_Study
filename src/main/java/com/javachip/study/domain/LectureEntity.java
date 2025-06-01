package com.javachip.study.domain;

//Lecture 도메인 객체(DB)
//데이터베이스와 매칭하기 위한 클래스
//생성자 주입 사용

import java.time.LocalDateTime;

public class LectureEntity {
    private Long lectureId;
    private String title;
    private String subtitle;
    private LocalDateTime date;
    private String location;

    public LectureEntity(Long lectureId, String title, String subtitle, LocalDateTime date, String location) {
        this.lectureId = lectureId;
        this.title = title;
        this.subtitle = subtitle;
        this.date = date;
        this.location = location;
    }

    public Long getLectureId(){ return lectureId; }
    public String getTitle() { return title; }
    public String getSubtitle() { return subtitle; }
    public LocalDateTime getDate() { return date; }
    public String getLocation() { return location; }

    public void setLectureId(Long lectureId) { this.lectureId = lectureId; }
    public void setTitle(String title) { this.title = title; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }
}
