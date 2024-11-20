package fr.ensicaen.ecole.calculator.model.expression;


import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;


public class TestSimpleCalculator {
    final private static Calculator _calculator = new SimpleCalculator();
    final private static String _maxDouble = Double.toString(Double.MAX_VALUE);
    final private static String _minDouble = Double.toString(Double.MIN_VALUE);
    final private static String _maxInteger = Integer.toString(Integer.MAX_VALUE);
    final private static String _minInteger = Integer.toString(Integer.MIN_VALUE);

    @Test
    public void addition_test() {
      assertEquals(6, _calculator.calculate("3 + 3"));
      assertEquals(6, _calculator.calculate("(3 + 3)"));
      assertEquals(6, _calculator.calculate("(3) + (3)"));
      assertEquals(0, _calculator.calculate("(3) + (-3)"));
      assertEquals(0, _calculator.calculate("(-3) + (3)"));
      assertEquals(0, _calculator.calculate("3 + (-3)"));
      assertEquals(0, _calculator.calculate("(3 + (-3))"));
      assertEquals(0.5, _calculator.calculate("0.2 + 0.3"));
      assertEquals(0.5, _calculator.calculate("(0.2 + 0.3)"));
      assertEquals(0.5, _calculator.calculate("(0.2) + (0.3)"));
      assertEquals(-0.1, _calculator.calculate("0.2 + (-0.3)"));
      assertEquals(-0.1, _calculator.calculate("(0.2 + (-0.3))"));
      assertEquals(-0.1, _calculator.calculate("(0.2) + (-0.3)"));
   
      assertEquals(3, _calculator.calculate("1+1+1"));
      assertEquals(3, _calculator.calculate("(1)+(1)+(1)"));
      assertEquals(3, _calculator.calculate("(1+1+1)"));
      double maxDoubleAddition = (new BigDecimal(Double.MAX_VALUE).add(new BigDecimal(1))).doubleValue(); 
      double maxIntAddition = (new BigDecimal(Integer.MAX_VALUE).add(new BigDecimal(1))).doubleValue(); 

      assertEquals(maxDoubleAddition, _calculator.calculate(_maxDouble + "+ 1"));
      assertEquals(maxIntAddition, _calculator.calculate(_maxInteger + "+ 1"));
    }

    @Test
    public void addition_error_test() {
      assertTrue(Double.isNaN(_calculator.calculate("..1 + 2")));
      assertTrue(Double.isNaN(_calculator.calculate("1 +++ 2")));
      assertTrue(Double.isNaN(_calculator.calculate("(1 + 2")));
      assertTrue(Double.isNaN(_calculator.calculate("1 + 2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) + (2")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) + 2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1 + (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("1) + (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) tt+ (2)")));
    }

    @Test
    public void substraction_test() {
      assertEquals(0, _calculator.calculate("3 - 3"));
      assertEquals(0, _calculator.calculate("(3 - 3)"));
      assertEquals(0, _calculator.calculate("(3) - (3)"));
      assertEquals(6, _calculator.calculate("(3) - (-3)"));
      assertEquals(-6, _calculator.calculate("(-3) - (3)"));
      assertEquals(6, _calculator.calculate("3 - (-3)"));
      assertEquals(6, _calculator.calculate("(3 - (-3))"));
      assertEquals(-0.1, _calculator.calculate("0.2 - 0.3"));
      assertEquals(-0.1, _calculator.calculate("(0.2 - 0.3)"));
      assertEquals(-0.1, _calculator.calculate("(0.2) - (0.3)"));
      assertEquals(0.5, _calculator.calculate("0.2 - (-0.3)"));
      assertEquals(0.5, _calculator.calculate("(0.2 - (-0.3))"));
      assertEquals(0.5, _calculator.calculate("(0.2) - (-0.3)"));
   
      assertEquals(-3, _calculator.calculate("-1-1-1"));
      assertEquals(-3, _calculator.calculate("-(1)-(1)-(1)"));
      assertEquals(-3, _calculator.calculate("(-1-1-1)"));
      double minDoubleSubstraction = (new BigDecimal(Double.MIN_VALUE).subtract(new BigDecimal(1))).doubleValue(); 
      double minIntSubstraction = (new BigDecimal(Integer.MIN_VALUE).subtract(new BigDecimal(1))).doubleValue(); 

      assertEquals(minDoubleSubstraction, _calculator.calculate(_minDouble + "- 1"));
      assertEquals(minIntSubstraction, _calculator.calculate(_minInteger + "- 1"));
    }

    @Test
    public void substraction_error_test() {
      assertTrue(Double.isNaN(_calculator.calculate("..1 - 2")));
      assertTrue(Double.isNaN(_calculator.calculate("1 --- 2")));
      assertTrue(Double.isNaN(_calculator.calculate("(1 - 2")));
      assertTrue(Double.isNaN(_calculator.calculate("1 - 2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) - (2")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) - 2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1 - (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("1) - (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) tt- (2)")));
    }

    @Test
    public void multiplication_test() {
      assertEquals(9, _calculator.calculate("3 * 3"));
      assertEquals(9, _calculator.calculate("(3 * 3)"));
      assertEquals(9, _calculator.calculate("(3) * (3)"));
      assertEquals(-9, _calculator.calculate("(3) * (-3)"));
      assertEquals(-9, _calculator.calculate("(-3) * (3)"));
      assertEquals(-9, _calculator.calculate("3 * (-3)"));
      assertEquals(-9, _calculator.calculate("(3 * (-3))"));
      assertEquals(0.1, _calculator.calculate("0.2 * 0.5"));
      assertEquals(0.1, _calculator.calculate("(0.2 * 0.5)"));
      assertEquals(0.1, _calculator.calculate("(0.2) * (0.5)"));
      assertEquals(-0.1, _calculator.calculate("0.2 * (-0.5)"));
      assertEquals(-0.1, _calculator.calculate("(0.2 * (-0.5))"));
      assertEquals(-0.1, _calculator.calculate("(0.2) * (-0.5)"));
   
      assertEquals(-1, _calculator.calculate("-1*1*1"));
      assertEquals(-1, _calculator.calculate("-(1)*(1)*(1)"));
      assertEquals(-1, _calculator.calculate("(-1*1*1)"));

      double maxDouble = (new BigDecimal(Double.MAX_VALUE).multiply(new BigDecimal(3))).doubleValue(); 
      double maxInt = (new BigDecimal(Integer.MAX_VALUE).multiply(new BigDecimal(3))).doubleValue(); 

      assertEquals(maxDouble, _calculator.calculate(_maxDouble + "* 3"));
      assertEquals(maxInt, _calculator.calculate(_maxInteger + "* 3"));
    }

    @Test
    public void multiplication_error_test() {
      assertTrue(Double.isNaN(_calculator.calculate("..1 * 2")));
      assertTrue(Double.isNaN(_calculator.calculate("1 *** 2")));
      assertTrue(Double.isNaN(_calculator.calculate("(1 * 2")));
      assertTrue(Double.isNaN(_calculator.calculate("1 * 2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) * (2")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) * 2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1 * (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("1) * (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) tt* (2)")));
    }

    @Test
    public void division_test() {
      assertEquals(1, _calculator.calculate("3 / 3"));
      assertEquals(1, _calculator.calculate("(3 / 3)"));
      assertEquals(1, _calculator.calculate("(3) / (3)"));
      assertEquals(-1, _calculator.calculate("(3) / (-3)"));
      assertEquals(-1, _calculator.calculate("(-3) / (3)"));
      assertEquals(-1, _calculator.calculate("3 / (-3)"));
      assertEquals(-1, _calculator.calculate("(3 / (-3))"));
      assertEquals(0.4, _calculator.calculate("0.2 / 0.5"));
      assertEquals(0.4, _calculator.calculate("(0.2 / 0.5)"));
      assertEquals(0.4, _calculator.calculate("(0.2) / (0.5)"));
      assertEquals(-0.4, _calculator.calculate("0.2 / (-0.5)"));
      assertEquals(-0.4, _calculator.calculate("(0.2 / (-0.5))"));
      assertEquals(-0.4, _calculator.calculate("(0.2) / (-0.5)"));
   
      assertEquals(-1, _calculator.calculate("-1/1/1"));
      assertEquals(-1, _calculator.calculate("-(1)/(1)/(1)"));
      assertEquals(-1, _calculator.calculate("(-1/1/1)"));

      double maxDouble = (new BigDecimal(Double.MAX_VALUE).divide(new BigDecimal(2))).doubleValue(); 
      double maxInt = (new BigDecimal(Integer.MAX_VALUE).divide(new BigDecimal(2))).doubleValue(); 

      assertEquals(maxDouble, _calculator.calculate(_maxDouble + "/2"));
      assertEquals(maxInt, _calculator.calculate(_maxInteger + "/2"));
    }

    @Test
    public void division_error_test() {
      assertTrue(Double.isNaN(_calculator.calculate("..1 / 2")));
      assertTrue(Double.isNaN(_calculator.calculate("1 /// 2")));
      assertTrue(Double.isNaN(_calculator.calculate("(1 / 2")));
      assertTrue(Double.isNaN(_calculator.calculate("1 / 2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) / (2")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) / 2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1 / (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("1) / (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) tt/ (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("1 / 0")));
      assertTrue(Double.isNaN(_calculator.calculate("1 / (1 - 1)")));
    }
}
