package com.quiz.springquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.springquiz.Model.Question;
import com.quiz.springquiz.Model.QuestionWrapper;
import com.quiz.springquiz.Model.Response;
import com.quiz.springquiz.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {


@Autowired
QuizService quizservice;

    @PostMapping("create")
    public ResponseEntity<String> createquiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizservice.createquiz(category,numQ,title) ;
    }

    @GetMapping("get/{id}")
   public ResponseEntity<List<QuestionWrapper>> getquizquestions(@PathVariable Integer id){
    return quizservice.getquizquestions(id);
   }

   @PostMapping("result/{id}")
    public ResponseEntity<Integer> calculateResult(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizservice.calculateResult(id, responses);

    }

    
}
