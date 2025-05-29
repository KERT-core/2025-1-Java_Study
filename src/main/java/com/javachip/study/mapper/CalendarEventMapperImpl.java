package com.javachip.study.mapper;

import com.javachip.study.domain.CalendarEventEntity;
import com.javachip.study.dto.CalendarEventDto;
import org.springframework.stereotype.Component;

@Component
public class CalendarEventMapperImpl implements CalendarEventMapper {

    @Override
    public CalendarEventEntity toEntity(Long id, CalendarEventDto dto) {
        return new CalendarEventEntity(
                id,
                dto.title(),
                dto.description(),
                dto.start(),
                dto.end()
        );
    }

    @Override
    public CalendarEventDto toDto(CalendarEventEntity entity) {
        return new CalendarEventDto(
                entity.getTitle(),
                entity.getDescription(),
                entity.getStart(),
                entity.getEnd()
        );
    }
}
