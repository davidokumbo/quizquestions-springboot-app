package com.quiz.springquiz.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.quiz.springquiz.Model.Question;


@Repository
public interface Questiondao extends JpaRepository<Question, Integer>{

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM Question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)

     List<Question> findRandomQuestionsByCategory(String category, int numQ);
   
} 
