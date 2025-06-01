package com.javachip.study.domain;

//User 도메인 객체(DB)
//데이터베이스와 매칭하기 위한 클래스
//생성자 주입 사용

public class UserEntity {
    private Long studentId;
    private String name;

    public UserEntity(Long studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public Long getstudentId() { return studentId; }
    public String getname() { return name; }

    public void setstudentId(Long studentId) { this.studentId = studentId; }
    public void setname(String name) { this.name = name; }
}
