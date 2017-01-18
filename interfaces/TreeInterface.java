// File: TreeInterface.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 24, 2013 

package interfaces;

import dataCollections.*;
import app.*;
import exceptions.TreeException;


public interface TreeInterface<T extends KeyedItem<KT>, KT extends Comparable<? super KT>>   {

	//Description: inserts element into a binary search tree whose items have distinct search keys that differ from newItem's search key
	public void insert(T element);
	//Precondition: none
	//Postcondition: "element" has been added to the tree.
        
	//Description: deletes from a binary search tree the item whose search key equals searchKey. If no such item exists, the operation fails and throws treeException
	public boolean delete(KT searchKey) throws TreeException;
	//Precondition: none
	//Postcondition: If "element" is found in the tree, it is deleted from the tree. Returns true if deletion was successful.
	//If "element" is not found in the list, an exception is thrown. 
	//Exception: Throws TreeException if element is not found in the tree
        
	//Description: Returns the item in a binary search tree whose search key equals searchKey. Returns null if no such item exists
	public T retrieve(KT element) ;
	//Precondition: none
	//Postcondition: If "element" is found in the tree, it is returned but not deleted from the tree.
        
        //Description: returns all item in the tree in alphabetical order
        public String displayall(BinarySearchTree tree);
        //Precondition: none
        //Postcondition: Returns a string of the alphabetically sorted (by english name) list of the items in the tree
        
        public String toString( );
	// Postcondition: concatenates the value of the object's 
	// data members into a string and return this string.

	

} //End of TreeInterface
