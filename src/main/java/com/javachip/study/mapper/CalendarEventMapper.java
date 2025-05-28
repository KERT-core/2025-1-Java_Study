package com.javachip.study.mapper;

import com.javachip.study.domain.CalendarEventEntity;
import com.javachip.study.dto.CalendarEventDto;

public class CalendarEventMapper {
    public static CalendarEventEntity toEntity(Long id, CalendarEventDto dto) {
        return new CalendarEventEntity(
                id, dto.getTitle(), dto.getDescription(), dto.getStart(), dto.getEnd()
        );
    }

    public static CalendarEventEntity toEntity(CalendarEventDto dto) {
        return toEntity(null, dto);
    }
}
