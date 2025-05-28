package com.javachip.study.service;

import com.javachip.study.domain.CalendarEventEntity;
import com.javachip.study.dto.CalendarEventDto;
import com.javachip.study.exception.EventNotFoundException;
import com.javachip.study.mapper.CalendarEventMapper;
import com.javachip.study.repository.InMemoryCalendarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    private final InMemoryCalendarRepository repository;

    public CalendarService(InMemoryCalendarRepository repository) {
        this.repository = repository;
    }

    public CalendarEventEntity createEvent(CalendarEventDto dto) {
        CalendarEventEntity event = CalendarEventMapper.toEntity(dto);
        return repository.save(event);
    }

    public List<CalendarEventEntity> getAllEvents() {
        return repository.findAll();
    }

    public CalendarEventEntity updateEvent(Long id, CalendarEventDto dto) {
        if (repository.findById(id).isEmpty()) {
            throw new EventNotFoundException(id);
        }
        CalendarEventEntity updated = CalendarEventMapper.toEntity(id, dto);
        return repository.update(id, updated);
    }

    public void deleteEvent(Long id) {
        if (repository.findById(id).isEmpty()) {
            throw new EventNotFoundException(id);
        }
        repository.delete(id);
    }
}
