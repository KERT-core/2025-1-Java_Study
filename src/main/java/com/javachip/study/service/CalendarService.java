package com.javachip.study.service;

import com.javachip.study.dto.CalendarEventDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalendarService {
    Long createEvent(CalendarEventDto dto);
    CalendarEventDto getEvent(Long id);
    List<CalendarEventDto> getAllEvents();
    void updateEvent(Long id, CalendarEventDto dto);
    void deleteEvent(Long id);
}
