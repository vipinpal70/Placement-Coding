package BST;

public class intoBST {
    /**
     * Node
     */
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }

    }

    static Node BuildTree(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = BuildTree(root.left, val);
        } else {
            // right subtree
            root.right = BuildTree(root.right, val);
        }

        return root;

    }

    // inorder traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static Node root = null;

    public static void main(String[] args) {
        int data[] = { 5, 1, 3, 4, 2, 7 };

        for (int i : data) {
            root = BuildTree(root, i);
        }

        System.out.println();
        inorder(root);
        System.out.println();
    }
}
