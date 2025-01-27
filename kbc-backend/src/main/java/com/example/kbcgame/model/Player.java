package com.example.kbcgame.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data 
@Entity
public class Player { 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    private String name; 
    private boolean isCorrect;
}