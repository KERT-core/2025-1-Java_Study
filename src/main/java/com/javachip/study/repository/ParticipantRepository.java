package com.javachip.study.repository;

import com.javachip.study.domain.ParticipantEntity;
import java.util.List;

//Participant 테이블 repository를 위한 인터페이스
//구현체는 지금 InMemory버전만 존재하지만, 필요에 따라서 DB버전의 구현체도 만들수있음(해야할 일임)
//구현체를 갈아끼울때는 AppConfig를 이용

public interface ParticipantRepository {
    void save(ParticipantEntity participantEntity);
    List<ParticipantEntity> findByLectureId(Long lectureId);
    List<ParticipantEntity> findByStudentId(Long studentId);
    void deleteAll(List<ParticipantEntity> participantEntities);
}
