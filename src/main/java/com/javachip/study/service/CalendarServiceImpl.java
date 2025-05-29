package com.javachip.study.service;

import com.javachip.study.domain.CalendarEventEntity;
import com.javachip.study.dto.CalendarEventDto;
import com.javachip.study.exception.*;
import com.javachip.study.mapper.CalendarEventMapper;
import com.javachip.study.repository.CalendarRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository repository;
    private final CalendarEventMapper mapper;

    public CalendarServiceImpl(CalendarRepository repository, CalendarEventMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Long createEvent(CalendarEventDto dto) {
        validateDto(dto);

        if (dto.start().isAfter(dto.end())) {
            throw new EventInvalidTimeRangeException(dto.start(), dto.end());
        }

        Long newId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        CalendarEventEntity entity = mapper.toEntity(newId, dto);
        repository.save(entity);
        return newId;
    }

    @Override
    public CalendarEventDto getEvent(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    @Override
    public List<CalendarEventDto> getAllEvents() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void updateEvent(Long id, CalendarEventDto dto) {
        validateDto(dto);

        CalendarEventEntity existing = repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));

        // TODO: 권한 체크
        // if (!hasPermissionToUpdate(existing)) {
        //     throw new EventUnauthorizedAccessException(id);
        // }

        if (dto.start().isAfter(dto.end())) {
            throw new EventInvalidTimeRangeException(dto.start(), dto.end());
        }

        repository.update(id, mapper.toEntity(id, dto));
    }

    @Override
    public void deleteEvent(Long id) {
        CalendarEventEntity existing = repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));

        // TODO: 권한 체크
        // if (!hasPermissionToDelete(existing)) {
        //     throw new EventUnauthorizedAccessException(id);
        // }

        repository.delete(id);
    }

    private void validateDto(CalendarEventDto dto) {
        if (dto.title() == null || dto.title().isBlank() ||
                dto.start() == null || dto.end() == null) {
            throw new EventMissingFieldException("title, start, end 필드는 필수입니다.");
        }
    }
}
