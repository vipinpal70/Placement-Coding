package LinkedList;

import java.util.HashMap;

public class cloneLL {
    static class node {
        int data;
        node next;
        node arbit;

        node(int dt) {
            this.data = dt;
            this.next = null;
            this.arbit = null;
        }

    }

    public static node clone(node head) {
        // Map to store the mapping of
        // old nodes with new ones
        HashMap<node, node> mp = new HashMap<>();
        node temp, nhead;

        // Duplicate of the first node
        temp = head;
        nhead = new node(temp.data);
        mp.put(temp, nhead);

        // Loop to create duplicates of nodes
        // with only next pointer
        while (temp.next != null) {
            nhead.next = new node(temp.next.data);
            temp = temp.next;
            nhead = nhead.next;
            mp.put(temp, nhead);
        }
        temp = head;

        // Loop to clone the arbit pointers
        while (temp != null) {
            mp.get(temp).arbit = mp.get(temp.arbit);
            temp = temp.next;
        }

        // Return the head of the clone
        return mp.get(head);
    }

    

    public static void main(String[] args) {
        node head = new node(1);
        head.next = new node(2);
        head.next.next = new node(3);
        head.next.next.next = new node(4);
        head.next.next.next.next = new node(5);
        head.arbit = head.next.next; // 1
        head.next.arbit = head; // 2
        head.next.next.arbit = head.next.next.next.next; // 3
        head.next.next.next.arbit = head.next.next; // 4
        head.next.next.next.next.arbit = head.next; // 5

        

    }
}
