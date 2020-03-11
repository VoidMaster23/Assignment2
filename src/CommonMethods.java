/**
 * Class containing methods to be used by both LSBSTApp and LSArrayApp
 * @author Edson Shivuri
 **/

public class CommonMethods{

	/**
         * Splits a key into its stage, day and start time formatted for output
         * @param key the key to be split up 
         * @return the split up key in the format "Stage: x, Day: y, Start Time: z:00"
         **/
        public static String breakKey(String key){
                String[] info = key.split("_");
                return "Stage: "+info[0]+", Day: "+info[1]+", Start Time: "+info[2]+":00";

        }

	 /**
         *Generates a key that can be used to search the array
         *@param stage stage of the loadshedding
         *@param day day of the month the loadshedding will take place
         *@param startTime starting hour of the loadshedding, e.g 8pm will be  20
         *@return A key of type String that can be used to search the array
         **/
        public static String makeKey(String stage, String day, String startTime){
                return stage+"_"+day+"_"+startTime;
        }



}
