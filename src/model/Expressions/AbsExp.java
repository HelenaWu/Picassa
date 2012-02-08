package model.Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class AbsExp extends ParenExpression {

    public AbsExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return ColorCombinations
                .absolute(myOperands.get(0).evaluate(x, y, map));
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return 1;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("abs");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new AbsExp(operands);
        }
    }
}
