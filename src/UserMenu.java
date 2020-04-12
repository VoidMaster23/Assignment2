import java.util.Scanner;

/**
*Class to hold the UI methods to handle the interactions with the user for both the LSBSTApp and the LSAVLapp. It works by determining which app called it and handles each task accordingly,calling the appropriate ds.
*@author Edson Shivuri
**/
public class UserMenu{
//stores the information of which class called it
	private static String calledBy;

	/**
	* Provides a text based options Menu for the user to choose from
	**/
	public static void menu(){
		//get user input
		Scanner getInput = new Scanner(System.in);
		//store user choice
		String choice;

		//determine which class called the menu
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		if(stackTraceElements[2].getClassName().equals("LSBSTApp")){
                        calledBy = "LSBSTApp"; 
                  }else if (stackTraceElements[2].getClassName().equals("LSAVLapp")){  
                        calledBy = "LSAVLapp";
                  }


	

		//repeat until the user decides to exit the program 
		//get user input
 		do{
		System.out.println("Loadshedding Schedule Utility: "+calledBy);
		System.out.println();
		System.out.println("Enter 1 to display the entire loadshedding schedule");
		System.out.println("Enter 2 to find all the areas to be affected by a scheduled loadshedding period");
		System.out.println("Enter 3 to find all scheduled loadshedding times associated with a particular area");
		System.out.println("Enter 0 to exit the program");
		System.out.print("Your Choice: ");
		choice = getInput.next();

		switch(choice){
		case "1": {
			printAllAreas();
			break;
			}

		case "2": {
			//call the get input funtion
			getInfo();
			break;
			}
		
		case "3": {
			//call the area search area function
			searchArea();
			break;
			}

		

		case "0": {
			//give a nice indication that the program is closing
			System.out.println("Have a great day!");
			System.exit(0);
			}

		// let the user know that they made an invalid choice
		default: System.out.println("Invalid choice, try again");

		
		}

		}while(!choice.equals("0"));

		

	}

	/**
	* Used to get the user input for which area to search for
	**/
	private static void searchArea(){
	//temporary scanner to take in the area
		Scanner searchScan = new Scanner(System.in);
		System.out.println("Enter the area you're looking for information on, eg 15");
		String area = searchScan.next();
		SearchItem.toSearch  = area;

		System.out.println("Enter the stage of the loadshedding, e.g 4");
		String stage = searchScan.next();
		SearchItem.stage = stage;
		
		//Give a heading to the data
		System.out.println("Stage "+stage+" loadshedding information for area "+area);
		
		 if(calledBy.equals("LSBSTApp")){
			LSBSTApp.itemBST.inOrder(); // prints the scheduleItem info
		}else{
			LSAVLapp.itemAVL.inOrder();
		}
		//reset the search item
		SearchItem.toSearch = null;
		SearchItem.stage = null;
	}


	/**
	* Used to get the user input for to call the printAreas() function
	**/
	private static void getInfo(){
	 //temporary scanner that will take in the scheduleInfo
                Scanner infoScan = new Scanner(System.in);
 
                  // get the load shedding schedule information 
                System.out.println("Enter the loadshedding stage, e.g 5 ");
		String stage = infoScan.next();
		
	
		System.out.println("Enter the day of loadshedding, e.g 15 ");
                String day = infoScan.next();

		System.out.println("Enter the start time of the loadshedding, e.g 00 , for midight.)");
                String startTime = infoScan.next();
			
		  //call the findAreas function 
              
		printAreas(stage, day, startTime);
		

	}


	/**
	 * Prints loadshedding details
	 **/
	private static void printAllAreas(){
		// performs a traversal

		if(calledBy.equals("LSAVLapp")){
			LSAVLapp.itemAVL.inOrder();
		}else{
			LSBSTApp.itemBST.inOrder();
		}
	}

	/**
	 * Prints out the list of areas for the first matching combination of supplied paramerters if it is found or "Areas not found" if there is no match
	 * @param stage stage of the loadshedding
	 * @param day day of loadshedding
	 * @param startTime starting hour of the loadshedding, e.g 8pm will be 20
	 **/
	private static void printAreas(String stage, String day, String startTime){
		//build the key
		String toFind = CommonMethods.makeKey(stage, day, startTime);
		ScheduleItem temp = new ScheduleItem(toFind, null);

		//find the node
		BTNode<ScheduleItem> found;

		 if(calledBy.equals("LSBSTApp")){  
		 	found = LSBSTApp.itemBST.find(temp);
		 }else{
		 	found = LSAVLapp.itemAVL.find(temp);
		 }
		
		//return result
		if(found == null) 
			System.out.println("Areas not found");
		else
			System.out.println(found.getData().toString());

		//System.out.println("Number of insert operations: "+ itemAVL.insertCount);
		//System.out.println("Number of find operations: "+itemAVL.findCount);

		//Experiment code
		// System.out.print(itemAVL.findCount);
		// System.out.print(" ");
		// System.out.println(itemAVL.insertCount);

	}


}
