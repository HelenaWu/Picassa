package model.Expressions;

import java.util.*;
import model.RGBColor;

public class MaxExp extends ParenExpression {
    public MaxExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        RGBColor max = new RGBColor();
        for (Expression operand : myOperands) {
            RGBColor exp = operand.evaluate(x, y, map);
            if (max.compareTo(exp) < 0) {
                max = exp;
            }
        }
        return max;
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return (int) Double.MAX_VALUE;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("max");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new MaxExp(operands);
        }
    }
}