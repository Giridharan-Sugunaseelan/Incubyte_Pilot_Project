package com.incubyte.pilot;

public class StringCalculator {

    public int add(String input){
        if(input.isEmpty()){
            return 0;
        }
        else if(input.length() == 1){
            return input.equals(" ") ? 0 : Integer.parseInt(input);
        }
        else{
            int sum = 0;
            String[] array = input.split(",|\\n");
            for(String letter : array){
                String current = letter.trim();
                sum += (current.isEmpty()) ? 0 : Integer.parseInt(current);
            }
            return sum;
        }
    }
}
