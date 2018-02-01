package com.techfirebase.daa.ds.advance_ds.tree;

import java.util.Scanner;

/**
 * @author VIVEK KUMAR SINGH
 * @since 30-01-2018
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n*************(((Binary Search Tree)))*************\n\n\n");

        Node bst;
        BinarySearchTree.insertData(50);
        BinarySearchTree.insertData(30);
        BinarySearchTree.insertData(20);
        BinarySearchTree.insertData(40);
        BinarySearchTree.insertData(70);
        BinarySearchTree.insertData(60);
        bst = BinarySearchTree.insertData(80);

        /*
         * Adding more node to use in deletion
         */
        /*BinarySearchTree.insertData(10);
        BinarySearchTree.insertData(25);
        BinarySearchTree.insertData(35);
        bst = BinarySearchTree.insertData(45);*/

        sb.append(bst);

        /*sb.append("\n\n InOrder Traversal in BST :\n");
        System.out.println(sb);
        sb.delete(0, sb.length());

        BinarySearchTree.inOrderTraversal(bst);*/

        Scanner sc = new Scanner(System.in);
        int num;

        /*sb.append("\n\n Enter Key/Data to Search in BST : ");
        System.out.println(sb);
        sb.delete(0, sb.length());

        num = sc.nextInt();

        sb.append("\n Found : ").append(BinarySearchTree.searchData(num));
        System.out.println(sb);
        sb.delete(0, sb.length());*/

        do {
            sb.append("\n\n Enter Key/Data to Delete in BST : ");
            System.out.println(sb);
            sb.delete(0, sb.length());

            num = sc.nextInt();

            bst = BinarySearchTree.deleteData(num);

            sb.append("\n [BST after Delete] : ").append(bst);
            sb.append("\n\n Want to delete more, press 'Y' for yes else input any other to exit : ");

            System.out.println(sb);
            sb.delete(0, sb.length());
        }while (bst != null && sc.next().toUpperCase().charAt(0) == 'Y');
    }
}
