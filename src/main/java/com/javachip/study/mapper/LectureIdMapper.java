package com.javachip.study.mapper;

import com.javachip.study.domain.LectureEntity;
import com.javachip.study.dto.LectureIdGetDto;
import com.javachip.study.dto.LectureIdPostDto;
import com.javachip.study.dto.ParticipantDto;

import java.util.List;

//LectureEntity <-> LectureIdDto 간의 변환을 담당하는 매퍼 인터페이스
//직접 구현체 클래스를 만들거나 MapStruct를 활용 가능

public interface LectureIdMapper {
    LectureEntity toEntity(LectureIdPostDto dto);
    LectureIdGetDto toGetDto(LectureEntity entity, Integer participantsTotal, Integer participantsPresent, List<ParticipantDto> participants);
}
