package com.test.breweetristan;

import com.breweetristan.exceptions.DotException;
import com.breweetristan.exceptions.InvalidInputException;
import com.breweetristan.exceptions.InvalidSyntaxException;
import com.breweetristan.exceptions.NoInputException;
import com.breweetristan.io.IOClass;
import org.junit.*;

public class IOClassTests {

    @Test
    public void testInputInvalidCharacters(){
        String inputWithLetters = "ycyjfjyfytc";
        Assert.assertEquals(new InvalidInputException().getMessage(), IOClass.checkInput(inputWithLetters));
    }

    @Test
    public void testInputUnallowedSymbols(){
        String inputWithUnallowedSymbols = "1234=ùµ=";
        Assert.assertEquals(new InvalidInputException().getMessage(), IOClass.checkInput(inputWithUnallowedSymbols));
    }

    @Test
    public void testInputEmpty(){
        String emptyInput = "";
        Assert.assertEquals(new NoInputException().getMessage(), IOClass.checkInput(emptyInput));
    }

    @Test
    public void testOnlyMinus(){
        String onlyMinusAsInput = "-";
        Assert.assertEquals(new InvalidSyntaxException().getMessage(), IOClass.checkInput(onlyMinusAsInput));
    }

    @Test
    public void testToManyDots(){
        String inputWithNumberWithToManyDotsInNumber = "1.2.5";
        Assert.assertEquals(new DotException().getMessage(), IOClass.checkNumberOfDots(inputWithNumberWithToManyDotsInNumber));
    }

    @Test
    public void testTwoSymbolsAfterEachother(){
        String inputWithTwoSymbolsAfterEachother = "123/*456";
        Assert.assertEquals(new InvalidSyntaxException().getMessage(), IOClass.checkInput(inputWithTwoSymbolsAfterEachother));
    }

    @Test
    public void testThreeMinusesAfterEachother(){
        String inputWithThreeMinusSymbolsAfterEachother = "123---456";
        Assert.assertEquals(new InvalidSyntaxException().getMessage(), IOClass.checkInput(inputWithThreeMinusSymbolsAfterEachother));
    }
}
