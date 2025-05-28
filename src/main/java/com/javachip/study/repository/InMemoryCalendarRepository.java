package com.javachip.study.repository;

import com.javachip.study.domain.CalendarEventEntity;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryCalendarRepository {

    private final Map<Long, CalendarEventEntity> store = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public CalendarEventEntity save(CalendarEventEntity event) {
        Long id = sequence.incrementAndGet();
        event.setId(id);
        store.put(id, event);
        return event;
    }

    public Optional<CalendarEventEntity> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<CalendarEventEntity> findAll() {
        return new ArrayList<>(store.values());
    }

    public CalendarEventEntity update(Long id, CalendarEventEntity event) {
        event.setId(id);
        store.put(id, event);
        return event;
    }

    public void delete(Long id) {
        store.remove(id);
    }
}