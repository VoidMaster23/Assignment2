//import statements
import java.lang.Comparable;


/**
 *This class stores the data(key, areas) pertaining to a loadshedding schedule item
 *and the methods to manipulate it
 *
 * @author Edson Shivuri
 **/
public class ScheduleItem implements Comparable<ScheduleItem>{
// instance variables
private String key; // stores schedule iformation
private String areas; // stores area information



/**
 * creates a default scheduleItem object  with both key and areas being set to null
 * */
public ScheduleItem(){
key = null;
areas = null;
}

/**
 * creates a ScheduleItem object and initialises the key and areas instance variables
 * @param key Identifying key for the scheduleItem in the format stage_dayOfMonth_startTime
 * @param areas Stores all areas to be affected by loadshedding at the scheduled period and stage
 **/
public ScheduleItem(String key, String areas){

this.key = key;
this.areas = areas;

}


/**
 * Accessor method for the key
 * @return Identifying key for the scheduleItem
 **/
public String getKey(){
return this.key;
}

/**
 * Accessor method for the areas list
 * @return  Areas to be affected by the schuled loadshedding
 **/
public String getAreasAffected(){
return this.areas;
}




/**
 * Mutator method for the key
 * @params key New Idenifying key to be set
 **/
public void setKey(String key){
this.key = key;
}

/**
 * Mutator method for the areas
 * @params areas New set of areas to be assigned to the scheduleItem
 **/
public void setAreas(String areas){
this.areas = areas;
}



//sorts the areas
private void SortAreas(){
// may not need to Actually be here but add for the sake of good output
}

/**
 * Checks equality between two scheduleItem objects
 * @param other Object check the current object against 
 **/
public boolean equals(Object other){
if(other == null){
	return false; // null check
	
 }else if(this.getClass() != other.getClass()){
 	return false; // type check
 }else{
 // data check	 
 ScheduleItem otherItem = (ScheduleItem) other;
 return (key.equals(otherItem.getKey()) && (areas.equals(otherItem.getAreasAffected())));
 }
}


/**
 * Compares ScheduleItem objects by checking their key instance variables. A ScheduleItem object is smaller than another if any combination of stage, day of the month or time in the key is less than that of another object
 *@return 0 if the objects are equal, 1 if this object is greater than the one it is being compared with and -1 if it is smaller 
 **/
public int compareTo(ScheduleItem otherItem){
 // just need to compare the keys (time) to determine whether an item 
 // this WILL return an exception that must be handled later
	return this.key.compareTo(otherItem.getKey());
  
 }


/**
 * toString method for the ScheduleItem class
 **/
public String toString(){
return CommonMethods.breakKey(this.key)+"\n"+"Areas Affected: "+this.areas+"\n";

}

}
