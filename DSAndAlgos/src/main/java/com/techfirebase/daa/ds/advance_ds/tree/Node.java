package com.techfirebase.daa.ds.advance_ds.tree;

/**
 * Structure of a Node in a Tree
 *
 * @author VIVEK KUMAR SINGH
 * @since 27-01-2018
 */
public class Node {
    private int data;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    /**
     * For leaf node
     *
     * @param data value of Node
     */
    public Node(int data) {
        this.data = data;
    }

    /**
     * Root node or intermediate nodes
     *
     * @param data       value of Node
     * @param parent     reference to Parent
     * @param leftChild  reference to leftChild
     * @param rightChild reference to rightChild
     */
    public Node(int data, Node parent, Node leftChild, Node rightChild) {
        this.data = data;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (data != node.data) return false;
        if (!parent.equals(node.parent)) return false;
        if (!leftChild.equals(node.leftChild)) return false;
        return rightChild.equals(node.rightChild);
    }

    @Override
    public int hashCode() {
        int result = data;
        result = 31 * result + parent.hashCode();
        result = 31 * result + leftChild.hashCode();
        result = 31 * result + rightChild.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", parent=" + (parent != null ? String.valueOf(parent.data) : null)+
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
