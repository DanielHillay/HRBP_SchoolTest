package com.assessment.testschool.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClassB2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long classId;

    private static final String SUBJECT_ONE = "Mathematics";
    private static final String SUBJECT_TWO = "English";
    private static final String SUBJECT_THREE = "Drawing";
    private static final String SUBJECT_FOUR = "Music";
    private static final String SUBJECT_FIVE = "Painting";
    private static final String SUBJECT_SIX = "Accounting";

    private static final int totalNoOfSubjects =  6;
    private static final int numberOfStudents = 10;
}
