package com.javachip.study.mapper;

import com.javachip.study.domain.LectureEntity;
import com.javachip.study.dto.LectureIdGetDto;
import com.javachip.study.dto.LectureIdPostDto;
import com.javachip.study.dto.ParticipantDto;

import java.util.List;

//LectureMapper 인터페이스의 구현체
//LectureIdPostDto -> LectureEntity -> LectureIdGetDto 변환 로직

public class LectureIdMapperImpl implements LectureIdMapper {
    @Override
    public LectureEntity toEntity(LectureIdPostDto dto){
        return new LectureEntity(null, dto.title(), dto.subtitle(), dto.date(), dto.location());
    }

    @Override
    public LectureIdGetDto toGetDto(LectureEntity entity, Integer participantsTotal, Integer participantsPresent, List<ParticipantDto> participants) {
        return new LectureIdGetDto(entity.getLectureId(), entity.getTitle(), entity.getSubtitle(), entity.getDate(), entity.getLocation(), participantsTotal, participantsPresent, participants);
    }
}
