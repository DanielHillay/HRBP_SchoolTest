package com.assessment.testschool.entity;

public class StandardRequest {

    private String subject;
    private Long studentId;
    private String classId;
    private String termId;

    public StandardRequest(String subject, Long studentId, String classId, String termId) {
        this.subject = subject;
        this.studentId = studentId;
        this.classId = classId;
        this.termId = termId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }
}
