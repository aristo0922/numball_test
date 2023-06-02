package com.example.Numball.web;

import com.example.Numball.domain.NumballQuestion;
import com.example.Numball.service.numball.NumBallService;
import com.example.Numball.web.dto.NumballsRequestDto;
import com.example.Numball.web.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/play")
public class NumBallController {
    private final NumBallService numBallService;


    @GetMapping("/numball")
    public String start_game(){
        // 랜덤으로 문제 세팅
        String question = "1234";
        NumballQuestion.builder().answer(question).build();
        return "hello Numball Controller";
    }

    @GetMapping("/numball/list")
    public String list(Model model){
        List<NumballQuestion> questionList = this.numBallService.getList();
        model.addAttribute("questionList", questionList);
        return "Question_List";
    }
    @PostMapping("/numball")
    @ResponseBody
    public ArrayList<NumballsRequestDto> save(@RequestBody NumballsRequestDto requestDto){
        //문제 맞추는 시도
        ArrayList<NumballsRequestDto> playlist = new ArrayList<>();
        playlist.add(requestDto);
        numBallService.save(requestDto);
        return playlist;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");
        ResponseDto<String> response = ResponseDto.<String>builder().data(list).build();
        // http status를 400로 설정.
        return ResponseEntity.badRequest().body(response);
    }
}
