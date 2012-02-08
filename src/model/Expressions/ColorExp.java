package model.Expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class ColorExp extends ParenExpression {

    public ColorExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return ColorCombinations.color(myOperands.get(0).evaluate(x, y, map),
                myOperands.get(1).evaluate(x, y, map), myOperands.get(2)
                        .evaluate(x, y, map));
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return 3;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("color");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new ColorExp(operands);
        }
    }
}
