


/**
 * Class containing all the methods for data handling for the BST solution
 * @author Edson Shivuri
 **/
public class LSBSTApp{
	//BST to store scheduleItem nodes
	public static BST<ScheduleItem> itemBST;

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
		
		UserMenu.menu();
		
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

	
}

