package com.example.Numball.service.numball;

import com.example.Numball.domain.NumballQuestion;
import com.example.Numball.domain.NumballQuestionRepository;
import com.example.Numball.domain.NumballsRepository;
import com.example.Numball.web.dto.NumballQuestionRequestDto;
import com.example.Numball.web.dto.NumballsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NumBallService {
    private final NumballsRepository numballsRepository;
    private NumballQuestionRepository numballQuestionRepository;

    @Transactional
    public Long save(NumballsRequestDto requestDto){
        return numballsRepository.save(requestDto.toEntity()).getId();
    }

//    @Transactional
//    public Long start(NumballQuestionRepository requestDto){
//        return numballQuestionRepository.save(requestDto.toEntity()).getId();
//    }
    public List<NumballQuestion> getList(){
        return this.numballQuestionRepository.findAll();
    }

}
