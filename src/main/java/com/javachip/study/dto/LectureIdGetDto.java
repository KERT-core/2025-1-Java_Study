package com.javachip.study.dto;

import java.time.LocalDateTime;
import java.util.List;

// lecture ID Get
public record LectureIdGetDto(Long lectureId, String title, String subtitle, LocalDateTime date, String location, Integer participantsTotal, Integer participantsPresent, List<ParticipantDto> participants) {}
