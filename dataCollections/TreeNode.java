// File: TreeNode.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 24, 2013 

package dataCollections;

public class TreeNode<T> {
    T item;
    TreeNode<T> leftChild;
    TreeNode<T> rightChild;
    
    public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right) {
        item = newItem;
        leftChild = left;
        rightChild = right;
    }
    
}
