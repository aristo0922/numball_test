package com.example.Numball.service.numball;

import com.example.Numball.domain.NumballsRepository;
import com.example.Numball.web.dto.NumballsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NumBallService {
    private final NumballsRepository numballsRepository;

    @Transactional
    public Long save(NumballsRequestDto requestDto){
        return numballsRepository.save(requestDto.toEntity()).getId();
    }


}
