package com.javachip.study.repository;

import com.javachip.study.domain.ParticipantEntity;
import java.util.*;
import java.util.stream.Collectors;

//메모리 기반의 Participant Repository 구현체
//서버 꺼지면 다 날아감

public class InMemoryParticipantRepository implements ParticipantRepository {

    private final Map<Long, List<ParticipantEntity>> store = new HashMap<>();

    @Override
    public void save(ParticipantEntity participantEntity) {
        List<ParticipantEntity> participantList = store.getOrDefault(participantEntity.getLectureId(), new ArrayList<>());
        participantList.add(participantEntity);
        store.put(participantEntity.getLectureId(), participantList);
    }

    @Override
    public List<ParticipantEntity> findByLectureId(Long lectureId) {
        return store.getOrDefault(lectureId, Collections.emptyList());
    }

    @Override
    public List<ParticipantEntity> findByStudentId(Long studentId){
        return store.values().stream()
                .flatMap(List::stream)
                .filter(p -> p.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll(List<ParticipantEntity> participantEntities){
        for (ParticipantEntity participantEntity : participantEntities) {
            store.remove(participantEntity.getLectureId());
        }
    }
}
