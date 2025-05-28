package com.javachip.study.service;

import com.javachip.study.domain.CalendarEventEntity;
import com.javachip.study.dto.CalendarEventDto;
import com.javachip.study.exception.EventNotFoundException;
import com.javachip.study.mapper.CalendarEventMapper;
import com.javachip.study.repository.CalendarRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository repository;
    private final CalendarEventMapper mapper;

    public CalendarServiceImpl(CalendarRepository repository, CalendarEventMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Long createEvent(CalendarEventDto dto) {
        Long newId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        CalendarEventEntity entity = mapper.toEntity(newId, dto);
        repository.save(entity);
        return newId;
    }

    @Override
    public CalendarEventDto getEvent(Long id) {
        Optional<CalendarEventEntity> entityOpt = repository.findById(id);
        if (entityOpt.isEmpty()) {
            throw new EventNotFoundException(id);
        }
        return mapper.toDto(entityOpt.get());
    }

    @Override
    public List<CalendarEventDto> getAllEvents() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void updateEvent(Long id, CalendarEventDto dto) {
        repository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        repository.update(id, mapper.toEntity(id, dto));
    }

    @Override
    public void deleteEvent(Long id) {
        repository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        repository.delete(id);
    }
}
