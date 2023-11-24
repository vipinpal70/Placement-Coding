package Tree;
import java.util.Comparator;
public class MirrorTree {
  
    static class node {
        int val;
        node left;
        node right;
    }

    static node createNode(int val) {
        node newNode = new node();
        newNode.val = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    // Helper function to print Inorder traversal
    static void inorder(node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
    }

    static node mirrorify(node root) {
        if (root == null) {
            return null;
        }

        // Create new mirror node from original tree node
        node mirror = createNode(root.val);
        mirror.right = mirrorify(root.left);
        mirror.left = mirrorify(root.right);
        return mirror;
    }

    public static void main(String args[]) {

        node tree = createNode(5);
        tree.left = createNode(3);
        tree.right = createNode(6);
        tree.left.left = createNode(2);
        tree.left.right = createNode(4);

        // Print inorder traversal of the input tree
        System.out.print("Inorder of original tree: ");
        inorder(tree);
        node mirror = null;
        mirror = mirrorify(tree);

        // Print inorder traversal of the mirror tree
        System.out.print("\nInorder of mirror tree: ");
        inorder(mirror);
    }
}

