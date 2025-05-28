package com.javachip.study.mapper;

import com.javachip.study.domain.CalendarEventEntity;
import com.javachip.study.dto.CalendarEventDto;

public interface CalendarEventMapper {
    CalendarEventEntity toEntity(Long id, CalendarEventDto dto);
    CalendarEventDto toDto(CalendarEventEntity entity);
}
