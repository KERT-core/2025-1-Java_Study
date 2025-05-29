package com.javachip.study.domain;

//유저 도메인 객체(DB)
//데이터베이스와 매칭하기 위한 클래스
//생성자 주입 사용
public class UserEntity {
    private final Long studentId;
    private final String username;
    private final String password;
    private final String email;

    public UserEntity(Long studentId, String username, String password, String email) {
        this.studentId = studentId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getStudentId() {
        return studentId;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
}
