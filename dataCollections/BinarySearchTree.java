// File: BinarySearchTree.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 24, 2013 

package dataCollections;
import app.KeyedItem;
import exceptions.*;
import java.util.Arrays;
import interfaces.*;

public class BinarySearchTree<T extends KeyedItem<KT>, KT extends Comparable<? super KT>> extends BinaryTreeBasis<T>  {
    
    public BinarySearchTree(){
        }
    
    public BinarySearchTree(T rootItem) {
        super(rootItem);
        }
    
    public void setRootItem(T newItem) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
    
    public void insert(T newItem) {
        root = insertItem(root, newItem);
        }
    public T retrieve(KT searchKey) {
        return retrieveItem(root, searchKey);
        }
    
    
    public boolean delete(KT searchKey) throws TreeException {
        boolean bool = true;
        try {
        root = deleteItem(root, searchKey); }
         catch (TreeException e) {
            System.out.println("That item is not in the collection.");
            bool = false;}
        return bool;
        }
 
    
    public String displayall(BinarySearchTree tree) {
       TreeIterator<T> treeIterator = new TreeIterator<T>(tree);
       treeIterator.setPreorder();
       int count = 0;
       while (treeIterator.hasNext()) {
            count = count + 1;
            treeIterator.next();
            }
        String[] temparray = new String[count];
        
        treeIterator = new TreeIterator<T>(tree);
        treeIterator.setPreorder();
        String tempeng;
        int i = 0;
        while (treeIterator.hasNext()) {
           tempeng = (String)treeIterator.next().getKey();
           temparray[i] = tempeng;
           i = i+1;
            }
        
        treeIterator = new TreeIterator<T>(tree);
        treeIterator.setPreorder();
        String tempklin;
        i = 0;
        while (treeIterator.hasNext()) {
           tempklin = (String)treeIterator.next().getKling();
           temparray[i] = temparray[i] + ":" + tempklin;
           i = i+1;
            }
        
        String fin = "";
        String newline = System.getProperty("line.separator");
        Arrays.sort(temparray);
        for (int k = 0; k < count; k++) {
            fin = fin + temparray[k] + newline;
        }
        return fin;
        }
    
    protected TreeNode<T> insertItem(TreeNode<T> tNode, T newItem) {
        TreeNode<T> newSubtree;
        if (tNode == null) {
            tNode = new TreeNode<T>(newItem, null, null);
            return tNode;
                }
        T nodeItem = tNode.item;
        
        if (newItem.getKey().compareTo(nodeItem.getKey()) < 0) {
            newSubtree = insertItem(tNode.leftChild, newItem);
            tNode.leftChild = newSubtree;
            return tNode;
            }
        else {
            newSubtree = insertItem(tNode.rightChild, newItem);
            tNode.rightChild = newSubtree;
            return tNode;
            }
        
                
        }
    
    protected T retrieveItem(TreeNode<T> tNode, KT searchKey) {
        T treeItem;
        if (tNode == null) {
            treeItem = null;
            }
        else {
            T nodeItem = tNode.item;
            if (searchKey.compareTo(nodeItem.getKey()) == 0) {
                treeItem = tNode.item;
                }
            else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
                treeItem = retrieveItem(tNode.leftChild, searchKey);
                  }
            else {
                treeItem = retrieveItem(tNode.rightChild, searchKey);
                } 
              }
        return treeItem;    
        }
    
    protected TreeNode<T> deleteItem(TreeNode<T> tNode, KT searchKey) {
        TreeNode<T> newSubtree;
        if (tNode == null) {
            throw new TreeException("TreeException: Item not found");
            }
        
        else {
            T nodeItem = tNode.item;
            if (searchKey.compareTo(nodeItem.getKey()) == 0) {
                tNode = deleteNode(tNode);
            }
            else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
                newSubtree = deleteItem(tNode.leftChild, searchKey);
                tNode.leftChild = newSubtree;
            }
            else {
                newSubtree = deleteItem(tNode.rightChild, searchKey);
                tNode.rightChild = newSubtree;
            }
            }
        return tNode;
        }
    
    protected TreeNode<T> deleteNode(TreeNode<T> tNode) {
        T replacementItem;
        
        if ( (tNode.leftChild == null) && (tNode.rightChild == null)) {
            return null;
            }
        
        else if (tNode.leftChild == null) {
            return tNode.rightChild;
            }
        else if (tNode.rightChild == null) {
            return tNode.leftChild;
            }
        else {
            replacementItem = findLeftmost(tNode.rightChild);
            tNode.item = replacementItem;
        tNode.rightChild = deleteLeftmost(tNode.rightChild);
        return tNode;
        }
    }
    
    protected T findLeftmost(TreeNode<T> tNode) {
        if (tNode.leftChild == null) {
            return tNode.item;
            }
        else {
            return findLeftmost(tNode.leftChild);
    }
    }
    
    protected TreeNode<T> deleteLeftmost(TreeNode<T> tNode) {
        if (tNode.leftChild == null) {
            return tNode.rightChild;
            }
        else {
            tNode.leftChild = deleteLeftmost(tNode.leftChild);
            return tNode;
        }
    }
    
    
}
