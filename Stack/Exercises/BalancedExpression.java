/*
  Given a string like: "((1 + 3) * 5)"
  Check to see if it's balanced, i.e., are the opening and closing brackets matched
 */
package DataStructures.Stack.Exercises;

import java.util.Stack;

public class BalancedExpression {
    public static void main(String[] args) {
        String s = "(((1+2+5)*8))";
        System.out.println(check(s));
    }
    public static boolean check(String s) {
        // 1 - go through string, if is a openning bracket, push to stack
        // 2 - skip if it's regular char or space
        // 3 - if it's closing bracket, pop from the stack, check if it's a match
        //     yes -> keep going
        //     no  -> return false
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpenningBracket(c)) {
                stack.push(c);
            }
            else if (isClosingBracket(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (!isMatch(open, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean isOpenningBracket(char c) {
        return c == '(' ||
                c == '[' ||
                c == '{' ||
                c == '<';
    }
    private static boolean isClosingBracket(char c) {
        return c == ')' ||
                c == ']' ||
                c == '}' ||
                c == '>';
    }
    private static boolean isMatch(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}') ||
                (open == '<' && close == '>');
    }
}
