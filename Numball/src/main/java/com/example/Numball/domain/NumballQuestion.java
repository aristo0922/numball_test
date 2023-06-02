package com.example.Numball.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NumballQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String answer;

//    @OneToMany(mappedBy = "numballQuestion", cascade = CascadeType.REMOVE)
//    private List<Numballs> answerList;

    private LocalDateTime createDate;

    @Builder
    public NumballQuestion(String answer){
        this.answer = answer;
    }


}
