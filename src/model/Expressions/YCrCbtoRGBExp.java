package model.Expressions;

import java.util.*;
import model.RGBColor;
import model.util.ColorModel;

public class YCrCbtoRGBExp extends ParenExpression {
    public YCrCbtoRGBExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return ColorModel.ycrcb2rgb(myOperands.get(0).evaluate(x, y, map));
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return 1;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("ycrcb2rgb");
            validExp.add("YCrCbtoRGB");
            validExp.add("yCrCbtoRGB");

            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new YCrCbtoRGBExp(operands);
        }
    }
}