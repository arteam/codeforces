package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task20 {

    public static void main(String[] args) {
        System.out.println(new Task20().isValid("()"));
        System.out.println(new Task20().isValid("()[]{}"));
        System.out.println(new Task20().isValid("(]"));
        System.out.println(new Task20().isValid("([)]"));
        System.out.println(new Task20().isValid("{[]}"));
        System.out.println(new Task20().isValid("["));
        System.out.println(new Task20().isValid("]"));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                char last = stack.isEmpty() ? '\0' : stack.removeLast();
                if (last == '(' && c == ')') {
                    continue;
                }
                if (last == '{' && c == '}') {
                    continue;
                }
                if (last == '[' && c == ']') {
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
