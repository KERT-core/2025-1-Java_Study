package com.javachip.study.repository;

import com.javachip.study.domain.UserEntity;
import java.util.*;

//메모리 기반의 User Repository 구현체
//서버 꺼지면 다 날아감

public class InMemoryUserRepository implements UserRepository {
    @Override
    private final Map<Long, UserEntity> store = new HashMap<>();

    @Override
    public void save(UserEntity user) {
        store.put(user.getId(), user);
    }

    @Override
    public UserEntity findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return new ArrayList<>(store.values());
    }
}
