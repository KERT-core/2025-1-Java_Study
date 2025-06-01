package com.javachip.study.mapper;

import com.javachip.study.domain.ParticipantEntity;
import com.javachip.study.dto.ParticipantDto;
import com.javachip.study.dto.ParticipantHistoryDto;

import java.util.List;

//ParticipantEntity <-> ParticipantDto, ParticipantHistoryDto 간의 변환을 담당하는 매퍼 인터페이스
//직접 구현체 클래스를 만들거나 MapStruct를 활용 가능

public interface ParticipantMapper {
    List<ParticipantDto> toParticipantDtoList(List<ParticipantEntity> entities);
    ParticipantHistoryDto toHistoryDto(ParticipantEntity entity);
}
