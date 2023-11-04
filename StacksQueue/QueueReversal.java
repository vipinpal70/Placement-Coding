package StacksQueue;

import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class QueueReversal {
    public static Queue<Integer> QReversal(Queue<Integer> qq) {
        Stack<Integer> res = new Stack<>();
        Queue<Integer> ans = new LinkedList<>();
        while (!qq.isEmpty()) {
            res.add(qq.remove());
        }
        while(!res.isEmpty()){
            ans.add(res.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        Queue<Integer> qq = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();
        qq.add(10);
        qq.add(20);
        qq.add(30);
        qq.add(40);
        qq.add(50);
        qq.add(60);
        Iterator<Integer> itr = qq.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + "-->");
        }
        System.out.println();
        System.out.println();

        ans = QReversal(qq);
        Iterator<Integer> itr2 = ans.iterator();
        while (itr2.hasNext()) {
            System.out.print(itr2.next() + "-->");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
