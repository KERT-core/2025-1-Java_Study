package com.javachip.study.service;

import com.javachip.study.domain.ParticipantEntity;
import com.javachip.study.dto.UserDto;

import java.util.List;

//User 관련 비즈니스 로직들을 구현하기 위한 인터페이스

public interface HistoryService {
    List<ParticipantEntity> getParticipantHistory(String studentId);
}
