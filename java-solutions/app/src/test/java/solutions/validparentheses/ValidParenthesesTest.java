package solutions.validparentheses;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

    private ValidParentheses validParentheses = new ValidParentheses();

    @Test
    void testIsValid() {
        String parentTheses = "()";
        assertTrue(validParentheses.isValid(parentTheses));

        String brackets = "[]";
        assertTrue(validParentheses.isValid(brackets));

        String curlyBrackets = "{}";
        assertTrue(validParentheses.isValid(curlyBrackets));
    }

    @Test
    void testMultiple() {
        String multipleValid = "()[]{}";
        assertTrue(validParentheses.isValid(multipleValid));
    }

    @Test
    void testSimpleInvalid() {
        String simpleInvalid = "(]";
        assertFalse(validParentheses.isValid(simpleInvalid));
    }

    @Test
    void testSingle() {
        String singleInvalid = "[";
        assertFalse(validParentheses.isValid(singleInvalid));
    }

    @Test
    void testMultipleOpening() {
        String multipleOpening = "((";
        assertFalse(validParentheses.isValid(multipleOpening));
    }

    @Test
    void testInvalid() {
        String one = "(){}}{";
        assertFalse(validParentheses.isValid(one));
    }

}
