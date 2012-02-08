package model.Expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class NegExp extends ParenExpression {
    public NegExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return ColorCombinations.negate(myOperands.get(0).evaluate(x, y, map));
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return 1;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("neg");
            validExp.add("!");

            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new NegExp(operands);
        }
    }
}
