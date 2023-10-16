package string;

import java.util.Stack;

public class stackExample {

    public static void main(String[] args) {
        // Create a new stack
        Stack<Character> stack = new Stack<>();

        // Push elements onto the stack
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');

        Character ch = stack.pop();
        System.out.println("ch: " + ch);

        // Pop elements from the stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
