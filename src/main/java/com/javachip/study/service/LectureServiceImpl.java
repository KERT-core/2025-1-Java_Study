package com.javachip.study.service;

import com.javachip.study.domain.*;
import com.javachip.study.dto.*;
import com.javachip.study.mapper.LectureMapper;
import com.javachip.study.repository.LectureRepository;
import com.javachip.study.repository.ParticipantRepository;
import com.javachip.study.repository.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//UserService 인터페이스의 구현체
//생성자 주입 사용

public class LectureServiceImpl implements LectureService {
    private final UserRepository userRepo;
    private final LectureRepository lectureRepo;
    private final LectureMapper lectureMapper;
    private final ParticipantRepository participantRepo;

    public LectureServiceImpl(UserRepository userRepo, LectureRepository lectureRepo, LectureMapper lectureMapper, ParticipantRepository participantRepo) {
        this.userRepo = userRepo;
        this.lectureRepo = lectureRepo;
        this.lectureMapper = lectureMapper;
        this.participantRepo = participantRepo;
    }

    @Override
    public void addLecture(LecturePostDto lecturePostDto){ // Lecture ID 생성해야 함.
        Long newId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        LectureEntity lectureEntity = lectureMapper.toEntity(lecturePostDto, newId.toString());
        lectureRepo.save(lectureEntity);
        System.out.println("lecture Id: " + newId);
    }

    @Override
    public List<LectureGetDto> getAllLectures(){
        List<LectureEntity> lectureEntities = lectureRepo.findAll();

        return lectureEntities.stream()
                .map(lectureMapper::toGetDto)
                .collect(Collectors.toList());
    }

    @Override
    public LectureIdGetDto getLecture(String lectureId){
        LectureEntity lectureEntity = lectureRepo.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        List<ParticipantEntity> participants = participantRepo.findByLectureId(lectureId);

        long participantsPresent = participants.stream()
                .filter(participant -> "출석".equals(participant.getStatus()))
                .count();

        Integer participantsTotal = participants.size();

        List<ParticipantDto> participantDtoList = participants.stream()
                .map(participant -> new ParticipantDto(
                        participant.getParticipantId(),
                        participant.getStudentId(),
                        userRepo.findNameById(participant.getStudentId()),
                        participant.getStatus(),
                        participant.getMemo()
                ))
                .collect(Collectors.toList());

        // LectureIdGetDto 반환
        return new LectureIdGetDto(
                lectureEntity.getLectureId(),
                lectureEntity.getTitle(),
                lectureEntity.getSubtitle(),
                lectureEntity.getDate(),
                lectureEntity.getLocation(),
                participantsTotal,
                (int) participantsPresent,
                participantDtoList
        );
    }

    @Override
    public void updateLecture(String lectureId, LectureIdPostDto lectureIdPostDto){
        LectureEntity existingLecture = lectureRepo.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        existingLecture.setTitle(lectureIdPostDto.title());
        existingLecture.setSubtitle(lectureIdPostDto.subtitle());
        existingLecture.setDate(lectureIdPostDto.date());
        existingLecture.setLocation(lectureIdPostDto.location());

        List<ParticipantEntity> existingParticipants = participantRepo.findByLectureId(lectureId);
        participantRepo.deleteAll(existingParticipants);

        Long newId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        List<ParticipantDto> participantDtoList = lectureIdPostDto.participants();
        for (ParticipantDto participantDto : participantDtoList) {
            ParticipantEntity newParticipant = new ParticipantEntity(
                    newId.toString(),
                    lectureId,
                    participantDto.studentId(),
                    participantDto.status(),
                    participantDto.memo()
            );

            // 새로운 참가자 저장
            participantRepo.save(newParticipant);
        }

        // 강의 정보 저장 (업데이트)
        lectureRepo.save(existingLecture);
    }
}
