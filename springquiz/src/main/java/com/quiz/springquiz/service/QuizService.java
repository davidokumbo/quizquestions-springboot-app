package com.quiz.springquiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.quiz.springquiz.Model.Question;
import com.quiz.springquiz.Model.QuestionWrapper;
import com.quiz.springquiz.Model.Quiz;
import com.quiz.springquiz.Model.Response;
import com.quiz.springquiz.dao.Questiondao;
import com.quiz.springquiz.dao.Quizdao;

@Service
public class QuizService {

    @Autowired
    Quizdao quizdao;
    @Autowired
    Questiondao questiondao;

    public ResponseEntity<String> createquiz(String category, int numQ, String title) {

        List<Question> questions = questiondao.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);

        return new ResponseEntity<>("quiz created successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getquizquestions(Integer id) {

        Optional<Quiz> quiz = quizdao.findById(id);
        List<Question> quizQuestionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> quizQuestionsForUser = new ArrayList<>();

        for (Question q : quizQuestionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestiontitle(), q.getOption1(), q.getOption2(),
                    q.getOption3(), q.getOption4());
            quizQuestionsForUser.add(qw);
        }

        return new ResponseEntity<>(quizQuestionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        Quiz quiz = quizdao.findById(id).get();
        List<Question> quizquestions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for (Response response : responses) {
            if (response.getResponse().equals(quizquestions.get(i).getRightanswer()))
                right++;

            i++;

        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }

    public ResponseEntity<String> deletequiz(Integer id) {
        quizdao.deleteById(id);

        return new ResponseEntity<>("quiz deleted successifully",HttpStatus.OK);
    }

   

  

}
