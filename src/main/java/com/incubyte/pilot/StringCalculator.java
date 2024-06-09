package com.incubyte.pilot;

public class StringCalculator {

    public int add(String input){
        if(input.isEmpty()){
            return 0;
        }
        else if(input.length() == 1){
            return input.equals(" ") ? 0 : Integer.parseInt(input);
        }
        return -1;
    }
}
