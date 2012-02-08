package model.Expressions;

import java.util.*;

import model.RGBColor;

public class LetExp extends ParenExpression {

    public LetExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        map.put(((VariableExpression) myOperands.get(0)).getVarName(),
                myOperands.get(1).evaluate(x, y, map));
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
            validExp.add("let");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {

            return new LetExp(operands);
        }

    }
}
