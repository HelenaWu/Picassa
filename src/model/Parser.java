package model;

import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Expressions.*;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser is
 * used http://en.wikipedia.org/wiki/Recursive_descent_parser
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public class Parser {
    private int myCurrentPosition;
    private String myInput;
    private ArrayList<Expression.Factory> allOperations;

    public Parser() {
        allOperations = new ArrayList<Expression.Factory>();
        allOperations.addAll(AllOps.getOps());
    }

    /**
     * Converts given string into expression tree.
     * 
     * @param input
     *            expression given in the language to be parsed
     * @return expression tree representing the given formula
     */
    public Expression makeExpression(String input) {
        myInput = input;
        Expression result = parseExpression();
        skipWhiteSpace();
        if (notAtEndOfString()) {
            throw new ParserException(
                    "Unexpected characters at end of the string: "
                            + myInput.substring(myCurrentPosition),
                    ParserException.Type.EXTRA_CHARACTERS);
        }
        return result;
    }

    public Expression parseExpression() {
        skipWhiteSpace();
        for (Expression.Factory type : allOperations) {

            if (type.isThisKind(this)) {
                return type.parseExpression(this);
            }
        }
        throw new ParserException("Unparsable expression: "
                + stringAtCurrentPosition());
    }

    public void skipWhiteSpace() {
        while (notAtEndOfString() && Character.isWhitespace(currentCharacter())) {
            myCurrentPosition++;
        }
    }

    public char currentCharacter() {
        return myInput.charAt(myCurrentPosition);
    }

    private boolean notAtEndOfString() {
        return myCurrentPosition < myInput.length();
    }

    public String stringAtCurrentPosition() {
        return myInput.substring(myCurrentPosition);
    }

    public void advanceCurrentPosition(int chars) {
        myCurrentPosition += chars;
    }

}
