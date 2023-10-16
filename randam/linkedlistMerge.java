public class linkedlistMerge {

    static Node list1, list2, result; // head of list

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

    public static void sort(Node result , int dt){



    }

    public static void merge(Node list1, Node list2, Node result) {
        Node temp = list1;
        Node ramp = list2;
        // Node re = result;
        if (list1.next == null || list2.next == null) {
            System.out.println("Null list");

        } else {
            while (temp != null && ramp != null) {

                int dt = temp.data;  // 0  3  
                // int dt1 = ramp.data;  // 0  3  
                System.out.println("dt: " + dt);
                // System.out.println("dt1: " + dt1);
                
                while (list1 != null) {
                    int listData = list1.data;
                    System.out.println("inside");
                    if (listData<dt) {
                        dt = listData;
                    
                    }
                    list1 = list1.next;
                }
                
                
                temp = temp.next;
                ramp=ramp.next;

            }
        }
    }

    public static void main(String[] args) {
        Node list1 = new Node();
        Node list2 = new Node();
        Node result = new Node();
        // insert(result, 0);

        insert(list1, 3);
        insert(list1, 10);
        insert(list1, 8);
        insert(list1, 15);
        insert(list1, 45);
        //////////////////////////////////
        insert(list2, 1);
        insert(list2, 21);
        insert(list2, 35);
        insert(list2, 18);
        insert(list2, 5);
        insert(list2, 12);



        printList(list1);
        printList(list2);
        merge(list1, list2,result);
        printList(result);
    }
}
