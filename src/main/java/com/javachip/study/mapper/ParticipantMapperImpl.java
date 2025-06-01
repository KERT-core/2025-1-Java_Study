package com.javachip.study.mapper;

import com.javachip.study.domain.ParticipantEntity;
import com.javachip.study.dto.ParticipantDto;
import com.javachip.study.dto.ParticipantHistoryDto;

import java.util.List;
import java.util.stream.Collectors;

//UserMapper 인터페이스의 구현체
//UserEntity <-> UserDto 변환 로직

public class ParticipantMapperImpl implements ParticipantMapper {
    @Override
    public List<ParticipantDto> toParticipantDtoList(List<ParticipantEntity> entities){
        return entities.stream()
                .map(this::toParticipantDto)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipantHistoryDto toHistoryDto(ParticipantEntity entity){
        return new ParticipantHistoryDto(
                null, // lectureTitle
                null, // date
                entity.getStatus(),
                entity.getMemo()
        );
    }

    private ParticipantDto toParticipantDto(ParticipantEntity entity) {
        return new ParticipantDto(
                entity.getParticipantId(),
                entity.getStudentId(),
                null, //name
                entity.getStatus(),
                entity.getMemo()
        );
    }
}
