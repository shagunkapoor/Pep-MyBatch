package KJuly19;

import java.util.ArrayList;
import java.util.LinkedList;

public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };


//		int[] arr={50,40,30,20,-1,-1,-1,60,70,80,-1,-1,-1,-1};
        int[] arr = {50, 25, 12, -1, 37, 30, 24, -1, 32, -1, -1, 40, 38, -1, 45, -1, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1};

        BinaryTree bt = new BinaryTree(arr);
        bt.display();
        System.out.println("***********************");
        System.out.println();
//		bt.preorder();
//		bt.postorder();
//		bt.inorder();
//
//		System.out.println(bt.diameter());
//		System.out.println(bt.diameter2());
//
//		System.out.println(bt.iBalanced());
//		System.out.println("BST");
//		System.out.println(bt.BST());
//
//		bt.preorderIterative();
//		System.out.println();
//		bt.inorderIterative();
//		System.out.println();
//		bt.postorderIterative();

        // int[] arr2 = {1, 'a', 'b', 'd', '@', -1, -1, 'e', 'i', 'y', -1, 'z',
        // -1, -1, 'j', 'k', 'm', 't', 'u', 11, -1, -1, 'v',

        // 12, -1, -1, -1, -1, 'n', 'r', -1, 's', 'w', 9, -1, -1,
        // 'x', 7, -1, 8, -1, -1, -1, -1, -1, 'l', 'o', 'p', -1,
        // 'q', -1, -1, -1, -1, -1, -1, 'c', 'f', -1, 'g', -1, -1,
        // -1, 2, 3, -1, 4, 5, -1, 6, -1, -1, -1, -1};
        // BinaryTree bt = new BinaryTree(arr2);
        // bt.display();

        // System.out.println(bt.size());
        // System.out.println(bt.max());
        // System.out.println(bt.height());
        // System.out.println(bt.find(87));
        // System.out.println(bt.nodetorootpath(60));
        // bt.printRootToLeafPathsInRange(150, 250);

        // System.out.println("**************************");
        // System.out.println();
        // bt.removeLeaves();
        // bt.display();

        // bt.printSingleChild();
        // bt.printStepsFar('k', 4);

        // bt.levelOrder();

        // July19

        // printBinaries(15);

        // int[] pre = { 50, 25, 12, 10, 37, 30, 40 };
        // int[] post = { 12, 10, 25, 30, 40, 37, 50 };
        // int[] in = { 12, 25, 10, 50, 30, 37, 40 };
        //
        // BinaryTree bt1 = new BinaryTree(pre, in);
        // System.out.println("********************************");
        // System.out.println();
        // bt1.preorder();
        // bt1.postorder();
        // bt1.inorder();
        // BinaryTree bt2 = new BinaryTree(post, in);
        // bt2.display();
        // System.out.println("********************************");
        // System.out.println();
        // bt2.preorder();
        // bt2.postorder();
        // bt2.inorder();
        // System.out.println(bt2.diameter());

        ArrayList<Integer> leftViewList = bt.leftView(bt.root);
        System.out.println(leftViewList);

    }
    // July 19

    public static void printBinaries(int n) {
        LinkedList<BinaryNode> queue = new LinkedList<>();
        queue.addLast(new BinaryNode(1, "1"));
        for (int i = 0; i < n; i++) {
            BinaryNode rem = queue.removeFirst();
            System.out.println(rem.data + " " + rem.binary);

            queue.addLast(new BinaryNode(2 * rem.data, rem.binary + "0"));
            queue.addLast(new BinaryNode(2 * rem.data + 1, rem.binary + "1"));
        }

    }

    private static class BinaryNode {
        int data;
        String binary;

        public BinaryNode(int data, String binary) {
            this.data = data;
            this.binary = binary;
        }

    }

}
