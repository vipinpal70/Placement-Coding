package StacksQueue;

import java.util.Queue;
import java.util.LinkedList;

public class ImpStackUsingQueue {

    private Queue<Integer> q;

    public ImpStackUsingQueue() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        for (int i = 1; i < q.size(); i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        ImpStackUsingQueue ss = new ImpStackUsingQueue();
        ss.push(10);
        ss.push(20);
        ss.push(30);
        ss.push(40);
        int param_2 = ss.pop();
        System.out.println("param_2: " + param_2);
        int param_3 = ss.top();
        System.out.println("param_3: " + param_3);
        boolean param_4 = ss.empty();
        System.out.println("param_4: " + param_4);
    }
}