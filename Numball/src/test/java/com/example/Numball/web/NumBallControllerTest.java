package com.example.Numball.web;

import com.example.Numball.domain.Numballs;
import com.example.Numball.domain.NumballsRepository;
import com.example.Numball.web.dto.NumballsRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NumBallControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private NumballsRepository numballsRepository;

    @After
    void tearDown() throws Exception{
        numballsRepository.deleteAll();
    }

    @Test
    public void numball_게임() throws Exception{
        //given
        String myGuess = "123";
        String answer = "1Ball-1Strike";
        String player = "aristo";

        NumballsRequestDto requestDto = NumballsRequestDto.builder()
                .myGuess(myGuess)
                .player(player)
                .build();

        String url = "http://localhost:"+port+"/api/v1/play";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Numballs> all = numballsRepository.findAll();
        assertThat(all.get(0).getAnswer()).isEqualTo(answer);
        assertThat(all.get(0).getPlayer()).isEqualTo(player);



    }


}