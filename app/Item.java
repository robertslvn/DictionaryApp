// File: Item.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 24, 2013 

package app;

import interfaces.*;

public class Item extends KeyedItem<String>   {


    // data members
    protected String engName;                      
    protected String klingName;                   

    // method members
    
    // Description: Create an object Item.
    public Item( String nameeng, String nameklin)
    // Precondition: none
    // Postcondition: A new Item is created with the given names
    {
        super(nameeng, nameklin);
        engName = nameeng;
        klingName = nameklin;
        
    }

    // Getters   
    // Description: Returns the English name.
    public String getEngName( )
    {
    	return engName;
    } 

    // Description: Returns the Klingon name.
    public String getKlingName( )
    {
    	return klingName;
    }
    
    //Setters
    // Description: Sets the English name.
    public void setEngName(String name )
    {
    	engName = name;
        return;     
    } 

    // Description: Sets the Klingon name
    public void setKlingName( String name )
    {
    	klingName = name;
        return;
    } 

    
    public String toString( )    
    // Postcondition: concatenate the value of the object's 
    //                data members into a string and return this string.
    {
        return( " " + engName + ":" + klingName + " ");

    }


} // end of Item class

