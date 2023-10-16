public class linkedlistQues {
    static Node list, list1, list2; // head of list

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

    public static void insert_at_fist(Node head, int dt) {
        Node newNode = new Node(dt);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head.next;
            head.next = newNode;
        }
    }

    public static void Update_node(Node head, int dt) {

        if (head == null) {
            System.out.println("Not :");
        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.data = dt;
        }
    }

    public static void delete_at_first(Node head) {
        if (head == null) {
            System.out.println("Can't delete because :  head==null: ");

        } else {
            Node tr = head.next;
            System.out.println("tr: " + tr); // remove this line
            head = head.next;  
            tr = null;
        }
    }

    public static void reverse(Node temp) {
        int arr[] = new int[4];  
        int i = 0;
        Node cp = new Node();
        while (temp != null) {
            arr[i] = temp.data;  
            i++;  
            temp = temp.next;
        }
        for (int j = i; j > 0; j--) {
            insert(cp, arr[j - 1]);
        }
        list2 = cp;
    }
    public static void printList(Node head) {
        while (head != null) {
            if (head.data != 0) {
                System.out.println(head.data + " : ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        list1 = new Node();
        list2 = new Node();
        // for first list
        list = new Node();
        insert(list, 2);
        insert(list, 1);
        insert(list, 3);
        insert(list, 4);
        insert(list, 5);
        // for list1
        insert(list1, 1);
        insert(list1, 2);
        insert(list1, 3);
        // for list2
        insert(list2, 4);
        insert(list2, 5);
        insert(list2, 6);
        printList(list2);
        System.out.println("After Reverse :");
        reverse(list2);
        printList(list2);

    }
}
