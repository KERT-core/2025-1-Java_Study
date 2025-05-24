package com.javachip.study.repository;

import com.javachip.study.domain.User;
import java.util.*;

//메모리 기반의 User Repository 구현체
//서버 꺼지면 다 날아감

public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, User> store = new HashMap<>();

    @Override
    public void save(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public User findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}
