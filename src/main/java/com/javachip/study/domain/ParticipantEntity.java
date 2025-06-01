package com.javachip.study.domain;

//Participant 도메인 객체(DB)
//데이터베이스와 매칭하기 위한 클래스
//생성자 주입 사용

public class ParticipantEntity {
    private Long participantId;
    private Long lectureId;
    private Long studentId;
    private String status;
    private String memo;

    public ParticipantEntity(Long participantId, Long lectureId, Long studentId, String status, String memo) {
        this.participantId = participantId;
        this.lectureId = lectureId;
        this.studentId = studentId;
        this.status = status;
        this.memo = memo;
    }

    public Long getParticipantId() { return participantId; }
    public Long getLectureId() { return lectureId; }
    public Long getStudentId() { return studentId; }
    public String getStatus() { return status; }
    public String getMemo() { return memo; }

    public void setParticipantId(Long participantId) { this.participantId = participantId; }
    public void setLectureId(Long lectureId) { this.lectureId = lectureId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public void setStatus(String status) { this.status = status; }
    public void setMemo(String memo) { this.memo = memo; }
}
