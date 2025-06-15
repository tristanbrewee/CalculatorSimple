package com.test.breweetristan;

import com.breweetristan.exceptions.InvalidInputException;
import com.breweetristan.io.IOClass;
import org.junit.*;

public class IOClassTests {

    private String inputWithLetters = "ycyjfjyfytc";
    private String inputWithUnallowedSymbols = "1234=ùµ=";
    private String emptyInput = "";
    private String onlyMinusAsInput = "-";
    private String inputWithNumberWithToManyDotsInNumberOne = "1.2.5+5";
    private String inputWithNumberWithToManyDotsInNumberTwo = "6+2.5.6";
    private String InputWithTwoSymbolsAfterEachother = "123/*456";
    private String InputWithThreeMinusSymbolsAfterEachother = "123---456";

    @Test
    public void checkInputInvalidCharacters(){
        Assert.assertEquals(new InvalidInputException().getMessage(), IOClass.checkInput(inputWithLetters));
    }

    @Test
    public void checkInputUnallowedSymbols(){
        Assert.assertEquals(new InvalidInputException().getMessage(), IOClass.checkInput(inputWithUnallowedSymbols));
    }
}
