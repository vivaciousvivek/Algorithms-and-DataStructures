package com.techfirebase.daa.ds.advance_ds.tree;

import com.techfirebase.daa.utils.constants.Position;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author VIVEK KUMAR SINGH
 * @since 27-01-2018
 */
public class BinaryTree {
    static Node node;

    private BinaryTree() {
    }

    public static Node getNode() {
        return node;
    }

    public static void setNode(Node node) {
        BinaryTree.node = node;
    }

    /**
     * Create Root Node
     *
     * @param data value of Node
     *
     * @return created Node of given data
     */
    public static Node createRootNode(int data) {
        return node = new Node(data);
    }

    /**
     * Adding Node to any Node of Tree
     *
     * @param data       value of Node
     * @param parentNode node of which u want to create children
     * @param position   position of Child of given parent node
     *
     * @return created Node of given data
     */
    public static Node addNode(int data, Node parentNode, Position position) {
        if (parentNode != null && position != null) {
            node = new Node(data);

            if (position == Position.LEFT) {
                if (parentNode.getLeftChild() == null) {
                    parentNode.setLeftChild(node);
                    node.setParent(parentNode);
                } else {
                    // here we need to throw the valid exception
                    System.out.println("LeftChild of " + parentNode + " is already exist");
                    return null;
                }
            }

            if (position == Position.RIGHT) {
                if (parentNode.getRightChild() == null) {
                    parentNode.setRightChild(node);
                    node.setParent(parentNode);
                } else {
                    // here we need to throw the valid exception
                    System.out.println("RightChild of " + parentNode + " is already exist");
                    return null;
                }
            }

            return node;
        } else {
            System.out.println("Parent and Position should not be null");
            return null;
        }
    }

    /**
     * Height of a binary tree could be between logn(minimum height, when tree is complete binary tree) to n-1(maximum
     * height, when tree is skew tree(having one child of every node))
     *
     * @param binaryTree
     *
     * @return
     */
    public static int heightOfBinaryTree(Node binaryTree) {
        /*
         * If tree is empty(i.e don't have left and right child) then there is no height i.e -1
         */
        if (binaryTree == null)
            return -1;
        else {
            /*
             * Get the max depth of left subtree and right subtree recursively and add 1 for the parent(current) node
             */

            return Math.max(heightOfBinaryTree(binaryTree.getLeftChild()),
                    heightOfBinaryTree(binaryTree.getRightChild())) + 1;
        }
    }

    /**
     * @param binaryTree
     *
     * @return Total no. of nodes in Binary tree
     */
    public static int nodesInBinaryTree(Node binaryTree) {
        /*
         * If tree is empty(i.e don't have left and right child) then there is no node
         */
        if (binaryTree == null)
            return 0;
        else {
            /*
             * Get the max depth of left subtree and right subtree recursively and add 1 for the parent(current) node
             */
            return nodesInBinaryTree(binaryTree.getLeftChild()) + nodesInBinaryTree(binaryTree.getRightChild()) + 1;
        }
    }

    /**
     * This comes under the DFS traversal
     * <p>
     * Root Left Right
     *
     * @param binaryTree tree which have 2 children
     */
    public static void preOrderTraversal(Node binaryTree) {
        if (binaryTree == null)
            return;

        System.out.print(" " + binaryTree.getData() + " =>");
        preOrderTraversal(binaryTree.getLeftChild());
        preOrderTraversal(binaryTree.getRightChild());
    }

    /**
     * This comes under the DFS traversal
     * <p>
     * Left Root Right
     *
     * @param binaryTree tree which have 2 children
     */
    public static void inOrderTraversal(Node binaryTree) {
        if (binaryTree == null)
            return;

        inOrderTraversal(binaryTree.getLeftChild());
        System.out.print(" " + binaryTree.getData() + " =>");
        inOrderTraversal(binaryTree.getRightChild());
    }

    /**
     * This comes under the DFS traversal
     * <p>
     * Left Right Root
     *
     * @param binaryTree tree which have 2 children
     */
    public static void postOrderTraversal(Node binaryTree) {
        if (binaryTree == null)
            return;

        postOrderTraversal(binaryTree.getLeftChild());
        postOrderTraversal(binaryTree.getRightChild());
        System.out.print(" " + binaryTree.getData() + " =>");
    }

    /**
     * Level order traversal traverse the tree level by level i.e BFS traversal
     *
     * @param binaryTree
     */
    public static void levelOrderTraversal(Node binaryTree) {

    }

    /**
     * Root Left Right
     *
     * @param binaryTree tree which have 2 children
     */
    public static void preOrderTraversalIterative(Node binaryTree) {
        Stack<Node> binaryTreeStack = new Stack<>();
        binaryTreeStack.push(binaryTree);

        while (!binaryTreeStack.isEmpty()) {
            binaryTree = binaryTreeStack.pop();
            System.out.print(" " + binaryTree.getData() + " =>");

            if (binaryTree.getRightChild() != null)
                binaryTreeStack.push(binaryTree.getRightChild());

            if (binaryTree.getLeftChild() != null) {
                binaryTreeStack.push(binaryTree.getLeftChild());
            }

        }
    }

    /**
     * Left Root Right
     *
     * @param binaryTree tree which have 2 children
     */
    public static void inOrderTraversalIterative(Node binaryTree) {
        Stack<Node> binaryTreeStack = new Stack<>();

        do {
            /*
             * push all the left Nodes of every node till last node i.e left child is null
             */
            while (binaryTree != null) {
                binaryTreeStack.push(binaryTree);
                binaryTree = binaryTree.getLeftChild();
            }

            /**
             * if we reach the last left node i.e there is no more left child and also stack is not empty then pop it
             * and print it and go to parent, get the right child, then again do same steps from starting
             * i.e find the left child till last left child
             */
            if (binaryTree == null && !binaryTreeStack.isEmpty()) {
                binaryTree = binaryTreeStack.pop();

                System.out.print(" " + binaryTree.getData() + " =>");

                binaryTree = binaryTree.getRightChild();
            }

        } while (!binaryTreeStack.isEmpty() || binaryTree != null);

    }

    /**
     * Left Right Root
     *
     * @param binaryTree tree which have 2 children
     */
    public static void postOrderTraversalIterative(Node binaryTree) {
        Stack<Node> binaryTreeStack = new Stack<>();

        do {
            /*
             * push all the left Nodes of every node till last node i.e left child is null
             */
            while (binaryTree != null) {
                binaryTreeStack.push(binaryTree);
                binaryTree = binaryTree.getLeftChild();
            }

            /**
             * if we reach the last left node i.e there is no more left child then pop it and go to its right child, if
             * right child is null then print and dereference it, if stack is not empty then pop its parent and if right
             * child is not empty then traverse right subtree in same manner and disconnect from its parent, so that it
             * can't process again, then again do same steps from starting
             */
            binaryTree = binaryTreeStack.pop();

            if (binaryTree.getRightChild() != null) {
                Node binaryTreeNoRightChild = binaryTree;
                binaryTree = binaryTree.getRightChild();

                binaryTreeNoRightChild.setRightChild(null);
                binaryTreeStack.push(binaryTreeNoRightChild);
            } else {
                System.out.print(" " + binaryTree.getData() + " =>");
                binaryTree = null;
            }

        } while (!binaryTreeStack.isEmpty() || binaryTree != null);
    }

    public static boolean isUniqueTreeByInAndPreOrder(int[] inOrderTraversal, int[] preOrderTraversal, int start,
                                                      int end, int preIndex) {

        if (start > end)
            return false;

        Node newNode = new Node(preOrderTraversal[preIndex++]);

        int inIndex = searchInOrderIndex(inOrderTraversal, start, end, newNode.getData());

        if (start == end)
            return true;

        isUniqueTreeByInAndPreOrder(inOrderTraversal, preOrderTraversal, start, inIndex, preIndex);
        node.setLeftChild(newNode);
        isUniqueTreeByInAndPreOrder(inOrderTraversal, preOrderTraversal, inIndex + 1, end, preIndex);
        node.setRightChild(newNode);

        return false;
    }

    private static int searchInOrderIndex(int[] inOrderTraversal, int start, int end, int preOrderValue) {
        for (int i = start; i < end; i++) {
            if (preOrderValue == inOrderTraversal[i])
                return i;
        }

        return 0;
    }

    public static boolean isUniqueTreeByInAndPostOrder(int[] inOrderTraversal, int[] postOrderTraversal) {

        return false;
    }
}
