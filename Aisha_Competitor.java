/**
 * Dated: 23/10/2018
 * This is Aisha's Competitor Class. It is used to access different data of the Competitor.
 * It contains all basic details of the Competitor and also returns specific calculations regarding their overall attributes.
 * @author Aisha Aijaz Ahmad
 * @version 1.0
 */

/////////////////////////////////////////////////////////////////////////////////

public class Aisha_Competitor {

/////////////////////////////////////////////////////////////////////////////////
	
	private int compNum;
	private Name compName;
	private int compLevel;
	private String compPosition;
	private int compAge;
	private char compGender; 
	private int [] compScore;
	public static final int No_of_Scores = 5;  
	private int count = 0;
	
/////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Creates a Competitor object with values specified in the parameters
	 * @param cNum is the Competitor Number
	 * @param cName is the Competitor Name
	 * @param cLevel is the Competitor Level (1-5)
	 * @param cPosition is the Competitor Position (Center, Forward, Backward)
	 * @param cAge is the Competitor Age
	 * @param cGender is the Competitor Gender 
	 */
	public Aisha_Competitor(int cNum, Name cName, int cLevel, String cPosition, int cAge, char cGender)
	{
		compNum = cNum;
		compName = cName;
		compLevel = cLevel;
		compPosition = cPosition;
		compAge = cAge;
		compGender = cGender;
		compScore = new int [No_of_Scores];
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** The method returns the Competitor Number.
	 * @return the Competitor Number
	 */
	public int getNum()							//get Competitor Number
	{
		return compNum;
	}
	/** The method sets compNum to value newNum taken from the user.
	 * @param newNum is the user-defined value for Competitor Number.
	 */
	public void setNum(int newNum)				//set Competitor Number
	{
		compNum = newNum;
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** The method returns the Competitor Name.
	 * @return the Competitor Name
	 */
	public Name getName()					//get Competitor Name
	{
		return compName;
	}
	/** The method sets compName to object newNum taken from the user.
	 * @param newName is the user-defined value for Competitor Name.
	 */
	public void setName(Name newName)		//set Competitor Name
	{
		compName = newName;
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** The method returns the Competitor Level.
	 * @return the Competitor Level
	 */
	public int getLevel()						//get Competitor Level
	{
		return compLevel;
	}
	
	/** The method sets compLevel to int value newLevel taken from the user.
	 * @param newLevel is the user-defined value for Competitor Level.
	 */
	public void setLevel(int newLevel)			//set Competitor Level
	{
		compLevel = newLevel;
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** The method returns the Competitor Position.
	 * @return the Competitor Position
	 */
	public String getPosition()					//get Competitor Position
	{
		return compPosition;
	}
	/** The method sets the compPosition to the String value newPosition taken from the user.
	 * @param newPosition is the user-defined value for Competitor Position.
	 */
	public void setPosition(String newPosition)	//set Competitor Position
	{
		compPosition = newPosition;
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** This method returns the Competitor Age.
	 * @return the Competitor Age
	 */
	public int getAge()							//get Competitor Age
	{
		return compAge;
	}
	/** The method sets the compAge to the integer value newAge taken from the user.
	 * @param newAge is the user-defined value for Competitor Age.
	 */
	public void setAge(int newAge)				//set Competitor Age
	{
		compAge = newAge;
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** This method returns the Competitor Gender.
	 * @return the Competitor Gender
	 */
	public char getGender()							//get Competitor Gender
	{
		return compGender;
	}
	/** The method sets the compGender to the character value newGender taken from the user.
	 * @param newGender is the user-defined value for Competitor Gender.
	 */
	public void setGender(char newGender)				//set Competitor Gender
	{
		compGender = newGender;
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** Calculates the overall score of the Competitor based on the following values:
	 * Score 1: Leadership and Team work (out of 10)
	 * Score 2: Ball Handling Score(out of 20)
	 * Score 3: Offense Score (out of 30)
	 * Score 4: Defense Score (out of 30)
	 * Score 5: Tricks and Free style (10)
	 * This gives a maximum total of 100 points which are weighted separately.
	 * The total is multiplied by a Level Bonus score which increases the score based on Level.
	 * The Level is awarded to the Competitor based on their experience and overall skill.
	 * @return The Competitor Overall Score.
	 */
	public double getOverallScore()				//method to get overall score
	{
		//calculating Overall Score based on weighted averages
		//Score 1: Leadership and Team work (out of 10)
		//Score 2: Ball Handling Score(out of 20)
		//Score 3: Offense Score (out of 30)
		//Score 4: Defense Score (out of 30)
		//Score 5: Tricks and Free style (10)
		
		//add level bonus
		double level_bonus = 1.20; //default level bonus
		switch(compLevel)
		{
			case 1: level_bonus = 1.20;
				break;
			case 2: level_bonus = 1.40;
				break;
			case 3: level_bonus = 1.60;
				break;
			case 4: level_bonus = 1.80;
				break;
			case 5: level_bonus = 2.0;
				break;
		    default: {
		    			System.out.println("Cannot calculate Level Bonus.\n");
		    			System.exit(0);			
		    		}
		}
		
		double LAT = (compScore[0]*1.0/10) * 2.5;
		double BHS = (compScore[1]*1.0/20) * 2.5;
		double OS = (compScore[2]*1.0/30) * 2.5;
		double DS = (compScore[3]*1.0/30) * 2.5;
		double TFS = (compScore[4]*1.0/10) * 2.5;
		
		double total_average = (LAT + BHS + OS + DS + TFS)/5;
		double total_withbonus = total_average * level_bonus;
		
		return total_withbonus;
		}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** This method adds scores to the Competitor's Score array directly from the main function.
	 * This option is added in case the user does not have any scores yet. 
	 * @param Score is a single element is the Score array.
	 */
	public void addScore(int Score)
	{
			try 
			{
				compScore[count] = Score;
				count++;
			} 
			catch (Exception e) 
			{
				System.out.println("Only five scores are acceptable.");;
			}
			
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/**This method returns the Score Array of the Competitor.
	 * @return The compScore Array.
	 */
	public int [] getScoreArray()
	{
		return compScore;
	}

/////////////////////////////////////////////////////////////////////////////////

	public String convertScoresToRange()
	{
		String report = "";
		
		//use double array to change score values between 0 and 5.
		double [] curr_arr_range;
		curr_arr_range = new double [No_of_Scores];
		
		double level_bonus = 1.2;   //default level = 1
		int level = this.getLevel();
		
		//modify scores based on experience level.
		switch(level)
		{
			case 1: level_bonus = 1.2;				//xp level 1
			break;
			case 2: level_bonus = 1.4;				//xp level 2
			break;
			case 3: level_bonus = 1.6;				//xp level 3
			break;
			case 4: level_bonus = 1.8;				//xp level 4
			break;
			case 5: level_bonus = 2.0;				//xp level 5
			break;
			default: System.out.println("\nInvalid level entry for score calculation.");
		}
		
		curr_arr_range[0] = ((compScore[0]*1.0)/10)*2.5*level_bonus;		//out of 10 points
		curr_arr_range[1] = ((compScore[1]*1.0)/20)*2.5*level_bonus;		//out of 20 points
		curr_arr_range[2] = ((compScore[2]*1.0)/30)*2.5*level_bonus;		//out of 30 points
		curr_arr_range[3] = ((compScore[3]*1.0)/30)*2.5*level_bonus;		//out of 30 points
		curr_arr_range[4] = ((compScore[4]*1.0)/10)*2.5*level_bonus;		//out of 10 points
	
		//print for all 5 scores (LAT, BHS, OS, DS, TFS)
		for(int i = 0; i < No_of_Scores; i++)
		{
			report += String.format("%.0f", curr_arr_range[i])+" ";
		}
		
		return report;
	}
	
/////////////////////////////////////////////////////////////////////////////////

	/** This method returns the Competitor's Full Details.
	 * @return The Competitor's Full Details as a concatenated String.
	 */
	public String getFullDetails()				//method to get full details
	{
		String fullDetails;
		String scoreInfo;
		String overallScoreVal;
		fullDetails = "\nFull Details: \nCompetitor Number " + compNum + ", name " + compName.getFullName() + ", of level "
				+ compLevel + ", plays at position " + compPosition + ".\n";
		
		scoreInfo = compName.getFirst() + ", aged " + compAge + ", recieved the following scores: " +this.convertScoresToRange();
		
		if(compGender == 'F')
		{
		overallScoreVal = "\nThis gives her an overall score of: " + 
						  String.format("%1.3f",getOverallScore()) + ".";
		}
		else
		{
			overallScoreVal = "\nThis gives him an overall score of: " + 
	    					  String.format("%1.3f",getOverallScore()) + ".";
		}
		
		return fullDetails + scoreInfo + overallScoreVal;
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** This method returns the Competitor's Short Details as directed in the Coursework specifications.
	 * @return The Competitor's Short Details in String format.
	 */
	public String getShortDetails()
	{
		String shortDetails;
		shortDetails = "\nShort Details: \nCN " + compNum + " " + compName.getInitialsOnly() + 
				" has overall score " + String.format("%1.3f",getOverallScore()) + ".";
		return shortDetails + "\n";
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** This method gives the total scores of the Competitor out of 100 points.
	 * @return The total Score.
	 */
	public int getTotalScores()
	{
		int total = 0;
		for(int i = 0; i<No_of_Scores; i++)
		{
			total = total + compScore[i];
		}
		return total;
	}

/////////////////////////////////////////////////////////////////////////////////

}
