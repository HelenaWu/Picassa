package model.Expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class RandExp extends ParenExpression {

    public RandExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return ColorCombinations.random();
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return 0;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("random");
            validExp.add("rand");

            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new RandExp(operands);
        }
    }

}
