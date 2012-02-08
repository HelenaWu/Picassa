package model.Expressions;

import java.util.*;
import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinColorExp extends ParenExpression {
    public PerlinColorExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return PerlinNoise.colorNoise(myOperands.get(0).evaluate(x, y, map),
                myOperands.get(1).evaluate(x, y, map));
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return 2;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("perlinColor");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new PerlinColorExp(operands);
        }
    }
}