/**
 * Class Containing all the methods for data handling for AVL solution
 * @author Edson Shivuri
 **/
public class LSAVLapp{
	//AVL tree to store ScheduleItem nodes
	static AVL<ScheduleItem> itemAVL;

	//instrumentation
	private static int finCount;
	private static int insCount;
	 
	/**
	 * Drives the program and calls all necessary functions
	 * @param args String array to take in the params to start the program with
	 **/
	public static void main(String[] args){
		//create a readFile object
		ReadFile read = new ReadFile();

		if(args.length == 4){
			read.read(args[3]);
		}else{
			read.read(null);
		}

		itemAVL = read.getItemsAVL();

		//determine which function to call
		if (args.length == 0){
			printAllAreas();
		}else if (args.length == 3 || args.length == 4){
			printAreas(args[0], args[1], args[2]);
		}else{
			System.out.println("Your input should be in the format xx yy zz ");
		}


	}

	/**
	 * Prints loadshedding details
	 **/
	public static void printAllAreas(){
		// performs a traversal
		itemAVL.inOrder();
	}

	/**
	 * Prints out the list of areas for the first matching combination of supplied paramerters if it is found or "Areas not found" if there is no match
	 * @param stage stage of the loadshedding
	 * @param day day of loadshedding
	 * @param startTime starting hour of the loadshedding, e.g 8pm will be 20
	 **/
	public static void printAreas(String stage, String day, String startTime){
		//build the key
		String toFind = CommonMethods.makeKey(stage, day, startTime);
		ScheduleItem temp = new ScheduleItem(toFind, null);

		//find the node
		BTNode<ScheduleItem> found = itemAVL.find(temp);
		
		if(found == null) 
			System.out.println("Areas not found");
		else
			//System.out.println(found.getData().toString());
		//System.out.println("Number of insert operations: "+ itemAVL.insertCount);
		//System.out.println("Number of find operations: "+itemAVL.findCount);

		//Experiment code
		System.out.print(itemAVL.findCount);
		System.out.print(" ");
		System.out.println(itemAVL.insertCount);

	}
}
