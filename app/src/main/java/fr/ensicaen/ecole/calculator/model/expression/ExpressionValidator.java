package fr.ensicaen.ecole.calculator.model.expression;
import java.util.HashSet;
import java.util.Set;

public class ExpressionValidator {

    public Set<Character> getPossibleNextCharacters(String expression) {
        Set<Character> nextChars = new HashSet<>();

        expression = expression.trim().replace(" ", "");

        if (expression.isEmpty()) {
            addNumbers(nextChars);
            nextChars.add('(');
            nextChars.add('-');
            return nextChars;
        }

        char lastChar = expression.charAt(expression.length() - 1);
        int openParentheses = countOpenParentheses(expression);

        if(lastChar == '.') {
            addNumbers(nextChars);
            return nextChars;
        } else if (Character.isDigit(lastChar) || lastChar == ')') {
            addOperators(nextChars);
            if (openParentheses == 0) nextChars.add('=');
            else if (openParentheses > 0) nextChars.add(')'); 
            if(Character.isDigit(lastChar)) {
                if (!lastNumberContainsDecimal(expression)) {
                    nextChars.add('.'); 
                }
                addNumbers(nextChars);
            }
        } else if (isOperator(lastChar) || lastChar == '(') {
            addNumbers(nextChars);
            nextChars.add('('); 
            if(lastChar == '(') nextChars.add('-');
        } 
        
        return nextChars;
    }

    public boolean isOperator(char c) {
        return "+-/*".indexOf(c) >= 0;
    }

    public void addOperators(Set<Character> list) {
        list.add('+');
        list.add('-');
        list.add('*');
        list.add('/');
    }

    public void addNumbers(Set<Character> list) {
        for (char c = '0'; c <= '9'; c++) {
            list.add(c);
        }
    }

    public int countOpenParentheses(String expression) {
        int balance = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') balance--;
        }
        return balance;
    }

    public boolean lastNumberContainsDecimal(String expression) {
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c == '.') return true; 
            if (!Character.isDigit(c)) break; 
        }
        return false; 
    }

}
