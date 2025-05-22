package com.javachip.study.domain;

//유저 도메인 객체(DB)
//데이터베이스와 매칭하기 위한 클래스
//생성자 주입 사용

public class UserEntity {
    private final Long id;
    private final String username;
    private final int age;

    public UserEntity(Long id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public int getAge() { return age; }
}
