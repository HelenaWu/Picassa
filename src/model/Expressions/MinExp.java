package model.Expressions;

import java.util.*;
import model.RGBColor;

public class MinExp extends ParenExpression {
    public MinExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        RGBColor min = new RGBColor(Double.POSITIVE_INFINITY);
        for (Expression operand : myOperands) {
            RGBColor exp = operand.evaluate(x, y, map);
            if (min.compareTo(exp) > 0) {
                min = exp;
            }
        }
        return min;
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return (int) Double.MAX_VALUE;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("min");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new MinExp(operands);
        }
    }
}