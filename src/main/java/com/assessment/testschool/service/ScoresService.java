package com.assessment.testschool.service;


import com.assessment.testschool.entity.Scores;
import com.assessment.testschool.entity.StandardRequest;
import com.assessment.testschool.entity.StandardResponse;
import com.assessment.testschool.repository.ScoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoresService {

    @Autowired
    ScoresRepo scoresRepo;
    public ResponseEntity<StandardResponse> getAllScores() {

        try {
            List<Scores> allScores = scoresRepo.findAll();
            return StandardResponse.sendHttpResponse(true, "Operation was successful", allScores, "200");
        }catch(Exception e){
            return StandardResponse.sendHttpResponse(false, "Could not get all student scores");
        }
    }

    public ResponseEntity<StandardResponse> getScoresByStudentId(Long studentId) {
        try{
            List<Scores> studentScores = scoresRepo.findByStudentId(studentId);
            return StandardResponse.sendHttpResponse(true, "Operation was successful", studentScores, "200");
        }catch(Exception e){
            return StandardResponse.sendHttpResponse(false, "Could not get student scores");
        }
    }

    public ResponseEntity<StandardResponse> getStudentScoresBySubject(String subject, Long studentId) {
        List<Scores> subjectScores = new ArrayList<>();
        try{
            List<Scores> scores = scoresRepo.findByStudentId(studentId);
            for(Scores s : scores){
                if(s.getSubject().equalsIgnoreCase(subject)){
                    subjectScores.add(s);
                }
            }
            return StandardResponse.sendHttpResponse(true, "Operation was successful", subjectScores, "200");
        }catch(Exception e){
            System.out.println(e.getMessage());
            return StandardResponse.sendHttpResponse(false, "Could not complete operation");
        }
    }

    public ResponseEntity<StandardResponse> getAllScoresByTerm(String termId){
        try {
            List<Scores> termScores = scoresRepo.findByTermId(termId);
            return StandardResponse.sendHttpResponse(true, "Operation was successful", termScores, "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not complete operations");
        }
    }

    public ResponseEntity<StandardResponse> getScoresByTermAndSubject(StandardRequest termSubject) {
        List<Scores> termSubjectList =  new ArrayList<>();
        try {
            List<Scores> termScores = scoresRepo.findByTermId(termSubject.getTermId());
            for(Scores s : termScores){
                if(s.getSubject().equalsIgnoreCase(termSubject.getSubject())){
                    termSubjectList.add(s);
                }
            }
            calculateAverage(termSubjectList);
            return StandardResponse.sendHttpResponse(true, "Operation was successful", termSubjectList, "200");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return StandardResponse.sendHttpResponse(false, "Could not complete operation");
        }
    }

    public double calculateAverage(List<Scores> scores){
        double x = 0;
        int n = scores.size();
        for(Scores s : scores){
            x = x + s.getScore();
        }
        return x/n;
    }
}
