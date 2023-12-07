package solutions.validparentheses;

/**
 * ----
 * problem: 20 - valid parentheses
 * status: completed, beats 98.68% in runtime, beat 41.94% in memory
 * 
 * notes: after submitting my version, I checked submissions of other people and
 * found that an implementation using a stack would be a lot easier and more
 * efficient
 * 
 * ----
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        char[] characters = s.toCharArray();

        // string starting with a closing character or length < 2 is invalid
        if (isClosing(characters[0]) || characters.length < 2) {
            return false;
        }

        int tracker = 0;
        char[] sequence = new char[characters.length];

        for (int i = 0; i < characters.length; i++) {
            if (isOpening(characters[i])) {
                sequence[tracker++] = characters[i];
            } else {
                if (tracker == 0) {
                    return false;
                }
                if (!aClosesB(characters[i], sequence[--tracker])) {
                    return false;
                }
            }
        }

        if (tracker == 0) {
            return true;
        }

        return false;
    }

    /**
     * 
     * example ')' should close '('
     * 
     * @param a the closing character that should close b
     * @param b the character to be closed
     */
    private boolean aClosesB(char a, char b) {

        if (b == '(' && (a == ')')) {
            return true;
        }

        if (b == '{' && (a == '}')) {
            return true;
        }

        if (b == '[' && (a == ']')) {
            return true;
        }

        return false;

    }

    // checks whether the character is an opening character,
    private boolean isOpening(char c) {
        char[] openingCharacters = { '(', '{', '[' };
        for (int i = 0; i < openingCharacters.length; i++) {
            if (c == openingCharacters[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean isClosing(char c) {
        char[] closingCharacters = { ')', '}', ']' };
        for (int i = 0; i < closingCharacters.length; i++) {
            if (c == closingCharacters[i]) {
                return true;
            }
        }
        return false;
    }
}
