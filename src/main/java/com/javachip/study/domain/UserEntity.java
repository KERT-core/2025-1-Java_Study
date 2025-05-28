package com.javachip.study.domain;

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

