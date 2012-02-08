package model.Expressions;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Parser;
import model.RGBColor;

public class VariableExpression extends Expression {

    private String myVar;

    public VariableExpression(String var) {
        this.myVar = var;
    }

    @Override
    public RGBColor evaluate(double x, double y, Map<String, RGBColor> map) {
        if (map.containsKey(this.myVar)) {
            return map.get(this.myVar);
        } else {
            throw new NullPointerException(
                    "Variable has not been assigned a value. Do something about it!");
        }
    }

    public String getVarName() {
        return this.myVar;
    }

    public static class Factory extends Expression.Factory {

        private static final Pattern VARIABLE_REGEX = Pattern
                .compile("([a-zA-Z]+)");

        @Override
        public boolean isThisKind(Parser parser) {
            Matcher expMatcher = VARIABLE_REGEX.matcher(parser
                    .stringAtCurrentPosition());
            return expMatcher.lookingAt();
        }

        @Override
        public Expression parseExpression(Parser parser) {
            String input = parser.stringAtCurrentPosition();
            Matcher varMatcher = VARIABLE_REGEX.matcher(input);
            varMatcher.find(0);
            String numberMatch = input.substring(varMatcher.start(),
                    varMatcher.end());
            parser.advanceCurrentPosition(numberMatch.length());
            String commandName = varMatcher.group(1);
            return new VariableExpression(commandName);
        }
    }
}
