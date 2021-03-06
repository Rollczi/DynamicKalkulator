package dev.rollczi.kalkulator;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class CalculatorServiceTest extends TestCase {

    @Test
    public void testCalculator() {
        CalculatorService service = new CalculatorService();
        
        service.digit(1);
        service.digit(2);
        service.operator(Operator.ADD);
        service.digit(3);
        
        assertEquals(15.0D, service.doubleValue());
    }

    @Test
    public void testCalculator3Numbers() {
        CalculatorService service = new CalculatorService();

        service.digit(1);
        service.digit(2);
        service.operator(Operator.ADD);
        service.digit(3);
        service.operator(Operator.ADD);
        service.digit(5);

        assertEquals(20.0D, service.doubleValue());
    }

    @Test
    public void testCalculator4Numbers() {
        CalculatorService service = new CalculatorService();

        service.digit(1);
        service.digit(2);
        service.operator(Operator.ADD);
        service.digit(3);
        service.operator(Operator.ADD);
        service.digit(5);
        service.operator(Operator.ADD);
        service.digit(5);

        assertEquals(25.0D, service.doubleValue());
    }

    @Test
    public void testCalculatorMultiplyPriority() {
        CalculatorService service = new CalculatorService();

        service.digit(2);
        service.operator(Operator.ADD);
        service.digit(2);
        service.operator(Operator.MULTIPLY);
        service.digit(2);

        assertEquals(6.0D, service.doubleValue());
    }

    @Test
    public void testCalculatorDivide() {
        CalculatorService service = new CalculatorService();

        service.digit(2);
        service.operator(Operator.ADD);
        service.digit(2);
        service.operator(Operator.DIVIDE);
        service.digit(2);

        assertEquals(3.0D, service.doubleValue());
    }

    @Test
    public void testCalculatorDividingWithBrackets() {
        CalculatorService service = new CalculatorService();

        service.openBrackets();
        service.digit(2);
        service.digit(0);
        service.operator(Operator.SUBTRACT);
        service.digit(1);
        service.digit(0);
        service.closeBrackets();
        service.operator(Operator.DIVIDE);
        service.digit(2);

        assertEquals(5.0D, service.doubleValue());
    }

    @Test
    public void testCalculatorAdding() {
        CalculatorService service = new CalculatorService();

        service.openBrackets();
        service.digit(2);
        service.digit(0);
        service.operator(Operator.SUBTRACT);
        service.digit(1);
        service.digit(0);
        service.closeBrackets();
        service.operator(Operator.DIVIDE);
        service.digit(2);

        assertEquals(5.0D, service.doubleValue());
    }

    @Test
    public void testCalculatorDivideByZero() {
        CalculatorService service = new CalculatorService();

        service.digit(2);
        service.operator(Operator.ADD);
        service.digit(2);
        service.operator(Operator.DIVIDE);
        service.digit(0);

        assertEquals(Double.NaN, service.doubleValue());
    }

    @Test
    public void testCalculatorOneDigitInBracket() {
        CalculatorService service = new CalculatorService();

        service.openBrackets();
        service.digit(2);
        service.closeBrackets();
        service.operator(Operator.ADD);
        service.digit(2);
        service.operator(Operator.DIVIDE);
        service.digit(2);

        assertEquals(3.0D, service.doubleValue());
    }

    @Test
    public void testCalculatorMultipleBrackets() {
        CalculatorService service = new CalculatorService();

        service.openBrackets();
        service.openBrackets();
        service.openBrackets();
        service.digit(2);
        service.closeBrackets();
        service.operator(Operator.ADD);
        service.digit(2);
        service.closeBrackets();
        service.operator(Operator.DIVIDE);
        service.digit(2);
        service.closeBrackets();


        assertEquals(2.0D, service.doubleValue());
    }

}