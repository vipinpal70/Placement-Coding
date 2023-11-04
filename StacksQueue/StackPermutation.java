package StacksQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Given two arrays, check if one array is
// stack permutation of other.

public class StackPermutation {

    // function to check if input queue is
    // permutable to output queue
    static boolean checkStackPermutation(int ip[], int op[], int n) {
        Queue<Integer> input = new LinkedList<>();

        // Input queue
        for (int i = 0; i < n; i++) {
            input.add(ip[i]);
        }

        // Output queue
        Queue<Integer> output = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            output.add(op[i]);
        }

        // stack to be used for permutation
        Stack<Integer> tempStack = new Stack<>();
        while (!input.isEmpty()) {
            int ele = input.poll();
            System.out.println("ele: " + ele);

            System.out.println("output.peek(): " + output.peek());
            if (ele == output.peek()) {
                output.poll();
                while (!tempStack.isEmpty()) {
                    if (tempStack.peek() == output.peek()) {
                        tempStack.pop();
                        output.poll();
                    } else
                        break;
                }
            } else {
                tempStack.push(ele);
            }
        }

        // If after processing, both input queue and
        // stack are empty then the input queue is
        // permutable otherwise not.
        return (input.isEmpty() && tempStack.isEmpty());
    }

    // Driver code
    public static void main(String[] args) {
        // Input Queue
        int input[] = { 1, 2, 3 };

        // Output Queue
        int output[] = { 2, 1, 3 };
        int n = 3;
        if (checkStackPermutation(input, output, n))
            System.out.println("Yes");
        else
            System.out.println("Not Possible");
    }
}
