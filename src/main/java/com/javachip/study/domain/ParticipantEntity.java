package com.javachip.study.domain;

//Participant 도메인 객체(DB)
//데이터베이스와 매칭하기 위한 클래스
//생성자 주입 사용

public class ParticipantEntity {
    private String participantId;
    private String lectureId;
    private String studentId;
    private String status;
    private String memo;

    public ParticipantEntity(String participantId, String lectureId, String studentId, String status, String memo) {
        this.participantId = participantId;
        this.lectureId = lectureId;
        this.studentId = studentId;
        this.status = status;
        this.memo = memo;
    }

    public String getParticipantId() { return participantId; }
    public String getLectureId() { return lectureId; }
    public String getStudentId() { return studentId; }
    public String getStatus() { return status; }
    public String getMemo() { return memo; }

    public void setParticipantId(String participantId) { this.participantId = participantId; }
    public void setLectureId(String lectureId) { this.lectureId = lectureId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setStatus(String status) { this.status = status; }
    public void setMemo(String memo) { this.memo = memo; }
}
