package com.javachip.study.controller;

import com.javachip.study.dto.CalendarEventDto;
import com.javachip.study.response.ApiResponse;
import com.javachip.study.service.CalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createEvent(@RequestBody CalendarEventDto eventDto) {
        return ResponseEntity.ok(ApiResponse.success(calendarService.createEvent(eventDto)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllEvents() {
        return ResponseEntity.ok(ApiResponse.success(calendarService.getAllEvents()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateEvent(@PathVariable Long id, @RequestBody CalendarEventDto eventDto) {
        return ResponseEntity.ok(ApiResponse.success(calendarService.updateEvent(id, eventDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteEvent(@PathVariable Long id) {
        calendarService.deleteEvent(id);
        return ResponseEntity.ok(ApiResponse.success("Deleted successfully"));
    }
}
