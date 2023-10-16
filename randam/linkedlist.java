public class linkedlist {

	Node head; // head of list

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

	public static void printList(Node head) {
		while (head != null) {
			if (head.data != 0) {

				System.out.println(head.data + " : ");
			}
			head = head.next;
		}
	}

	public static void insert(Node head , int dt){
		Node newNode = new Node(dt);
		if (head == null) {
			head = newNode;
		} else {
			while(head.next!=null){
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

	public static void Insert_at_position(Node head, int pos, int dt) {
		Node newNode = new Node(dt);
		if (head == null) {
			System.out.println("head == null: ");
		} else {
			while (pos > 0) {
				head = head.next;
				pos--;
			}
			newNode.next = head.next;
			head.next = newNode;
		}
	}

	public static void insert_at_end(Node head, int dt) {
		Node newNode = new Node(dt);
		if (head == null) {
			System.out.println("head == null: ");
		} else {
			while (head.next != null) { /// 12 15 18 20 22
				head = head.next;
			}
			head.next = newNode;
		}
	}

	public static void delete_at_first(Node head){
		if(head==null){
			System.out.println("Can't delete because :  head==null: ");

		}
		else{
			head.next = head.next.next;    	
		}
	}


	public static void main(String[] args) {
		linkedlist llist = new linkedlist();
		llist.head = new Node();
		insert_at_fist(llist.head, 11);
		insert_at_fist(llist.head, 15);
		insert_at_fist(llist.head, 17);
		insert_at_fist(llist.head, 19);
		insert_at_fist(llist.head, 21);
		insert_at_fist(llist.head, 25);
		Insert_at_position(llist.head, 4, 100);
		insert_at_end(llist.head, 99);
		delete_at_first(llist.head);
		insert(llist.head, 555);
		printList(llist.head);
	}
}
