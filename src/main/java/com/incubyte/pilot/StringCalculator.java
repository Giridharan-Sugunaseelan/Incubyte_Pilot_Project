package com.incubyte.pilot;

public class StringCalculator {

    private int sum(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            String current = number.trim();
            int num = current.isEmpty() ? 0 : Integer.parseInt(current);
            if(num < 0){
                throw new RuntimeException("Negative numbers not allowed " + num);
            }
            sum += current.isEmpty() ? 0 : num;
        }
        return sum;
    }

    public int add(String input){
        if(input.isEmpty()){
            return 0;
        }
        else if(input.length() == 1){
            return input.equals(" ") ? 0 : Integer.parseInt(input);
        }
        else if(input.startsWith("//")){
            int index = input.indexOf("//");
            int nextLineIndex = input.indexOf("\\n") + 2;
            String delimiter = input.substring(index + 2, nextLineIndex - 2);
            String numbers = input.substring(nextLineIndex);
            String[] array = numbers.split(delimiter);
            return sum(array);
        }
        else{
            String[] array = input.split(",|\\n");
            return sum(array);
        }
    }
}
