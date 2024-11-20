package fr.ensicaen.ecole.calculator.model.expression;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

public class TestExpressionValidator {
    
    private void addOperators(Set<Character> list) {
        list.add('+');
        list.add('-');
        list.add('*');
        list.add('/');
    }

    private void addNumbers(Set<Character> list) {
        for (char c = '0'; c <= '9'; c++) {
            list.add(c);
        }
    }

    @Test
    public void getPossibleNextCharacters_test() {
        ExpressionValidator validator = new ExpressionValidator();

        for(String expression : new String[]{"", "       ", " ", "        "}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addNumbers(expected);
            expected.add('(');
            expected.add('-');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  1", "1  ", " 2 ", "3", "4","5","6", "7", "8", "9", "0"}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addNumbers(expected);
            addOperators(expected);
            expected.add('.');
            expected.add('=');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  (1", "(1  ", " (2 ", "(3", "(4","(5","(6", "(7", "(8", "(9", "(0"}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addNumbers(expected);
            addOperators(expected);
            expected.add('.');
            expected.add(')');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  (1)", "(1)  ", " (2) ", "(3)", "(4)","(5)","(6)", "(7)", "(8)", "(9)", "(0)"}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addOperators(expected);
            expected.add('=');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  (1)+", "(1)/  ", " (2)- ", "(3)*", "(4)+","(5)*","(6)-", "(7)/", "(8)+", "(9)*", "(0)*"}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addNumbers(expected);
            expected.add('(');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  (1)+(", "(1)/(  ", " (2)-( ", "(3)*(", "(4)+("}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addNumbers(expected);
            expected.add('(');
            expected.add('-');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  (1)+(22", "(1)/(2212  ", " (2)-(1514 ", "(3)*(132412", "(4)+(241421"}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addNumbers(expected);
            addOperators(expected);
            expected.add(')');
            expected.add('.');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  (1)+(22.", "(1)/(2212.  ", " (2)-(1514. ", "(3)*(132412.", "(4)+(241421."}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addNumbers(expected);
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  (1)+(22.0", "(1)/(2212.32  ", " (2)-(1514.1421 ", "(3)*(132412.22", "(4)+(241421.01"}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addNumbers(expected);
            addOperators(expected);
            expected.add(')');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  (1)+(22.0-", "(1)/(2212.32+  ", " (2)-(1514.1421/ ", "(3)*(132412.22*", "(4)+(241421.01+"}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addNumbers(expected);
            expected.add('(');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  (1)+(22.0-13.2", "(1)/(2212.32+1.1  ", " (2)-(1514.1421/1.1"}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addNumbers(expected);
            addOperators(expected);
            expected.add(')');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  (1)+(22.0-13.2)", "(1)/(2212.32+1.1)  ", " (2)-(1514.1421/1.1)"}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addOperators(expected);
            expected.add('=');
            assertEquals(expected, actual);
        }

        for(String expression : new String[] {"  ((1)+(22.0-13.2)", "((1)/(2212.32+1.1)  ", "((2)-(1514.1421/1.1)"}) {
            Set<Character> actual = validator.getPossibleNextCharacters(expression);
            Set<Character> expected = new HashSet<>();
            addOperators(expected);
            expected.add(')');
            assertEquals(expected, actual);
        }

        String expression = "-";
        Set<Character> actual = validator.getPossibleNextCharacters(expression);
        Set<Character> expected = new HashSet<>();
        addNumbers(expected);
        expected.add('(');
        assertEquals(expected, actual);
    }
}