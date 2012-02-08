package model.Expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class ProdExp extends ParenExpression {

    public ProdExp(List<Expression> operands) {
        super(operands);
    }

    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        RGBColor product = new RGBColor();
        for (Expression operand : myOperands) {
            RGBColor exp = operand.evaluate(x, y, map);
            product = ColorCombinations.multiply(product, exp);
        }
        return product;
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return (int) Double.MAX_VALUE;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("product");
            validExp.add("prod");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new ProdExp(operands);
        }

    }
}
