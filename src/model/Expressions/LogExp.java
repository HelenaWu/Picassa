package model.Expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class LogExp extends ParenExpression {

    public LogExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return ColorCombinations.log(myOperands.get(0).evaluate(x, y, map));
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return 1;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("log");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new LogExp(operands);
        }
    }
}
