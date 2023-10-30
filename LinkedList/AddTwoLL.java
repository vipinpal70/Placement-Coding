package LinkedList;

public class AddTwoLL {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode head;
    static int c = 0;

    public static void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    public static void additionOfTwoLL(ListNode l1, ListNode l2) {
        // base case
        if (l1 == null) {
            return;
        }

        // recursive kaam

        additionOfTwoLL(l1.next, l2.next);
        int sum = l1.val + l2.val + c;
        if (sum >= 10) {
            int nm = sum % 10;
            addFirst(nm);
            c = sum / 10;
        } else {
            addFirst(sum);
            c = 0;
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(5);
        l.next = new ListNode(6);
        l.next.next = new ListNode(3);

        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(2);

        additionOfTwoLL(l, l2);

        if (c != 0) {
            addFirst(c);
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println(" Null");
    }
}
