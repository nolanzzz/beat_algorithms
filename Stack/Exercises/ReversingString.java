package DataStructures.Stack.Exercises;

import java.util.Stack;

public class ReversingString {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(reverseString(str));
    }
    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
