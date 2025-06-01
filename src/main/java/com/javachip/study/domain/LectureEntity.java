package com.javachip.study.domain;

//Lecture 도메인 객체(DB)
//데이터베이스와 매칭하기 위한 클래스
//생성자 주입 사용

public class LectureEntity {
    private String lectureId;
    private String title;
    private String subtitle;
    private String date;
    private String location;

    public LectureEntity(String lectureId, String title, String subtitle, String date, String location) {
        this.lectureId = lectureId;
        this.title = title;
        this.subtitle = subtitle;
        this.date = date;
        this.location = location;
    }

    public String getLectureId(){ return lectureId; }
    public String getTitle() { return title; }
    public String getSubtitle() { return subtitle; }
    public String getDate() { return date; }
    public String getLocation() { return location; }

    public void setLectureId(String lectureId) { this.lectureId = lectureId; }
    public void setTitle(String title) { this.title = title; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }
    public void setDate(String date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }
}
