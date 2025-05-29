package com.javachip.study.controller;

import com.javachip.study.dto.CalendarEventDto;
import com.javachip.study.response.ApiResponse;
import com.javachip.study.service.CalendarServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private final CalendarServiceImpl service;

    public CalendarController(CalendarServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<Long> create(@RequestBody CalendarEventDto dto) {
        return ApiResponse.success(service.createEvent(dto));
    }

    @GetMapping("/{id}")
    public ApiResponse<CalendarEventDto> get(@PathVariable Long id) {
        return ApiResponse.success(service.getEvent(id));
    }

    @GetMapping
    public ApiResponse<List<CalendarEventDto>> list() {
        return ApiResponse.success(service.getAllEvents());
    }

    @PutMapping("/{id}")
    public ApiResponse<String> update(@PathVariable Long id, @RequestBody CalendarEventDto dto) {
        service.updateEvent(id, dto);
        return ApiResponse.success("Updated successfully");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        service.deleteEvent(id);
        return ApiResponse.success("Deleted successfully");
    }
}
