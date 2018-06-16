package com.techfirebase.daa.ds.advance_ds.tree;

import com.techfirebase.daa.utils.constants.Position;

/**
 * @author VIVEK KUMAR SINGH
 * @since 27-01-2018
 */
public class TreeTest {

  public static void main(String[] args) {

    StringBuilder sb = new StringBuilder();

    sb.append("\n*************Binary Tree*************\n");

    /*
     * Root Nodes
     */
    Node rootNode = BinaryTree.createRootNode(1);

    /*
     * Intermediate Nodes
     */
    /*Node leafNode1 = BinaryTree.addNode(2, rootNode, Position.LEFT);

    */
    /*
     * Leaf Nodes
     */
    /*
    BinaryTree.addNode(3, rootNode, Position.RIGHT);
    BinaryTree.addNode(4, leafNode1, Position.LEFT);
    BinaryTree.addNode(5, leafNode1, Position.RIGHT);*/

    // 2nd tree(Left Skew tree)
    /*
     * Intermediate Nodes
     */
    /*Node interNode1 = BinaryTree.addNode(2, rootNode, Position.LEFT);
    Node interNode2 = BinaryTree.addNode(3, interNode1, Position.LEFT);
    Node interNode3 = BinaryTree.addNode(4, interNode2, Position.LEFT);


    // Leaf Nodes

    BinaryTree.addNode(5, interNode3, Position.LEFT);*/

    // 3rd tree(Right Skew tree)
    /*
     * Intermediate Nodes
     */
    /*Node interNode1 = BinaryTree.addNode(2, rootNode, Position.RIGHT);
    Node interNode2 = BinaryTree.addNode(3, interNode1, Position.RIGHT);
    Node interNode3 = BinaryTree.addNode(4, interNode2, Position.RIGHT);

    // Leaf Nodes
    BinaryTree.addNode(5, interNode3, Position.RIGHT);*/

    // 4th tree
    /*
     * Intermediate Nodes
     */
    Node interNode1 = BinaryTree.addNode(2, rootNode, Position.LEFT);
    Node interNode2 = BinaryTree.addNode(3, rootNode, Position.RIGHT);
    BinaryTree.addNode(4, interNode1, Position.LEFT);

    Node interNode3 = BinaryTree.addNode(5, interNode1, Position.RIGHT);
    BinaryTree.addNode(6, interNode3, Position.LEFT);
    BinaryTree.addNode(7, interNode3, Position.RIGHT);

    BinaryTree.addNode(8, interNode2, Position.LEFT);
    BinaryTree.addNode(9, interNode2, Position.RIGHT);

    // Leaf Nodes
    BinaryTree.addNode(5, interNode3, Position.LEFT);

    // 5th tree
    /*Node interNode1 = BinaryTree.addNode(2, rootNode, Position.LEFT);
    Node interNode2 = BinaryTree.addNode(3, rootNode, Position.RIGHT);

    Node interNode3 = BinaryTree.addNode(4, interNode1, Position.LEFT);
    Node interNode4 = BinaryTree.addNode(5, interNode1, Position.RIGHT);
    BinaryTree.addNode(7, interNode3, Position.RIGHT);

    BinaryTree.addNode(6, interNode2, Position.LEFT);*/

    sb.append("\nBinary Tree :\n").append(rootNode);

    /*sb.append("\n\n Height of Binary Tree : ").append(BinaryTree.heightOfBinaryTree(rootNode));
    System.out.println(sb);
    sb.delete(0, sb.length());

    sb.append("\n\n No. of Nodes in Binary Tree : ").append(BinaryTree.nodesInBinaryTree(rootNode));
    System.out.println(sb);
    sb.delete(0, sb.length());*/

    /*sb.append("\n\n Pre Order Traversal of Binary Tree :\n");

    System.out.println(sb);
    sb.delete(0, sb.length());

    BinaryTree.preOrderTraversal(rootNode);

    sb.append("\n\n In Order Traversal of Binary Tree :\n");
    System.out.println(sb);
    sb.delete(0, sb.length());

    BinaryTree.inOrderTraversal(rootNode);

    sb.append("\n\n Post Order Traversal of Binary Tree :\n");
    System.out.println(sb);
    sb.delete(0, sb.length());

    BinaryTree.postOrderTraversal(rootNode);

    sb.append("\n\n Pre Order Traversal of Binary Tree Iteratively :\n");
    System.out.println(sb);
    sb.delete(0, sb.length());

    BinaryTree.preOrderTraversalIterative(rootNode);

    sb.append("\n\n In Order Traversal of Binary Tree Iteratively :\n");
    System.out.println(sb);
    sb.delete(0, sb.length());

    BinaryTree.inOrderTraversalIterative(rootNode);

    sb.append("\n\n Post Order Traversal of Binary Tree Iteratively :\n");
    System.out.println(sb);
    sb.delete(0, sb.length());

    BinaryTree.postOrderTraversalIterative(rootNode);

    sb.append("\n\n Level Order Traversal of Binary Tree :\n");
    System.out.println(sb);
    sb.delete(0, sb.length());

    BinaryTree.levelOrderTraversal(rootNode);*/

    /*sb.append("\n\n Unique Binary Tree from InOrderTraversal and PreOrderTraversal :\n");

            int[] inOrderTraversal;
    //        inOrderTraversal = new int[]{4, 2, 5, 1, 3};
    //        inOrderTraversal = new int[]{1, 2, 3, 4, 5};
            inOrderTraversal = new int[]{5, 4, 3, 2, 1};

            int[] preOrderTraversal;
            preOrderTraversal = new int[]{1, 2, 3, 4, 5};

            sb.append("\n ").append(BinaryTree.uniqueTreeByInAndPreOrder(inOrderTraversal, preOrderTraversal, 0,
                    inOrderTraversal.length - 1));

            sb.append("\n\n Unique Binary Tree from InOrderTraversal and PostOrderTraversal :\n");

            int[] postOrderTraversal;
            postOrderTraversal = new int[]{5, 4, 3, 2, 1};

            BinaryTree.setPostIndex(inOrderTraversal.length);
            sb.append("\n ").append(BinaryTree.uniqueTreeByInAndPostOrder(inOrderTraversal, postOrderTraversal, 0,
                    inOrderTraversal.length - 1));
            System.out.println(sb);
            sb.delete(0, sb.length());*/

  }
}
