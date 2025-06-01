package com.javachip.study.repository;

import com.javachip.study.domain.LectureEntity;
import com.javachip.study.domain.UserEntity;

import java.util.*;

//메모리 기반의 User Repository 구현체
//서버 꺼지면 다 날아감

public class InMemoryLectureRepository implements LectureRepository {

    private final Map<Long, LectureEntity> store = new HashMap<>();

    @Override
    public void save(LectureEntity lectureEntity) {
        store.put(lectureEntity.getLectureId(), lectureEntity);  // lectureId를 키로 저장
    }

    @Override
    public Optional<LectureEntity> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // 주어진 lectureId로 찾기
    }

    @Override
    public List<LectureEntity> findAll() {
        return new ArrayList<>(store.values());  // 저장된 모든 LectureEntity 반환
    }
}
