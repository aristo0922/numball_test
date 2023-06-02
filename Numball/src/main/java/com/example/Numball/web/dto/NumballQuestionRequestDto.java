package com.example.Numball.web.dto;

import com.example.Numball.domain.NumballQuestion;
import com.example.Numball.domain.Numballs;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class NumballQuestionRequestDto {
    private String answer;

    @Builder
    public NumballQuestionRequestDto(String answer){
        this.answer = answer;
    }


    public NumballQuestion toEntity(){
        return NumballQuestion.builder()
                .answer(answer)
                .build();
    }
}
