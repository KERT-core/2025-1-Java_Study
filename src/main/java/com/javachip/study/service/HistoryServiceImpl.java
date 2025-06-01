package com.javachip.study.service;

import com.javachip.study.domain.ParticipantEntity;
import com.javachip.study.exception.*;
import com.javachip.study.repository.ParticipantRepository;
import java.util.List;

//HistoryService 인터페이스의 구현체
//생성자 주입 사용

public class HistoryServiceImpl implements HistoryService {
    private final ParticipantRepository participantRepo;

    public HistoryServiceImpl(ParticipantRepository participantRepo) {
        this.participantRepo = participantRepo;
    }

    @Override
    public List<ParticipantEntity> getParticipantHistory(Long studentId){
        List<ParticipantEntity> history = participantRepo.findByStudentId(studentId);
        if (history == null || history.isEmpty()) {
            throw new UserNotFoundException(studentId);
        }
        return history;
    }
}
