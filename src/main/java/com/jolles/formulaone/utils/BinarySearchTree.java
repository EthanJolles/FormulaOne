package com.jolles.formulaone.utils;

// Java program to demonstrate
// insert operation in binary
// search tree
public class BinarySearchTree {

    private class Node {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        else if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
}

