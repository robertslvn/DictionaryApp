// File: BinaryTreeBasis.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 24, 2013 

package dataCollections;
import exceptions.*;


public abstract class BinaryTreeBasis<T> {
    protected TreeNode<T> root;
    
    public BinaryTreeBasis(){
        root = null;
    }
    
    public BinaryTreeBasis(T rootItem) {
        root = new TreeNode<T>(rootItem, null, null);
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public void makeEmpty() {
        root = null;
    }
    
    public T getRootItem() throws TreeException {
        if (root == null) {
            throw new TreeException("TreeExceotuibL Empty tree");
                    }
        else {
            return root.item;
            }
    }
    
    public abstract void setRootItem(T newItem);
    
}
