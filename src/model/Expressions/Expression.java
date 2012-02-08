package model.Expressions;

import java.util.*;
import java.util.regex.*;
import model.Parser;
import model.RGBColor;

/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical functions and the
 * leaves represent constant values.
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 */
public abstract class Expression {

    public abstract RGBColor evaluate(double x, double y,
            Map<String, RGBColor> map);

    public static abstract class Factory {

        public abstract boolean isThisKind(Parser parser);

        public abstract Expression parseExpression(Parser parser);


        protected boolean regexMatches(Pattern regex, Parser parser) {
            Matcher expMatcher = regex
                    .matcher(parser.stringAtCurrentPosition());
            return expMatcher.lookingAt();
        }
    }
}