package LinkedList;

public class circulerLL {
    static class node {
        int data;
        node next;
        node prev;

        node(int dt) {
            this.data = dt;
            this.next = null;
            // this.prev = null;
        }
    }

    public static node head;
    public static node tail;

    // add
    public void add(int dt) {
        node newNode = new node(dt);

        // head == null
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            return;
        }

        else {
            // tail will point to new node.
            tail.next = newNode;
            // New node will become new tail.
            tail = newNode;
            // Since, it is circular linked list tail will point to head.
            tail.next = head;
        }

    }

    // print cll
    public void print() {
        node curr = head;
        while (curr != null) {
            System.out.print(" -> " + curr.data);
            curr = curr.next;
        }
        System.out.println(" null");
    }

    public static void main(String[] args) {
        circulerLL cll = new circulerLL();

        cll.add(5);
        cll.add(4);
        cll.add(3);
        cll.add(2);
        cll.add(1);
        cll.print();
        System.out.println(head.data);
        System.out.println(tail.data);
    }
}
