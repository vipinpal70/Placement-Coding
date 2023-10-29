package LinkedList;


class ReverseLL {

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

    public static ListNode reverseMethod(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(122);
        ListNode ans = new ListNode();
        l.next = new ListNode(99);
        l.next.next = new ListNode(92);
        l.next.next.next = new ListNode(80);
        l.next.next.next.next = new ListNode(70);
        l.next.next.next.next.next = new ListNode(60);
        l.next.next.next.next.next.next = new ListNode(50);

        ans = reverseMethod(l);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
