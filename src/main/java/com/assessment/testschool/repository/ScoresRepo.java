package com.assessment.testschool.repository;

import com.assessment.testschool.entity.Scores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoresRepo extends JpaRepository<Scores, Long> {

    List<Scores> findByStudentId(Long studentId);

    List<Scores> findByTermId(String termId);
}
