package com.assessment.testschool.controller;


import com.assessment.testschool.entity.StandardRequest;
import com.assessment.testschool.entity.StandardResponse;
import com.assessment.testschool.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scores/")
public class ScoresController {

    @Autowired
    ScoresService scoresService;

    @GetMapping("/allscores")
    public ResponseEntity<StandardResponse> getAllScores(){
        return scoresService.getAllScores();
    }

    //@GetMapping
    // public ResponseEntity<StandardResponse> getScoreByStudentId(@RequestParam("studentId") String studentId){
    //    return studentService.getScoresByStudentId(studentId);
    //}

    @GetMapping("/scoresbystudent")
    public ResponseEntity<StandardResponse> getScoreByStudentId(@RequestBody StandardRequest studentId){
        return scoresService.getScoresByStudentId(studentId.getStudentId());
    }

    @GetMapping("/scoresbysubject")
    public ResponseEntity<StandardResponse> getStudentScoresBySubject(@RequestBody StandardRequest subjectScore){
        return scoresService.getStudentScoresBySubject(subjectScore.getSubject(), subjectScore.getStudentId());
    }

    //Get all scores for all subject for a given term
    @GetMapping("/scoresbyterm")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<StandardResponse> getAllScoresByTerm(@RequestBody StandardRequest termId){
        return scoresService.getAllScoresByTerm(termId.getTermId());
    }

    @GetMapping("/scoresbytermandsubject")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<StandardResponse> getScoresByTermAndSubject(@RequestBody StandardRequest termSubject){
        return scoresService.getScoresByTermAndSubject(termSubject);
    }

}
