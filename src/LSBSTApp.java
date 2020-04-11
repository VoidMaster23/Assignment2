import java.util.Scanner;


/**
 * Class containing all the methods for data handling for the BST solution
 * @author Edson Shivuri
 **/
public class LSBSTApp{
	//BST to store scheduleItem nodes
	static BST<ScheduleItem> itemBST;

	//instrumentation
	private static int finCount;
	private static int insCount;

	/**
	 * Drives the program and calls all necessary funtions
	 * @param args string array to take in parameters to start the program with
	 **/
	public static void main(String[] args){
		ReadFile readFile = new ReadFile();
		//this code was for the experiment so that different files could be passed in
		//in the final product this will always just read from the default file
		if(args.length == 4){
                        readFile.read(args[3]);
                }else{
                        readFile.read(null);
                }

		itemBST = readFile.getItemsBST();
		
		menu();
		
		//code for experimental purposes 
		//Determine which function to call
		//if(args.length == 0){
                //        printAllAreas();
                //}else if(args.length == 3 || args.length == 4){
                //       printAreas(args[0], args[1], args[2]);
                //}else{
                //        System.out.println("Your input should be of the format xx yy zz ");
                //}

	}

	/**Prints all loadshedding details
         **/
        public static void printAllAreas(){
		//performs an inOrder traversal
		itemBST.inOrder();
	}

	/**
         * Prints out the list of areas for the first matching combination of the supplied parameters that it is found or "Areas not found" if there is no match 
         * @param stage stage of the loadshedding
         * @param day day of the month the loadshedding will take place
         * @param startTime starting hour of the loadshedding, e.g 8pm will be  20 
         **/
	public static void printAreas(String stage,String day, String startTime){
		//bulild the key
		String toFind = CommonMethods.makeKey(stage, day, startTime);
		ScheduleItem temp = new ScheduleItem(toFind, null);
		//System.out.println(temp.toString());


		//find the node
		BTNode<ScheduleItem> found = itemBST.find(temp);
	//	System.out.println(found.toString());

		//output
		if(found == null)
			System.out.println("Areas not Found");
		else
			System.out.println(found.getData().toString());

		System.out.println("Number of insert operations: "+itemBST.insCount);
		System.out.println("Number of find operations: "+itemBST.finCount);	
		System.out.println();

		//Experiment Code
		//System.out.print(itemBST.finCount);
		//System.out.print(" ");
		//System.out.println(itemBST.insCount);	

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
		itemBST.inOrder(); // prints the scheduleItem info
		//reset the search item
		SearchItem.toSearch = null;
		SearchItem.stage = null;
	}

	
	


	/**
	* Provides a text based options Menu for the user to choose from
	**/
	public static void menu(){
		//get user input
		Scanner getInput = new Scanner(System.in);
		//store user choice
		String choice;
	

		//repeat until the user decides to exit the program 
		//get user input
 		do{
		System.out.println("Loadshedding Schedule Utility");
		System.out.println();
		System.out.println("Enter 1 to display the entire loadshedding schedule");
		System.out.println("Enter 2 to find all the areas to be affected by a a scheduled loadshdding period");
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


	
}

