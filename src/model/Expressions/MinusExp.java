package model.Expressions;

import java.util.*;
import model.RGBColor;
import model.util.ColorCombinations;

public class MinusExp extends ParenExpression {

    public MinusExp(List<Expression> operands) {
        super(operands);
    }

    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return ColorCombinations.subtract(
                myOperands.get(0).evaluate(x, y, map), myOperands.get(1)
                        .evaluate(x, y, map));

    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return 2;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("-");
            validExp.add("minus");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new MinusExp(operands);
        }

    }
}