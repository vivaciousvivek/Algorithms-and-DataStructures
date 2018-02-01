package com.techfirebase.daa.ds.advance_ds.tree;

/**
 * TC of Every operation in BST is depend upon the height of the BST tree. It can vary from O(logn) to O(n)
 *
 * @author VIVEK KUMAR SINGH
 * @since 30-01-2018
 */
public class BinarySearchTree {
    private static Node node;

    /**
     * Insert data to BST
     *
     * @param data data to insert BST
     */
    public static Node insertData(int data) {
        return node = insertData(node, data);
    }

    /**
     * Insert node recursively by following BST properties
     *
     * @param root BST
     * @param data data to insert BST
     *
     * @return BST after inserting data into its relevant place
     */
    private static Node insertData(Node root, int data) {
        if (root == null) {
            root = new Node(data);

            return root;
        }

        if (data < root.getData())
            root.setLeftChild(insertData(root.getLeftChild(), data));
        else
            root.setRightChild(insertData(root.getRightChild(), data));

        return root;
    }

    /**
     * @param data
     */
    public static Node deleteData(int data) {
        return deleteData(node, data);
    }

    /**
     * Delete have three cases:
     * <p>
     * 1. Node to be deleted is leaf: Simply remove from the tree.
     * <p>
     * 2. Node to be deleted has only one child(either left or right): Copy the child to the node and delete the child
     * <p>
     * 3. Node to be deleted has two children: Find inorder successor/predecessor of the node. Copy contents of the
     * inorder successor/predecessor to the node and delete the inorder successor/predecessor
     *
     * @param root
     * @param data
     *
     * @return
     */
    private static Node deleteData(Node root, int data) {
        /*
         * If tree is empty
         */
        if (root == null)
            return root;

        /*
         * otherwise, recur down the tree
         */
        if (data < root.getData())
            root.setLeftChild(deleteData(root.getLeftChild(), data));
        else if (data > root.getData())
            root.setRightChild(deleteData(root.getRightChild(), data));
        /*
         *if key is same as root's key, then This is the node to be deleted
         */
        else {
            /*
            * node with only one child(either left or right) or no child
            */
            if (root.getLeftChild() == null)
                return root.getRightChild();
            else if (root.getRightChild() == null)
                return root.getLeftChild();
            else {
                /*
                * node with two children
                */

                 /*
                 * We need to find inorder predecessor or successor
                 */
                root.setData(inOrderPredecessor(root));
//                root.setData(inOrderSuccessor(root));

                 /*
                 * delete the inorder predecessor or successor
                 */
                root.setLeftChild(deleteData(root.getLeftChild(), root.getData()));
//                root.setRightChild(deleteData(root.getRightChild(), root.getData()));

                return root;
            }
        }

        return root;
    }

    /**
     * In InOrder Predecessor we need to find the largest/maximum key/data of Left subtree of that data going to be
     * deleted
     * <p>
     * To find this, we need to first go left once, then right till we get the null right child or no right child
     *
     * @param root
     *
     * @return
     */
    public static int inOrderPredecessor(Node root) {
        int predecessor = -1;

        if (root == null)
            return predecessor;

        root = root.getLeftChild();

        while (root != null) {
            predecessor = root.getData();
            root = root.getRightChild();
        }

        return predecessor;
    }

    /**
     * In InOrder Predecessor we need to find the smallest/minimum key/data of Right subtree of that data going to be
     * deleted
     * <p>
     * To find this, we need to first go right once, then left till we get the null left child or no left child
     *
     * @param root
     *
     * @return
     */
    public static int inOrderSuccessor(Node root) {
        int successor = -1;

        if (root == null)
            return successor;

        root = root.getRightChild();

        while (root != null) {
            successor = root.getData();
            root = root.getLeftChild();
        }

        return successor;
    }

    public static boolean searchData(int data) {
        return searchData(node, data);
    }

    /**
     * If the key/data found at root then found is true, If the key/data is greater than the key then search in the
     * right subtree else search in the left subtree
     *
     * @param root BST
     * @param data data to insert BST
     *
     * @return true when found or false when not found
     */
    private static boolean searchData(Node root, int data) {
        if (root == null)
            return false;

        if (data == root.getData())
            return true;
        else if (data < root.getData())
            return searchData(root.getLeftChild(), data);
        else
            return searchData(root.getRightChild(), data);
    }

    /**
     * Left Root Right
     * <p>
     * InOrder Traversal of BST will give the sorted sequence
     *
     * @param binarySearchTree
     */
    public static void inOrderTraversal(Node binarySearchTree) {
        if (binarySearchTree == null)
            return;

        inOrderTraversal(binarySearchTree.getLeftChild());
        System.out.print(" " + binarySearchTree.getData() + " => ");
        inOrderTraversal(binarySearchTree.getRightChild());
    }
}
