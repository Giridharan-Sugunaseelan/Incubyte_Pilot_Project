package com.incubyte.pilot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest{

    public static final StringCalculator calculator = new StringCalculator();

    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldReturnNumberOnSingleNumber(){
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void shouldReturnSumOnTwoNumbers(){
        assertEquals(3, calculator.add("1, 2"));
    }

    @Test
    public void shouldReturnSumOnUnknownAmountOfNumbers(){
        assertEquals(6, calculator.add("1, 2, 3"));
    }

    @Test
    public void shouldIdentifyCommaAndNewLine(){
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void shouldSplitBasedOnGivenDelimiter(){
        assertEquals(3, calculator.add("//;\\n1;2"));
    }

    @Test
    public void shouldThrowExceptionForNegativeNumbers(){
        assertThrows(RuntimeException.class, () -> calculator.add("-1,2,-3"));
    }

    @Test
    public void shouldIgnoreNumbersGreaterThan1000(){
        assertEquals(1, calculator.add("1002,1"));
    }

    @Test
    public void shouldUseDelimiterOfAnyLength(){
        assertEquals(24, calculator.add("//[123]\\n712381239"));
    }

    @Test
    public void shouldUseMultipleDelimitersOfAnyLength(){
        assertEquals(6, calculator.add("//[*][%]\\n1*2%3"));
    }
}
