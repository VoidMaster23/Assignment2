/**
 * Class Containing all the methods for data handling for AVL solution
 * @author Edson Shivuri
 **/
public class LSAVLapp{
	//AVL tree to store ScheduleItem nodes
	public static AVL<ScheduleItem> itemAVL;

	//instrumentation
	private static int finCount;
	private static int insCount;
	 
	/**
	 * Drives the program and calls the menu function
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

		UserMenu.menu();
		
		//determine which function to call
		//note that this might be neccessary if you still want command line args
		// if (args.length == 0){
		// 	printAllAreas();
		// }else if (args.length == 3 || args.length == 4){
		// 	printAreas(args[0], args[1], args[2]);
		// }else{
		// 	System.out.println("Your input should be in the format xx yy zz ");
		// }


	}



	
}
