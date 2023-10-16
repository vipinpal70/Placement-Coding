package LinkedList;

import java.util.LinkedList;

public class JfcLinkedList {


    public static void main(String[] args) {
        // create
        LinkedList<Integer> ll = new LinkedList<>();

        // add
        ll.add(11);
        ll.add(12);
        ll.addFirst(10);
        ll.addLast(13);

        //printing linked list
        System.out.println(ll);
        
        //remove 
        ll.removeFirst();
        ll.removeLast();
        
        //printing linked list
        System.out.println(ll);
    }
}
