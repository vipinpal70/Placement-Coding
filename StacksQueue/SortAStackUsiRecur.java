package StacksQueue;

import java.util.Stack;

/*
 * How to Sort a Stack using Recursion
 */
public class SortAStackUsiRecur {
    public static void sortAStack(Stack<Integer> input, Stack<Integer> output) {

        if (input.isEmpty()) {
            return;
        }

        Stack<Integer> temp = new Stack<Integer>();

        // first element
        if (output.isEmpty()) {
            output.push(input.pop());
        } else {
            int i = input.pop();
            int o = output.peek();

            if (i < o) {
                while (!output.isEmpty() && output.peek() > i) {
                    temp.add(output.pop());

                }
                temp.add(i);
                while (!temp.isEmpty()) {
                    output.push(temp.pop());
                }

            } else {
                output.push(i);
            }
        }
        sortAStack(input, output);

    }

    /* 
     * Second Approach
     */

    // Recursive Method to insert an item x in sorted way
    static void sortedInsert(Stack<Integer> s, int x) {
        // Base case: Either stack is empty or newly
        // inserted item is greater than top (more than all
        // existing)
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }

        // If top is greater, remove the top item and recur
        int temp = s.pop();
        sortedInsert(s, x);

        // Put back the top item removed earlier
        s.push(temp);
    }

    // Method to sort stack
    static void sortStack(Stack<Integer> s) {
        // If stack is not empty
        if (!s.isEmpty()) {
            // Remove the top item
            int x = s.pop();

            // Sort remaining stack
            sortStack(s);

            // Push the top item back in sorted stack
            sortedInsert(s, x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<Integer>();
        Stack<Integer> ans = new Stack<Integer>();
        input.add(30);
        input.add(-5);
        input.add(18);
        input.add(14);
        input.add(-3);

        sortAStack(input, ans);

        // Iterator<Integer> iter = ans.iterator();
        // while (iter.hasNext()) {
        // System.out.println(iter.next());
        // }

        while (!ans.isEmpty()) {
            System.out.println(ans.pop());
        }
        System.out.println();
        System.out.println();

    }
}
