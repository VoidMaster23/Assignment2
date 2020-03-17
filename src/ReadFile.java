//import statement
import java.io.*;
import java.util.Scanner;




/** 
 * Reusable class to handle file reading in both the BSTApp and the Array app
 * @author Edson Shivuri
 **/
public class ReadFile{
	//String to store calling class name 
	private  String calledBy;

	//Array that will be used in the Array app
	private ScheduleItem[] itemArr;
	private  int numElements;
	
	//BST USed for the BST app
	private BST<ScheduleItem> itemBST;

	//AVL used for AVL app
	private AVL<ScheduleItem> itemAVL;
	
	/**
	 *Constructor for a ReadFile object that instantiates the instance vatiables and determines which which add method to use
	 **/
	public ReadFile(){
		itemArr = new ScheduleItem[2976];
		numElements = 0;	
	
		itemBST = new BST<ScheduleItem>();

		itemAVL = new AVL<ScheduleItem>();	

		//determine which class called the read
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		if(stackTraceElements[2].getClassName().equals("LSArrayApp")){
                        calledBy = "LSArrayApp"; 
                  }else if (stackTraceElements[2].getClassName().equals("LSBSTApp")){  
                        calledBy = "LSBSTApp";
                  }else{
		  	calledBy = "LSAVLapp";
		  }

	

	}


	/**
	 * Reads data from the file or a subset of the file
	 * @param fileN name of the file to be used , e.g "text.txt"
	 **/
	public void read(String fileN){
	File toRead;
	try{
		if(fileN == null){
		toRead = new File("res/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");// allows the program to work with this
		}else{
			toRead = new File("res/"+fileN);
		}
		//declare the scanner
		Scanner scanner  = new Scanner(toRead);
		
		//iterate through the file to be read
		while(scanner.hasNextLine() && numElements < 2976){
			String[] line = scanner.nextLine().split(" ", 2);//takes in the line and splits into a key and then items
			String key = line[0];
			String areas = line[1];

			//create object
			ScheduleItem item = new ScheduleItem(key, areas);

			//add the object to the appropriate DS
			if(calledBy.equals("LSArrayApp")){
				arrAdd(item);
				numElements++;	
			}else if (calledBy.equals("LSBSTApp")){
				itemBST.insert(item);
			}else{
				itemAVL.insert(item);
			}

		}//while
	}catch(Exception e){
			//code to run my output files
			
			
			e.printStackTrace();
			System.out.println("Error: File Not Found in Directory");
			System.exit(0);	
		}

	}//read method	

	
	
	/**
	 * Adds scheduleItem objects to the array
	 *
	 **/
	private void arrAdd(ScheduleItem item){
		itemArr[numElements] = item;
		
	}


	/**
	 * returns the array to be used by the LSArrayApp
	 * @return Array of ScheduleItem objects
	 **/
	public ScheduleItem[] getItemsArray(){
		ScheduleItem[] myItems = itemArr.clone();
		return myItems;
	}

	/**
	 * returns the BST to be used by the LSBSTApp
	 * @return BST of SCheduleItem objects
	 **/
	 public BST<ScheduleItem> getItemsBST(){
	 	return this.itemBST;
	 }

	 public AVL<ScheduleItem> getItemsAVL(){
	 	return this.itemAVL;
	 }


}
