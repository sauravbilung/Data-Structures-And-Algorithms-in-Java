package dataStructures.stacks;

import java.util.ArrayDeque;

public class _4_ParenthesisMatcher {

    public static boolean isValid(String expression) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : expression.toCharArray()) {
            switch (ch) {
                case '(', '{', '[' -> stack.push(ch);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }
            }
        }

        return stack.isEmpty(); // If stack is empty, all brackets matched
    }

    public static void main(String[] args) {
        String test1 = "{[()]}";    // true
        String test2 = "{[(])}";    // false
        String test3 = "((()))";    // true
        String test4 = "([)]";      // false

        System.out.println(test1 + " --> " + isValid(test1));
        System.out.println(test2 + " --> " + isValid(test2));
        System.out.println(test3 + " --> " + isValid(test3));
        System.out.println(test4 + " --> " + isValid(test4));
    }
}
