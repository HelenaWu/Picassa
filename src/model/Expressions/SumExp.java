package model.Expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class SumExp extends ParenExpression {

    public SumExp(List<Expression> operands) {
        super(operands);
    }

    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        RGBColor sum = new RGBColor();
        for (Expression operand : myOperands) {
            RGBColor exp = operand.evaluate(x, y, map);
            sum = ColorCombinations.add(sum, exp);
        }
        return sum;

    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return (int) Double.MAX_VALUE;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("sum");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new SumExp(operands);
        }

    }
}
