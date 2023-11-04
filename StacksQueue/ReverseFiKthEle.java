package StacksQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;


/*
* Reverse First K elements of Queue
*/

public class ReverseFiKthEle {
 
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Deque<Integer> temp=new ArrayDeque<>();
        while(k!=0){
            temp.push(q.poll());
            k--;
        }
        Queue<Integer> res=new ArrayDeque<>();
        while(!temp.isEmpty()){
            res.offer(temp.pop());
        }
        while(!q.isEmpty()){
            res.offer(q.poll());
        }
        return res;
    }

    public static void main(String[] args) {

        
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        int k = 3;

        ans = modifyQueue(queue, k);

        Iterator<Integer> it = ans.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
