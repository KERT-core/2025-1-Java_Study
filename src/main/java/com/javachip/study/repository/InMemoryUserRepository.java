package com.javachip.study.repository;

import com.javachip.study.domain.UserEntity;
import java.util.*;

//메모리 기반의 User Repository 구현체
//서버 꺼지면 다 날아감

public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, UserEntity> store = new HashMap<>();

    @Override
    public void save(UserEntity user) {
        store.put(user.getStudentId(), user);
    }

    @Override
    public UserEntity findByStudentId(Long studentId) {
        return store.get(studentId);
    }

    @Override
    public List<UserEntity> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return store.values().stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }
}
