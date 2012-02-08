package model.Expressions;

import java.util.*;

public class AllOps {
    static List<Expression.Factory> currOps = new ArrayList<Expression.Factory>();

    public static List<Expression.Factory> getOps() {
        currOps.add(new NumberExpression.Factory());
        currOps.add(new VariableExpression.Factory());

        currOps.add(new PlusExp.Factory());
        currOps.add(new MinusExp.Factory());
        currOps.add(new MulExp.Factory());
        currOps.add(new DivExp.Factory());

        currOps.add(new ModExp.Factory());
        currOps.add(new ExpoExp.Factory());
        currOps.add(new NegExp.Factory());
        currOps.add(new ColorExp.Factory());

        currOps.add(new LetExp.Factory());
        currOps.add(new IfExp.Factory());

        currOps.add(new SumExp.Factory());
        currOps.add(new ProdExp.Factory());
        currOps.add(new AvgExp.Factory());
        currOps.add(new MinExp.Factory());
        currOps.add(new MaxExp.Factory());

        currOps.add(new RandExp.Factory());
        currOps.add(new FloorExp.Factory());
        currOps.add(new CeilExp.Factory());
        currOps.add(new AbsExp.Factory());
        currOps.add(new ClampExp.Factory());
        currOps.add(new WrapExp.Factory());
        currOps.add(new SinExp.Factory());
        currOps.add(new CosExp.Factory());
        currOps.add(new TanExp.Factory());
        currOps.add(new ATanExp.Factory());
        currOps.add(new LogExp.Factory());
        currOps.add(new RgbToYCrCbExp.Factory());
        currOps.add(new YCrCbtoRGBExp.Factory());
        currOps.add(new PerlinColorExp.Factory());
        currOps.add(new PerlinBWExp.Factory());

        return currOps;
    }
}
