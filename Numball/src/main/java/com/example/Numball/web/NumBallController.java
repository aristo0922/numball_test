package com.example.Numball.web;

import com.example.Numball.service.numball.NumBallService;
import com.example.Numball.web.dto.NumballsRequestDto;
import com.example.Numball.web.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/play")
public class NumBallController {
    private final NumBallService numBallService;

    @PostMapping("/numball")
    public Long save(@RequestBody NumballsRequestDto requestDto){
        return numBallService.save(requestDto);
    }

    @GetMapping("/testResponseBody")
    public ResponseDto<String> testControllerResponseBody(){
        List<String> list = new ArrayList<>();
        list.add("hello this is response Dto");
        ResponseDto<String> response = ResponseDto.<String>builder().data(list).build();
        return response;
    }
}
