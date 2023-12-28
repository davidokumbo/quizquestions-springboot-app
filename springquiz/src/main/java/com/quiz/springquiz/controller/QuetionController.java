package com.quiz.springquiz.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.springquiz.Model.Question;
import com.quiz.springquiz.service.QuestionService;

@RestController
@RequestMapping("questions")
public class QuetionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getquestions() {

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getbycategory(@PathVariable String category) {

        return questionService.getBycategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addquestion(@RequestBody Question postedquestion) {
        return questionService.addquestion(postedquestion);
    }

    @DeleteMapping("delete/{deleteid}")
    public String deletequestion(@PathVariable Integer deleteid) {
        return questionService.deletequestion(deleteid);
    }

    @PutMapping("update/{updateid}")
    public String updatequestion(@PathVariable Integer updateid, @RequestBody Question updatequestion){
        updatequestion.setId(updateid);
        return questionService.updatequestion(updatequestion);
    }

}
