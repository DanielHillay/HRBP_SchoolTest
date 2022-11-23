package com.assessment.testschool.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Scores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scoreId;
    private double score;
    private Long studentId;
    private String subject;
    private String schoolTerm;
    private String termId;

}
