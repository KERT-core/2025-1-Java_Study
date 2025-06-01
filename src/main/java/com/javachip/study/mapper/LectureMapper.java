package com.javachip.study.mapper;

import com.javachip.study.domain.LectureEntity;
import com.javachip.study.dto.LectureGetDto;
import com.javachip.study.dto.LecturePostDto;

//LectureEntity <-> LectureDto 간의 변환을 담당하는 매퍼 인터페이스
//직접 구현체 클래스를 만들거나 MapStruct를 활용 가능

public interface LectureMapper {
    LectureEntity toEntity(LecturePostDto dto, String lectureId);
    LectureGetDto toGetDto(LectureEntity entity);
}
