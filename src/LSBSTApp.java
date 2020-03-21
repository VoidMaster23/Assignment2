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
		if(args.length == 4){
                        readFile.read(args[3]);
                }else{
                        readFile.read(null);
                }

		itemBST = readFile.getItemsBST();
		
		//Determine which function to call
		if(args.length == 0){
                        printAllAreas();
                }else if(args.length == 3 || args.length == 4){
                       printAreas(args[0], args[1], args[2]);
                }else{
                        System.out.println("Your input should be of the format xx yy zz ");
                }

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
			//System.out.println(found.getData().toString());

		//System.out.println("Number of insert operations: "+itemBST.insCount);
		//System.out.println("Number of find operations: "+itemBST.finCount);	
		//System.out.println();

		//Experiment Code
		System.out.print(itemBST.finCount);
		System.out.print(" ");
		System.out.println(itemBST.insCount);	

	}


	
}

