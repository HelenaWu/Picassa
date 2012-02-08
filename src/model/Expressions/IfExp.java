package model.Expressions;

import java.util.*;
import model.RGBColor;

public class IfExp extends ParenExpression {

    public IfExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        RGBColor zero = new RGBColor(0, 0, 0);
        RGBColor operand1 = myOperands.get(0).evaluate(x, y, map);
        if (operand1.compareTo(zero) > 0) {
            return myOperands.get(1).evaluate(x, y, map);
        }
        return myOperands.get(2).evaluate(x, y, map);
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return 3;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("if");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new IfExp(operands);
        }
    }
}
