package com.example.Numball.web.dto;

import com.example.Numball.domain.Numballs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NumballsResponseDto {

    private String myGuess;
    private String player;

    @Builder
    public NumballsResponseDto(String myGuess, String player){
        this.myGuess = myGuess;
        this.player = player;
    }

    public Numballs toEntity(){
        return Numballs.builder()
                .myGuess(myGuess)
                .player(player)
                .build();
    }
}
