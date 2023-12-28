package com.quiz.springquiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.springquiz.Model.Quiz;

public interface Quizdao extends JpaRepository<Quiz, Integer> {
    
}
