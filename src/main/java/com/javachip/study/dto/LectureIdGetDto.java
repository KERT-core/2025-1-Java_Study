package com.javachip.study.dto;

import java.util.List;

// lecture ID Get
public record LectureIdGetDto(String lectureId, String title, String subtitle, String date, String location, Integer participantsTotal, Integer participantsPresent, List<ParticipantDto> participants) {}
