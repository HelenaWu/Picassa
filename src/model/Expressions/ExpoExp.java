package model.Expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class ExpoExp extends ParenExpression {
    public ExpoExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return ColorCombinations.exponent(
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
            validExp.add("exp");
            validExp.add("exponent");

            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new ExpoExp(operands);
        }
    }
}