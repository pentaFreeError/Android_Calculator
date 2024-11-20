package fr.ensicaen.ecole.calculator.model.expression;

public interface Calculator {
    /**
     * function that calculate a given expression.
     *  
     * @param expression the expression to calculate
     * @return the result or Double.NaN if there is a syntax error
     */
    public double calculate(String expression);     
} 





