package com.incubyte.pilot;

import java.util.regex.Pattern;

public class StringCalculator {

    private int sum(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            String current = number.trim();
            int num = current.isEmpty() ? 0 : Integer.parseInt(current);
            if(num < 0){
                throw new RuntimeException("Negative numbers not allowed " + num);
            }
            if(num > 1000){
                continue;
            }
            sum += current.isEmpty() ? 0 : num;
        }
        return sum;
    }

    private String[] getNumbers(String input){
        String delimiter = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
        if(delimiter.startsWith("[") && delimiter.endsWith("]")){
            delimiter = delimiter.substring(delimiter.indexOf("[") + 1, delimiter.indexOf("]"));
            delimiter = Pattern.quote(delimiter);
        }
        String numbers = input.substring(input.indexOf("\\n") + 2);
        return numbers.split(delimiter);
    }


    public int add(String input){
        if(input.isEmpty()){
            return 0;
        }
        else if(input.length() == 1){
            return input.equals(" ") ? 0 : Integer.parseInt(input);
        }
        else if(input.startsWith("//")){
            String[] array = getNumbers(input);
            return sum(array);
        }
        else{
            String[] array = input.split(",|\\n");
            return sum(array);
        }
    }
}
