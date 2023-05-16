package com.example.Numball.web.dto;

import com.example.Numball.domain.Numballs;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class NumballsRequestDto {
    private String myGuess;
    private String answer;
    private String player;

    @Builder
    public NumballsRequestDto(String myGuess, String answer, String player){
        this.myGuess = myGuess;
        this.answer = answer;
        this.player = player;
    }

    public Numballs toEntity(){
        return Numballs.builder()
                .myGuess(myGuess)
                .answer(answer)
                .player(player)
                .build();
    }
}
