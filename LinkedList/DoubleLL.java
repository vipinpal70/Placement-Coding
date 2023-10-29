package LinkedList;

public class DoubleLL {
    static class node {
        int data;
        node next;
        node prev;

        node(int val) {
            this.data = val;
            this.next = null;
            this.prev = null;
        }
    }

    public static node head;
    public static node tail;
    public static int size;

    public void add(int dt) {
        // create a new node
        node newNode = new node(dt);
        size++;
        // empty case
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // remove from ddl
    public void removeFirst() {
        if (head == null) {
            System.out.println("Not Possible");
            return;
        } else if (head.next == null) {
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;

    }
    // reverse doubly linked list
    // 3 var and 4 step

    public void reverse() {
        node next;
        node prev = null;
        node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // print dll
    public void print(node head) {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -- ");
            temp = temp.next;
        }
        System.out.println("null\n");
    }

    public static void main(String[] args) {

        DoubleLL dll = new DoubleLL();
        dll.add(5);
        dll.add(4);
        dll.add(3);
        dll.add(2);
        dll.add(1);

        dll.print(head);
        // dll.removeFirst();
        dll.reverse();
        dll.print(head);

    }
}
