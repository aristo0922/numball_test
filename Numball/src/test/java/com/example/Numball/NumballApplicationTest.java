package com.example.Numball;

import com.example.Numball.domain.NumballQuestion;
import com.example.Numball.domain.NumballQuestionRepository;
import com.example.Numball.domain.Numballs;
import com.example.Numball.domain.NumballsRepository;
import com.example.Numball.web.dto.NumballQuestionRequestDto;
import com.example.Numball.web.dto.NumballsRequestDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class NumballApplicationTest {
    @Autowired
    private NumballsRepository numballsRepository;

    @Autowired
    private NumballQuestionRepository numballQuestionRepository;

    @Test
    void testJpa(){
//        NumballQuestion numballQuestion = new NumballQuestion();
//        String answer = "123";
////        NumballQuestionRequestDto questionRequestDto = NumballQuestionRequestDto.builder().answer(answer).build();
//        NumballQuestionRequestDto numballQuestionDto = NumballQuestionRequestDto.builder().answer(answer).build();
//
//        this.numballQuestionRepository.save(numballQuestionDto);

        Numballs numball1 = new Numballs();
        String myGuess = "234";
        String player = "aristo";

        NumballsRequestDto requestDto = NumballsRequestDto.builder()
                .myGuess(myGuess)
                .player(player)
                .build();
        this.numballsRepository.save(numball1);
    }

}