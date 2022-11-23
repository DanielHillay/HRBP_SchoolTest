package com.assessment.testschool.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClassA1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long classId;

    private static final String SUBJECT_ONE = "Mathematics";
    private static final String SUBJECT_TWO = "English";
    private static final String SUBJECT_THREE = "Writing";
    private static final String SUBJECT_FOUR = "General Science";

    private static final int totalNoOfSubjects =  4;
    private static final int numberOfStudents = 10;


}
