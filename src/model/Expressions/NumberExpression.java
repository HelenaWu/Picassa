package model.Expressions;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.*;

public class NumberExpression extends Expression {

    private RGBColor myColor;

    public NumberExpression(RGBColor gray) {
        this.myColor = gray;
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        return myColor;
    }

    public static class Factory extends Expression.Factory {

        private static final Pattern DOUBLE_REGEX = Pattern
                .compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\-?\\.[0-9]+)");

        @Override
        public boolean isThisKind(Parser parser) {
            return regexMatches(DOUBLE_REGEX, parser);
        }

        @Override
        public Expression parseExpression(Parser parser) {
            String input = parser.stringAtCurrentPosition();
            Matcher doubleMatcher = DOUBLE_REGEX.matcher(input);
            doubleMatcher.find(0);
            String numberMatch = input.substring(doubleMatcher.start(),
                    doubleMatcher.end());
            parser.advanceCurrentPosition(numberMatch.length());
            // this represents the color gray of the given intensity
            double value = Double.parseDouble(numberMatch);
            RGBColor gray = new RGBColor(value);
            return new NumberExpression(gray);
        }

    }

}
