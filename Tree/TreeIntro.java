package Tree;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

/*
 * Introduction to Tree data structures
 */

public class TreeIntro {

    static class Tree {
        int data;
        Tree right;
        Tree left;

        Tree(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }

    }

    static Tree root;

    // Inorder Traversal
    public static void printInorder(Tree root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print("--> " + root.data);
        printInorder(root.right);
    }

    // Preorder Traversal
    public static void printPreorder(Tree root) {
        if (root == null) {
            return;
        }
        System.out.print("--> " + root.data + "");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // postorder Traversal
    public static void printPostOrder(Tree root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print("--> " + root.data + "");
    }

    // Level Order Treversal
    public static List<List<Integer>> levelOrder(Tree root) {
        Queue<Tree> qu = new LinkedList<Tree>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();

        if (root == null) {
            return list;
        }
        qu.offer(root);
        while (!qu.isEmpty()) {
            int levelNUM = qu.size();
            System.out.println("levelNUM: " + levelNUM);
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNUM; i++) {
                if (qu.peek().left != null)
                    qu.offer(qu.peek().left);
                if (qu.peek().right != null)
                    qu.offer(qu.peek().right);

                subList.add(qu.poll().data);

            }
            list.add(subList);
        }
        System.out.println(list);
        return list;
    }

    // height of the tree
    public static int getHeight(Tree root) {

        if (root == null) {
            return 0;
        }

        int lh = getHeight(root.left);
        int rH = getHeight(root.right);

        return 1 + Math.max(lh, rH);
    }


    // Check for Balanced Binary Tree
    public static Boolean checkBalance(Tree root) {

        if (root == null)
            return true;

        int lh = getHeight(root.left);
        int rH = getHeight(root.right);

        if (Math.abs(rH - lh) > 1)
            return false;

        Boolean left = checkBalance(root.left);
        Boolean right = checkBalance(root.right);

        if (!left || !right)
            return false;

        return true;
    }

//Diameter calculation

    public static void main(String[] args) {

        System.out.println("");

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);
        // printInorder(root);
        // System.out.println();
        // printPreorder(root);
        // System.out.println();
        // printPostOrder(root); 
        System.out.println();
        System.out.println();
        levelOrder(root);

        // int height = getHeight(root);
        // System.out.println("height: " + height);

        // System.out.println(checkBalance(root));

    }
}
