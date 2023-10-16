import java.util.Scanner;

public class doublelinked {
    static Node head;
    static class Node {
        int data;
        Node next, prev;
    
        Node(int data){
        this.data = data;
        next = prev = null;
        }
        Node(){};
    }

    public static void insert_At_beg(Node head , int dt){
        Node newNode = new Node(dt);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head.next;    // [h]     [n]       
            head.next = newNode;
            newNode.prev = head;
        }
        System.out.println("Data inserted sucessfully");
    }

    public static void traverse(Node head){
        while(head != null){
            if(head.data != 0){
                System.out.println(head.data);
            }
            head = head.next;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Node list = new Node();
        boolean flag = true;
        int op;
        while(flag){
            System.out.println("Enter 1 to insert node");
            System.out.println("Enter 2 to traverse node");
            System.out.println("Enter 3 to exit");
            System.out.println("");
            op = s.nextInt();
            switch (op) {
                case  1:
                    System.out.println("Enter data into the node");
                    int dt = s.nextInt();
                    insert_At_beg(list, dt); 
                    break;
                case  2:
                    System.out.println("All data :");
                    traverse(list); 
                    break;
                case  3:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        s.close();
    }
    
}
