package customstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;  

/**
 * In this assignment, you will implement a simple class called CustomString.  This class represents a more customizable version 
 * of a String, with additional attributes and methods.  
 * For example, the CustomString class has a “reverse” method which returns a new string version of the current string where the 
 * capitalization is reversed (i.e., lowercase to uppercase and uppercase to lowercase) for the alphabetical characters specified 
 * in the given arg.  For CustomString “abc, XYZ; 123.”, calling reverse("bcdxyz@3210.") will return "aBC, xyz; 123.".  
 * 
 * The CustomString class also has a “remove” method which returns a new string version of the current string where the alphabetical 
 * characters specified in the given arg, are removed.  For CustomString "my lucky numbers are 6, 8, and 19.", calling remove("ra6") 
 * will return "my lucky numbes e 6, 8, nd 19.".
 * 
 */
public class CustomString {
	
	//instance variables
	
	/**
	 * Current string.
	 */
	String myString;
	
	/**
	 * Indicates if the current string myString has been set (not null).
	 */
	boolean isSet;
	
	//constructor
	
	/**
	 * Initializes current string myString to null.
	 * Initializes isSet to false.
	 */
	public CustomString() {
		// TODO Implement constructor
		this.myString = null;
		this.isSet = false;
	}

	// methods 
	
    /**
     * Returns the current string.
     * If the current string is null, or has not been set to a value with setString, it should return null.
     * @return current string
     */
	public String getString() {
		// TODO Implement method
		if (this.myString != null) {
			return this.myString;
		}else {
			return null;
		}
		
	}

	/**
     * Sets the value of the current string and sets this.isSet to true.
     * If the given string is null, sets this.isSet to false.
     * @param string value to be set
     */
	public void setString(String string) {
		// TODO Implement method
		this.myString = string;
	}

    /**
     * Returns a new string version of the current string where the alphabetical characters specified in the given arg, are removed.
     *   
     * The alphabetical characters to be removed are case insensitive.  
     * All non-alphabetical characters are unaffected.
     * If the current string is null, empty, or has not been set to a value, this method should return an empty string.
     *
     * Example(s):
     * - For a current string "my lucky numbers are 6, 8, and 19.", calling remove("ra6") would return "my lucky numbes e 6, 8, nd 19."
     * - For a current string "my lucky numbers are 6, 8, and 19.", calling remove("6,.") would return "my lucky numbers are 6, 8, and 19."
     * - For a current string "my lucky numbers are 6, 8, and 19.", calling remove("") would return "my lucky numbers are 6, 8, and 19."
     * 
     * Remember: This method builds and returns a new string, and does not directly modify the myString field.
     * 
     * @param arg the string containing the alphabetical characters to be removed from the current string
     * @return new string in which the alphabetical characters specified in the arg are removed
     */
	public String remove(String arg) {
		// TODO Implement method
		//if myString is null return null;
		//make an character array of the finalArray
		String finalArray = this.myString;
				
		//make a character array of the strings to be removed
		char[] removeArray = arg.toCharArray();
		
		//check if any of them are letters.
		//if of them is letter return the original string
		//if myString is null or blank return ""
		if (this.myString == null || this.myString.length() == 0) {
			return "";
		}else {
			for (int i = 0;i<removeArray.length; i++) {
				if (Character.isLetter(removeArray[i])) {
					//replace the array element with blank space
					String k= String.valueOf(removeArray[i]);
					//note that this operation does not affect finalArray itself.
					finalArray = finalArray.replace(k,"");			
				}
			}	
			return finalArray;
		}		
	}
	
	/**
	 * Returns a new string version of the current string where the capitalization is reversed (i.e., lowercase to uppercase, 
	 * and uppercase to lowercase) for the alphabetical characters specified in the given arg.
	 *   
	 * All non-alphabetical characters are unaffected.
	 * If the current string is null, empty, or has not been set to a value, this method should return an empty string.
	 *
	 * Example(s):
	 * - For a current string "abc, XYZ; 123.", calling reverse("bcdxyz@3210.") would return "aBC, xyz; 123."
	 * - For a current string "abc, XYZ; 123.", calling reverse("6,.") would return "abc, XYZ; 123."
	 * - For a current string "abc, XYZ; 123.", calling reverse("") would return "abc, XYZ; 123."
	 * - For a current string "", calling reverse("") would return ""
	 * 
	 * Remember: This method builds and returns a new string, and does not directly modify the myString field.
	 * 
	 * @param arg the string containing the alphabetical characters to have their capitalization reversed in the current string
	 * @return new string in which the alphabetical characters specified in the arg are reversed
	 */
	public String reverse(String arg) {
		// TODO Implement method 
		
		String finalArray = this.myString;
		
		//make a character array of the strings to be removed
		char[] alterArray = arg.toCharArray();
		
		//check if any of them are letters.
		//if of them is letter return the original string
		//if myString is null or blank return ""
		if (this.myString == null || this.myString.length() == 0) {
			return "";
		}else {
			for (int i = 0;i<alterArray.length; i++) {
				if (Character.isLetter(alterArray[i])) {
					//switch the case if the array element can find a search
					String k= String.valueOf(alterArray[i]);
					if(finalArray.indexOf(k.toLowerCase())!=-1) {
						finalArray = finalArray.replace(k.toLowerCase(),k.toUpperCase());
					} else if(finalArray.indexOf(k.toUpperCase())!=-1) {
						finalArray = finalArray.replace(k.toUpperCase(),k.toLowerCase());
					}				
				}
			}	
			return finalArray;
		}		
	}

    /**
     * Returns a new string version of the current string where all the letters either >= or <= the given char n, are removed.  
     * 
     * The given letter may be a-z or A-Z, inclusive.
     * -The letters to be removed are case insensitive.
     *
     * -If 'more' is false, all letters less than or equal to n will be removed in the returned string.
     * -If 'more' is true, all letters greater than or equal to n will be removed in the returned string.
     *
     * -If the current string is null, the method should return an empty string.
     * -If n is not a letter (and the current string is not null), the method should return an empty string.
     *
     * Example(s):
     * - For a current string "Hello 90, bye 2", calling filterLetters('h', false) would return "llo 90, y 2"
     * - For a current string "Abcdefg", calling filterLetters('c', false) would return "defg"
     * - For a current string "Hello 90, bye 2", calling filterLetters('h', true) would return "e 90, be 2"
     * - For a current string "Abcdefg", calling filterLetters('c', true) would return "Ab"
     * 
     * Remember: This method builds and returns a new string, and does not directly modify the myString field.
     *
     * @param n char to compare to
     * @param more indicates whether letters <= or >= n will be removed
     * @return new string with letters removed 
     */
	public String filterLetters(char n, boolean more) {
		// TODO Implement method
		//make a character array of the strings to be removed
		
		
		if (this.myString == null || this.myString.length() == 0 
			||(String.valueOf(n) == null && this.myString !=null)) {
			return "";
		}else {
			char[] finalArray = this.myString.toCharArray();
			char n2= Character.toLowerCase(n);
			for (int i = 0;i<finalArray.length; i++) {
				if (Character.isLetter(finalArray[i])) {
					//switch the case if the array element can find a search
					char k= Character.toLowerCase(finalArray[i]);
					if (more == true && n2<=k) {
						finalArray[i]='\0';
					} else if(more == false && n2>=k) {
						finalArray[i]='\0';				
					}				
				}
			}	
			String finalArray2 = String.valueOf(finalArray).trim();
			System.out.println(finalArray2);
			System.out.println(finalArray2.equals("abd"));
			return finalArray2;			
		}	
	}
}
