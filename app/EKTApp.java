// File: EKTApp.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 24, 2013 

package app;

import dataCollections.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import interfaces.*;
import java.util.InputMismatchException;

public class EKTApp {
    Item anItem = new Item("","");      //initialize, will use later
    BinarySearchTree words;             //data collection (tree)
    int numItems;                       //number of items in data collection
       
    //initialize the tree in constructor
    public EKTApp() {
    words = new BinarySearchTree();
     } // end of default constructor
    
    //Gets the input file from the user and tries to open it
    public Scanner getFile() { 
        boolean found = false;
        Scanner fileInput = new Scanner(System.in);
        while (found == false) {
            try {
            Scanner in = new Scanner(System.in); //get file from user
            System.out.println("\nPlease enter the full filepath of the input text file as per the following format - C:\\Users\\user\\Desktop\\Input.txt");
            String fileName = in.nextLine(); //read file name
            
            File inFile = new File(fileName);              
            fileInput = new Scanner(inFile);
            found = true;
            return fileInput;
           }
           catch (FileNotFoundException e) {
           System.out.println("That file cannot be found.");
           } }
        return fileInput;
        }
        
    //reads the input file from the user and places all of its items into the tree    
    public void readFile(Scanner fileInput) {
    
        //read the entire file, use its data to create items, and place those items into the tree
        while (fileInput.hasNext()) {
            String line = fileInput.nextLine();
            StringTokenizer st = new StringTokenizer(line, ":");  
            String engName = (String)st.nextElement();
            String klingName = (String)st.nextElement(); 
            anItem = new Item(engName, klingName);
            words.insert(anItem);
            numItems++;
            }
        //close the file stream
        fileInput.close();
        }

    //initial menu open starting the program    
    private void mainMenu() {
	System.out.print("---------------------------------------------");
        System.out.println("\nWelcome to the English-Klingon Translator");
	System.out.print("---------------------------------------------");	
        return;
                
	}
    
    //main menu of the program. Reads user's input and acts accordingly.
     private int operations() {
            System.out.println("\n-----------------------------------------------");
            System.out.println("\nTranslate English word into Klingon\t- Enter 1");
            System.out.println("Insert a new pair of words\t\t- Enter 2");
            System.out.println("Update an existing pair of words\t- Enter 3");
            System.out.println("Delete an existing pair of words\t- Enter 4" );
            System.out.println("Display all pairs of words in \n" +
            " English alphabetical sort order\t- Enter 5" );
            System.out.println("Exit \t\t\t\t\t- Enter 6" );
            System.out.println("\n------------------------------------------------");
            boolean valid = false;
            int userSelection = 6;
            
            //gets a valid input selection from the user (number from 1 to 6)
            while (valid == false) {
                try {
                System.out.println("\nSelect menu option: ");
                Scanner userinput = new Scanner(System.in);
                userSelection = userinput.nextInt();
                if (userSelection == 1 || userSelection == 2 || userSelection == 3 || userSelection == 4 || userSelection == 5 || userSelection == 6) {
                    valid = true;}
                else {
                System.out.println("That number is not in the menu!");}
                }
                catch (InputMismatchException e) {
                    System.out.println("\nPlease input a valid number.");
                     } 
            }
            return userSelection; 
            
     }
     //method to retrieve a Klingon word from the english word that the user inputs
     private void retrieve() throws NullPointerException {
     
         //if there are no words in the collection run this
        if (numItems == 0) {
        System.out.println("There are no words in the collection!");}
        
        else {
            
            try {
            Scanner userinput = new Scanner(System.in);
            System.out.println("\nPlease enter the English word to be translated");   //get the englishh word from user
            String selection = userinput.nextLine();
            System.out.println("The Klingon translation of " + words.retrieve(selection).getKey()+ " is: " + words.retrieve(selection).getKling());}  //translate
            catch (NullPointerException e) {
            System.out.println("\nThat word does not exist in the collection");
     }
      
     } }
     
     //insert a word into the tree, based on the users selection. Asks for english word and its translation frm user
     private void insert()  {
     Scanner userinput = new Scanner(System.in);
     System.out.println("Please enter the english version of the word to be inserted");
     String eword = userinput.nextLine();
     
     //only insert the word if it doesnt already exist in the collection
     if (words.retrieve(eword) == null) {    
        System.out.println("Please enter the klingon version of the word to be inserted");
        String kword = userinput.nextLine();
        anItem = new Item(eword, kword);
        words.insert(anItem);
        numItems++;
        System.out.println("\nItem has been added successfully!"); }
     else { 
        System.out.println("That word is already in the collection, please use the update tool to change it!");
     }
     
     }
     
     //ask the user for an english word, gives the translation, and asks the user for both the updated english and klingon words.
     private void update() throws NullPointerException {
     
         //make sure there are words in the collection
     if (numItems == 0) {
        System.out.println("There are no words in the collection!");}
        else {
     
     try {
     Scanner userinput = new Scanner(System.in);
     System.out.println("Please enter the english version of the word to be updated");
     String eword = userinput.nextLine();
     System.out.println("The Klingon translation of " + words.retrieve(eword).getKey()+ " is: " + words.retrieve(eword).getKling());
     System.out.println("Enter the updated english word");
     String neweword = userinput.nextLine();
     System.out.println("Enter the updated klingon word");
     String kword = userinput.nextLine();
     anItem = new Item(neweword, kword);
     
     //make sure word was deleted successfully
     if (words.delete(eword) == true) {
        System.out.println("Updated successfully!");}
     words.insert(anItem);
     }
     catch (NullPointerException e) {
        System.out.println("That word does not exist in the collection.");}
      } }
     
     
     //delete an item from the tree based on the key (the english word) which is given by the user
     private void delete() throws NullPointerException  {
     if (numItems == 0) {
        System.out.println("There are no words in the collection!");}
        else {
     try {
     Scanner userinput = new Scanner(System.in);
     System.out.println("Please enter the english version of the word to be deleted");
     String eword = userinput.nextLine();
     
     //make sure word was deleted successfully
     if (words.delete(eword) == true) {
     System.out.println("Item deleted successfully!");
     numItems = numItems -1;}
      }
     catch (NullPointerException e) {
         System.out.println("That word does not exist in the collection");
     }
     
      } }
     
     //display all the words in the collection by alphabetical order
     private void display()  {
        //make sure there are words in the collection
        if (numItems == 0) {
        System.out.println("There are no words in the collection!");}
       
        else {
        System.out.println("\nThe following is an alphabetical list of all words and their translation: ");
        System.out.println(words.displayall(words)); }
     }
         
    //main method
    public static void main(String[] args) {
    
    EKTApp theApp = new EKTApp();  //create new theApp object
    theApp.mainMenu();              // prints the initial menu
    Scanner goodFile = theApp.getFile();  //get the input file from user
    theApp.readFile(goodFile);          //read the input file
    int userSelection = 7;
    while (userSelection == 7) {       
    userSelection = theApp.operations(); //get a valid operations choice from the user
    }
     
		while (userSelection != 6) {
			switch (userSelection) {
				
                                case 1:	
                                        //if the user has selected to translate
                                        theApp.retrieve();
					break;
				case 2:
					// If user has selected to insert
					theApp.insert();
					break;
				case 3:
					// If user has selected to update
					theApp.update();
					break;
                                case 4:
					// If user has selected to delete
					theApp.delete();
					break;
                                case 5:
					// If user has selected display all words
					theApp.display();
					break;

				default:
					//If user has not selected any valid option
					System.out.println("\nPlease select a value from the menu.");
					break;
				}
                        userSelection = theApp.operations();        //repeat the operations menu until user chooses to quit program
                } 
                
                //ask the user for an output file name/location and print the collection to the file 
                boolean finish = false;
                while (finish == false) {
                    try {
                Scanner outname = new Scanner(System.in);
		System.out.println("\nPlease select the name/location of the file for this collection to be saved in as per the following format (C:\\Users\\user\\Desktop\\outputname.txt): ");	
                String fileout = outname.nextLine();
                PrintWriter output = new PrintWriter(new FileWriter(fileout));
                output.println(theApp.words.displayall(theApp.words));
                finish = true;
                output.close();
                    System.out.println("\nFile saved!");
                    }
                    catch (IOException e) {
                        System.out.println("Cannot write to file");
                    }
                }
                
                //final output
                System.out.println("---------------------------");
                System.out.println("THE END");
                System.out.println("---------------------------");
		}
		// Exit
    }
   
    
