package com.test.breweetristan;

import com.breweetristan.calculations.CalculationClass;
import org.junit.*;

public class CalculationClassTests {

    @Test
    public void testAddition(){
        String additionTwoExpected = "1+1.0";
        Assert.assertEquals("2.0", CalculationClass.start(additionTwoExpected));
    }

    @Test
    public void testSubtraction(){
        String subtractionTwoExpected = "5.0-3.0";
        Assert.assertEquals("2.0", CalculationClass.start(subtractionTwoExpected));
    }

    @Test
    public void testMultiplication(){
        String multiplicationTwoExpected = "0.5*4";
        Assert.assertEquals("2.0", CalculationClass.start(multiplicationTwoExpected));
    }

    @Test
    public void testDivision(){
        String divisionTwoExpected = "4/2";
        Assert.assertEquals("2.0", CalculationClass.start(divisionTwoExpected));
    }

    @Test
    public void testComplexCalculation(){
        String complexCalculationTwoExpected = "2+5/2-3*1.5+2";
        Assert.assertEquals("2.0", CalculationClass.start(complexCalculationTwoExpected));
    }
}
