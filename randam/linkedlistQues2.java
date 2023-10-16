public class linkedlistQues2 {

    static Node list; // head of list

    static class Node {

        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }

        Node() {
        }; //

    }

    public static void insert(Node head, int dt) {
        Node newNode = new Node(dt);
        if (head == null) {
            head = newNode;
        } else {
            while (head.next != null) {
                head = head.next;
            }

            head.next = newNode;
        }
    }

    public static void printList(Node head) {
        while (head != null) {
            if (head.data != 0) {

                System.out.println(head.data + " : ");
            }
            head = head.next;
        }
    }

    public static void swap(Node head) {
        while (head != null && head.next != null) {
            int temp = head.data;
            head.data = head.next.data;
            head.next.data = temp;
            head = head.next;

        }
    }

    public static void main(String[] args) {
        
        list = new Node();
        insert(list, 1);
        insert(list, 2);
        insert(list, 3);
        insert(list, 4);
        insert(list, 5);
        swap(list);
        printList(list);

    }
}
