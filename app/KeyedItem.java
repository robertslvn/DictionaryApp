// File: KeyedItem.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 24, 2013 

package app;


public abstract class KeyedItem<KT extends Comparable<? super KT>> {
    private KT searchKey;
    private String klingword;
    
    public KeyedItem(KT key, String kling) {
        searchKey = key;
        klingword = kling;
    }
    public KT getKey(){
        return searchKey;
    }
    public String getKling(){
        return klingword;
    }
}
