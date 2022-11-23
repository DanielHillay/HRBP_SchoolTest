package com.assessment.testschool.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class SchoolTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long termId;
    private Date startDate;
    private Date endDate;
}
