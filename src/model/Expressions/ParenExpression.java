package model.Expressions;

import java.util.*;

import java.util.regex.*;
import javax.swing.*;
import model.*;


public abstract class ParenExpression extends Expression {

    protected List<Expression> myOperands = new ArrayList<Expression>();

    protected ParenExpression(List<Expression> operands) {

        myOperands.addAll(operands);
        for (int i = 0; i < operands.size(); i++) {
            myOperands.set(i, operands.get(i));
        }
    }

    protected ParenExpression() {
    }

    public abstract static class Factory extends Expression.Factory {

        protected abstract int numOps();

        protected abstract List<String> validExp();

        protected abstract ParenExpression create(List<Expression> operands);

        public ParenExpression createParenExpression(List<Expression> operands) {
            if (operands.size() == numOps()) {
                return create(operands);
            }
            if (numOps() == (int) Double.MAX_VALUE) {
                return create(operands);
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Expected " + numOps()
                        + " operands, instead found " + operands.size(),
                        "Input Error", JOptionPane.PLAIN_MESSAGE);

                throw new IllegalArgumentException();

            }
        }

        private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
                .compile("\\(([+\\-*/%\\^!]|[a-zA-Z]+)");

        protected String getCommand(Parser parser) {
            Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(parser
                    .stringAtCurrentPosition());
            expMatcher.find(0);
            return expMatcher.group(1);
        }

        @Override
        public boolean isThisKind(Parser parser) {
            if (!regexMatches(EXPRESSION_BEGIN_REGEX, parser))
                return false;
            for (String exp : validExp()) {
                if (getCommand(parser).equals(exp))
                    return true;
            }
            return false;
        }

        @Override
        public Expression parseExpression(Parser parser) {
            if (!isThisKind(parser)) {
                throw new ParserException("Attempt to parse invalid string");
            }
            parser.advanceCurrentPosition(getCommand(parser).length() + 1);

            List<Expression> operands = new ArrayList<Expression>();
            while (parser.currentCharacter() != ')') {
                operands.add(parser.parseExpression());
            }
            parser.skipWhiteSpace();

            if (parser.currentCharacter() == ')') {

                parser.advanceCurrentPosition(1);

                return createParenExpression(operands);
            } else {
                throw new ParserException(
                        "Expected close paren, instead found "
                                + parser.stringAtCurrentPosition());
            }
        }

    }
}
