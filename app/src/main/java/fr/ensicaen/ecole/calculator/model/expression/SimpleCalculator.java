package fr.ensicaen.ecole.calculator.model.expression;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.License;

public class SimpleCalculator implements Calculator {
    @SuppressWarnings("unused")
    final private static boolean license = License.iConfirmNonCommercialUse("Kalash Abdulaziz");

    @Override
    public double calculate(String expressionStr) {
        Expression expression = new Expression(expressionStr);
        if(!expression.checkSyntax()) return Double.NaN;
        return expression.calculate();
    }
}
