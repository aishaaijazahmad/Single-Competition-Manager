/**
 * Dated: 23/10/2018
 * This is a Name Class. It is used to return various formats of Competitor Name.
 * @author Aisha Aijaz Ahmad
 * @version 1.0
 */
public class Name 
{
	
/////////////////////////////////////////////////////////////////////////////////
	
	    //Instance variables
	    /**
	     * The instance variables of this class consist of First Name, Middle Name, and Last Name.
	     * This class allows the usage of full name in various formats.
	     */
	    private String firstName;
	    private String middleName;
	    private String lastName;
	    
/////////////////////////////////////////////////////////////////////////////////
	    
	    //all possible constructors--------------
	    
	    /**
	     * Default Initialization of Name Class.
	     * @param fN The parameter to take user input: First Name.
	     * @param mN The parameter to take user input: Middle Name.
	     * @param lN The parameter to take user input: Last Name.
	     */
	    public Name(String fN, String mN, String lN) 
	    {
		   	firstName = fN;
	        middleName = mN;
	        lastName = lN;
		}
	    
/////////////////////////////////////////////////////////////////////////////////
	    
	    /**
	     * Second option to take name from user: No Middle Name.
	     * @param fName The parameter to take user input: First Name.
	     * @param lName The parameter to take user input: Last Name.
	     */
	    public Name(String fName, String lName) 
	    {
	    	firstName = fName;
	    	middleName = "";	//Middle Name is null.
	    	lastName = lName;
	    }
	    
/////////////////////////////////////////////////////////////////////////////////
	    
	    /**
	     * Third option to take name: As a single string, with or without middle name.
	     * @param fullName The parameter to take user input: Full Name.
	     */
	    public Name (String fullName) 
	    {
	    	 int spacePos1 = fullName.indexOf(' '); //position of first space
	    	 firstName = fullName.substring(0, spacePos1);
	    	 int spacePos2 = fullName.lastIndexOf(' '); //position of first space
	    	
	    	 if (spacePos1 == spacePos2)
	    		 middleName = "";
	    	 else
	    		 middleName = fullName.substring(spacePos1+1, spacePos2);
	    	 	 lastName = fullName.substring(spacePos2 + 1);
	    }

	    //end of constructors----------------------
	    
/////////////////////////////////////////////////////////////////////////////////
	    
		/** Method to return the First Name.
		 * @return firstName This is the First Name only.
		 */
		public String getFirst()
	    {
	        return firstName;
	    }
		
/////////////////////////////////////////////////////////////////////////////////
	    
	    /** Method to return the Middle Name.
	     * @return middleName This is the Middle Name only.
	     */
	    public String getMiddle()
	    {
	        return middleName;
	    }
	    
/////////////////////////////////////////////////////////////////////////////////
	    
	    /** Method to return the Last Name.
	     * @return lastName This is the Last Name only.
	     */
	    public String getLast()
	    {
	        return lastName;
	    }
	    
/////////////////////////////////////////////////////////////////////////////////
	    
	    /** Method to return the First and Last Name only.
	     * @return firstName and lastName 
	     */
	    public String getFirstSpaceLast() 
	    {
	        return firstName + " " + lastName;
	    }
	    
/////////////////////////////////////////////////////////////////////////////////
	    
	    /** Method to return the lastName, firstName in this format.
	     * @return lastName, firstName
	     */
	    public String getLastCommaFirst()
	    {
	        return lastName + ", " + firstName;
	    }
	    
/////////////////////////////////////////////////////////////////////////////////
	    
	    /** The Method returns the Full Name.
	     * @return firstName + middleName + lastName
	     */
	    public String getFullName()
	    {
	    	String result = firstName + " ";
	    	if (!middleName.equals(""))
	    	{
	    		result += middleName + " " ;
	    	}
	    	result += lastName;
	    	return result;
	    }
    
/////////////////////////////////////////////////////////////////////////////////
	    
	    /** Method to only get the initials. 
	     * @return compInitials returns the initials of each word.
	     */
	    public String getInitialsOnly()
	    {
	    	String compInitials;
	    	if(middleName!="")
	    	{
	    		compInitials = "("+firstName.charAt(0)+
	    					   middleName.charAt(0)+
	    				       lastName.charAt(0)+")";
	    	}
	    	else
	    	{
	    		compInitials = "("+firstName.charAt(0)+
							   lastName.charAt(0)+")";
	    	}
	    	return compInitials;
	    }
	    
/////////////////////////////////////////////////////////////////////////////////
}
