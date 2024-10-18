package com.example.kbcgame.repository;

import com.example.kbcgame.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}