package com.example.Numball.service.numball;

import java.util.Scanner;

public class TrialService {
    static String answer="1234";
    public static boolean getNumball(String guess){
        if(answer.equals(guess)){
            System.out.println(" you are right! ");
            return true;
        } else{
            System.out.println(" Try again! ");
            System.out.println(getResult(answer, guess));
            return false;
        }
    }

    // 스트라이크 판정
    public static String getResult(String answer, String guess){
        int strikeNum=0;
        int ballNum=0;

        String[] answerArray = answer.split("");
        String[] guessArray = guess.split("");
        for(int i=0;i<answerArray.length;i++){
            if(answerArray[i].equals(guessArray[i])){
                strikeNum++;
                continue;
            }
            for(int j=0; j<answerArray.length;j++){
                if(i!=j){
                    if(answerArray[i].equals(guessArray[j])){
                        ballNum++;
                        continue;
                    }
                }
            }
        }

        return "result >> strike: "+strikeNum+" ball: "+ballNum;
    }

    public static void RunGame(){
        Scanner scan = new Scanner(System.in);
        String guess ;
        while(true){
            System.out.println("입력값 >> ");
            guess = scan.nextLine();

            if(getNumball(guess)){
                break;
            }
        }
    }

    public static void main(String[] args){
        RunGame();

    }

}
