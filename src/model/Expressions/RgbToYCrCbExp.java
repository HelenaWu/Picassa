package model.Expressions;

import java.util.*;
import model.RGBColor;
import model.util.ColorModel;

public class RgbToYCrCbExp extends ParenExpression {
    public RgbToYCrCbExp(List<Expression> operands) {
        super(operands);
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return ColorModel.rgb2ycrcb(myOperands.get(0).evaluate(x, y, map));
    }

    public static class Factory extends ParenExpression.Factory {

        @Override
        protected int numOps() {
            return 1;
        }

        @Override
        protected List<String> validExp() {
            List<String> validExp = new ArrayList<String>();
            validExp.add("RgbToYCrCb");
            validExp.add("rgb2ycrcb");
            return validExp;
        }

        @Override
        protected ParenExpression create(List<Expression> operands) {
            return new RgbToYCrCbExp(operands);
        }
    }
}
