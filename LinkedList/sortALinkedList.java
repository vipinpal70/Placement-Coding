package LinkedList;

/*
 * Sort a linked list of 0s, 1s and 2s
 */

public class sortALinkedList {

    static class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    public static void sortLL(node head) {
        int[] freq = new int[3];
        node temp = head;
        node temp2 = head;
        while (temp != null) {
            freq[temp.val]++;
            temp = temp.next;
        }

        int idx = 0;

        while (head != null) {

            if (freq[idx] == 0) {
                idx++;
            }
            head.val = idx;
            freq[idx]--;
            head = head.next;
        }
        // printing ll
        System.out.println();

        while (temp2 != null) {
            System.out.print(temp2.val + " ---> ");
            temp2 = temp2.next;
        }

        System.out.println();
        System.out.println();

    }

    public static void multiplicationLL(node list1, node list2) {
        String str1 = "";
        String str2 = "";
        while (list1 != null) {
            str1 = str1 + list1.val;
            list1 = list1.next;
        }
        while (list2 != null) {
            str2 = str2 + list2.val;
            list2 = list2.next;
        }

        int result = Integer.parseInt(str1) * Integer.parseInt(str2);
        System.out.println("--->  " + result);
        // return result;
    }

    public static node removeNthFromEnd(node head, int n) {

        if (head == null) {
            return null;
        }
        if (head.next == null && n == 1) {
            return null;
        }

        int count = 0;
        int total = 0;
        node prev = head;
        node curr = head;
        while (curr != null) {
            total++;
            curr = curr.next;
        }
        if (total == n) {
            head = head.next;
            return head;
        }
        
        while (count < (total - n - 1)) {
            prev = prev.next;
           
            count++;

        }

        prev.next = prev.next.next;

        return head;
    }

    public static void main(String[] args) {

        node start = new node(19);
        start.next = new node(17);
        start.next.next = new node(16);

        // node start2 = new node(8);
        // start2.next = new node(4);
        // start.next.next = new node(1);

        start.next.next.next = new node(12);
        start.next.next.next.next = new node(10);
        start.next.next.next.next.next = new node(8);
        start.next.next.next.next.next.next = new node(3);

        // sortLL(start);
        // multiplicationLL(start, start2);

        // node prt = start;
        // while (prt != null) {
        //     System.out.print("---> " + prt.val);
        //     prt = prt.next;
        // }
        // System.out.println();
        // System.out.println();
        // node ll = removeNthFromEnd(start, 2);
        // System.out.println("remove : "+ll.val);

        // node prt1 = start;
        // while (prt1 != null) {
        //     System.out.print("---> " + prt1.val);
        //     prt1 = prt1.next;
        // }
        // System.out.println();
        // System.out.println();
    }
}
