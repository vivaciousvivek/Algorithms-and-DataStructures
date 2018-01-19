package com.techfirebase.daa.ds.advance_ds.disjointset;

/**
 * @author VIVEK KUMAR SINGH
 * @since 16-01-2018
 */
public class DisjointSetTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(); 

        sb.append("*************Disjoint Set Test*************\n");
        DisjointSet.makeSet(10);
        sb.append(DisjointSet.printDisjointSet());

        sb.append("\n\n*************(((Relationship(ex: Friendship) between people)))*************\n");

        /**
         * Form Friendship group from friendship data
         * G1 = {0,1,3}
         * G2 = {2,5,7}
         * G3 = {4,6,8}
         * G4 = {9}
         */

        sb.append("\n*************Slow Union-Find*************\n");
        DisjointSet.slowUnion(0, 1);
        DisjointSet.slowUnion(1, 3);
        DisjointSet.slowUnion(2, 5);
        DisjointSet.slowUnion(5, 7);
        DisjointSet.slowUnion(4, 6);
        DisjointSet.slowUnion(6, 8);

        sb.append("\nDisjoint set after slow union\n");
        sb.append(DisjointSet.printDisjointSet());

        // check if 4 is a friend of 0
        sb.append("\n\nslow find of friendship between 4 and 0\n");
        if (DisjointSet.slowFind(4) == DisjointSet.slowFind(0)) {
            sb.append("Yes");
        }
        else {
            sb.append("No");
        }

        // check if 1 is a friend of 0
        sb.append("\n\nslow find of friendship between 1 and 0\n");
        if (DisjointSet.slowFind(1) == DisjointSet.slowFind(0)) {
            sb.append("Yes");
        }
        else {
            sb.append("No");
        }

        sb.append("\n\n*************Fast Union-Find*************\n");
        DisjointSet.makeSet(10);
        sb.append(DisjointSet.printDisjointSet());

        DisjointSet.fastUnion(0, 1);
        DisjointSet.fastUnion(1, 3);
        DisjointSet.fastUnion(2, 5);
        DisjointSet.fastUnion(5, 7);
        DisjointSet.fastUnion(4, 6);
        DisjointSet.fastUnion(6, 8);

        sb.append("\n\nDisjoint set after fast union\n");
        sb.append(DisjointSet.printDisjointSet());

        // check if 4 is a friend of 0
        sb.append("\n\nfast find of friendship between 4 and 0\n");
        if (DisjointSet.fastFind(4) == DisjointSet.fastFind(0)) {
            sb.append("Yes");
        }
        else {
            sb.append("No");
        }

        // need to check because fast find compress the height
        // (i.e it will change the height tree) if it is not directly connected to the root
        sb.append("\n\nDisjoint set after fast find\n");
        sb.append(DisjointSet.printDisjointSet());

        // check if 1 is a friend of 0
        sb.append("\n\nfast find of friendship between 1 and 0\n");
        if (DisjointSet.fastFind(1) == DisjointSet.fastFind(0)) {
            sb.append("Yes");
        }
        else {
            sb.append("No");
        }

        // need to check because fast find compress the height
        // (i.e it will change the height tree) if it is not directly connected to the root
        sb.append("\n\nDisjoint set after fast find\n");
        sb.append(DisjointSet.printDisjointSet());

//        sb.append("\n\n*************Cycle Detection*************\n");
        System.out.println(sb);
        sb.delete(0, sb.length());

    }
}
