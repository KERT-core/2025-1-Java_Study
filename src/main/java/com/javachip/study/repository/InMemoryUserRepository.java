package com.javachip.study.repository;

import com.javachip.study.domain.UserEntity;
import java.util.*;

//메모리 기반의 User Repository 구현체
//서버 꺼지면 다 날아감

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, UserEntity> store = new HashMap<>();

    @Override
    public void saveAll(List<UserEntity> userEntities) {
        for (UserEntity userEntity : userEntities) {
            store.put(userEntity.getstudentId(), userEntity);
        }
    }

    @Override
    public UserEntity findById(String id) {
        return store.get(id);
    }

    @Override
    public String findNameById(String id) {
        UserEntity userEntity = store.get(id);
        if (userEntity == null) {
            throw new RuntimeException("User not found for id: " + id);  // User가 없으면 예외 발생
        }
        return userEntity.getname();
    }

    @Override
    public List<UserEntity> findAll() {
        return new ArrayList<>(store.values());
    }
}
