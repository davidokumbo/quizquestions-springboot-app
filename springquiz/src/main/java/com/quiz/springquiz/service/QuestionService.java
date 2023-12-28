package com.quiz.springquiz.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.springquiz.Model.Question;
import com.quiz.springquiz.dao.Questiondao;

@Service
public class QuestionService {

    @Autowired
    Questiondao mydaoquestions;

    public ResponseEntity<List<Question>> getAllQuestions() {

        return new ResponseEntity<>(mydaoquestions.findAll(), HttpStatus.OK);

        // try {
        //      return new ResponseEntity<>(mydaoquestions.findAll(), HttpStatus.OK);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

   
    public ResponseEntity<List<Question>> getBycategory(String category) {
         return new ResponseEntity<>(mydaoquestions.findByCategory(category), HttpStatus.OK);
        // try {
        //     return new ResponseEntity<>(mydaoquestions.findByCategory(category), HttpStatus.OK);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> addquestion(Question postedquestion) {
        mydaoquestions.save(postedquestion);
        return new ResponseEntity<>("successifully posted",HttpStatus.CREATED);  
        // try {   
        // return new ResponseEntity<>("successifully posted",HttpStatus.CREATED);  
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // return new ResponseEntity<>("data not saved",HttpStatus.BAD_REQUEST); 
    }


    public String deletequestion(Integer deleteid) {
      mydaoquestions.deleteById(deleteid);
    
        return "record deleted successfully";
    }


    public String updatequestion(Question updatequestion) {

        mydaoquestions.save(updatequestion);
        return "record updated successfully";
    }
 
    
}
