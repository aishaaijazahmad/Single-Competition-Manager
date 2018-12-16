/**
 * This class imports libraries for using Arraylists and File I/O.
 */

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/////////////////////////////////////////////////////////////////////////////////

/**This is the class to initialize the Array List for the Competitors. It includes methods to generate various elements of our final report, such as Competitor table, statistics and Frequency report for every Competitor in the list. It also performs file handling and processing for the project.
 * Dated: 23/10/2018
 * @author Aisha Aijaz Ahmad
 * @version 1.0
 */
public class Aisha_CompetitorList 
{
	private ArrayList<Aisha_Competitor> Aisha_CompetitorList;
	
	/**
	 * Constructor for Aisha's CompetitorList class. It initializes the Array list instance to have a dynamic array of Aisha_Competitor objects. 
	 */
	public Aisha_CompetitorList()
	{
		Aisha_CompetitorList = new ArrayList<Aisha_Competitor> ();
	}


/////////////////////////////////////////////////////////////////////////////////

	/** This method writes the supplied text to given file.
	* @param filename is the name of the file to be written to.
	* @param report is the String text to be written to the file.
	*/
	public void writeToFile(String filename, String report) 
	{
		FileWriter fw;
		String [] split_report;
		split_report = new String[500];
		split_report = report.split("\n");
		
		filename = "C:/Users/Aisha Aijaz Ahmad/Desktop/" + filename;
		try 
		{
			 fw = new FileWriter(filename);
			 for(int i = 0; i < split_report.length; i++)
			 {
				 fw.write(split_report[i]);
				 fw.write("\r\n");				//IT WORKS!
			 }
			 fw.close();
		}
		
		//message and stop if file not found
		catch (FileNotFoundException fnf)
		{
			System.out.println(filename + " not found.");
			System.exit(0);
		}
		
		//stack trace here because we don't expect to come here
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			System.exit(1);
		}
	}

/////////////////////////////////////////////////////////////////////////////////
	
	/** This method reads the given file, line by line, and processes each line.
	 * @param filename is the name of the file to be read.
	 */
	public void readFile(String filename) 
	{
		try 
		{
			File f = new File(filename);
			Scanner scanner = new Scanner(f);
			while (scanner.hasNextLine()) 
			{
				//read first line and process it
				String inputLine = scanner.nextLine();
				if (inputLine.length() != 0) 
				{
					//ignored if blank line
					processLine(inputLine);
				}
			}//scanner.close();
		}
		//if the file is not found, stop with system exit
		catch (FileNotFoundException fnf)
		{
			System.out.println( filename + " not found.");
			System.exit(0);
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	/** This method is invoked by readFile and is given each line to separate and initialize them via relevant variables. 
	 * @param line is the single line of text from the .csv file.
	 */
	private void processLine(String line) 
	{
		try 
		{
			String parts [] = line.split(",");
			int cNum = Integer.parseInt(parts[0]);									//0th element is cNum
			String name = parts[1]; 								//1st element is cName
			Name cName = new Name(name);							
			int cLevel = Integer.parseInt(parts[2].trim());			//2nd element is cLevel
			String cPosition = parts[3];							//3rd element is cPosition
			int cAge = Integer.parseInt(parts[4].trim());			//4th element is cAge
			String Gender = parts[5].trim();						//5th element is cGender
			char cGender = Gender.charAt(0);
			
			Aisha_Competitor c = new Aisha_Competitor(cNum, cName, cLevel, cPosition, cAge, cGender);
			
			//get scores as integer values
			String scores [] = parts[6].split(" ");					//6th element is cScores
			int [] cScores;
			cScores = new int [Aisha_Competitor.No_of_Scores];
			for(int i = 0; i < scores.length; i++)
			{
				cScores[i] = Integer.parseInt(scores[i]);
				c.addScore(cScores[i]);
			}
			
			Aisha_CompetitorList.add(c);
		}

		// ignore lines in error and try and carry on
		//this catches trying to convert a String to an integer
		catch (NumberFormatException nfe) 
		{
			String error = "Number conversion error in '"
						+ line + "' - " + nfe.getMessage();
			System.out.println(error);
		}
		//this catches missing items if only one or two items
		//other omissions will result in other errors
		catch (ArrayIndexOutOfBoundsException air) 
		{
		String error = "Not enough items in : '" + line
		 + "' index position : " + air.getMessage();
		System.out.println(error);
		}
	}
	

/////////////////////////////////////////////////////////////////////////////////

	/** This method returns the number of elements in the Array List of Competitors.
	 * @return val - holds the size of the Array List of the Competitors.
	 */
	public int getSize() 
	{
		int val = Aisha_CompetitorList.size();
		return val;
	}

/////////////////////////////////////////////////////////////////////////////////
	
	/** This method returns the report with all details of the Competitors in the tabular format for each Competitor one by one.
	 * @return report - The report is saved in a String variable.
	 */
	public String getTableOfCompetitors()
	{
		int [] curr_arr;
		curr_arr = new int [5];
		int i;
		String string_scores = "";
		String report = "\nCompetitor                Level  Scores         Overall\n";
		report += "------------------------------------------------------\n";
		for (Aisha_Competitor c : Aisha_CompetitorList)
		{
			report += String.format("%-6s", Integer.toString(c.getNum()));
			report += String.format("%-20s", c.getName().getFullName() );
			report += String.format("%-7d", c.getLevel());
			report += String.format("%-15s", c.convertScoresToRange());
			report += String.format("%-1.3s", c.getOverallScore());
			report += "\n";
		}
		report = report + "\n--------------------------------------------------------\n";
		return report;
    }

/////////////////////////////////////////////////////////////////////////////////
	
	/** This method gets the object at the index of the Array List of the Competitors.
	 * @param index Is the integer index of the element in the Array List to be taken.
	 * @return The object from Aisha_Competitor at index.
	 */
	public Aisha_Competitor getAtIndex(int index) 
	{
		return Aisha_CompetitorList.get(index);
	}

/////////////////////////////////////////////////////////////////////////////////
	
	//returns the Competitor object with a specified CN
	 /** This method returns the object of the Competitor Class if the Competitor number is found. Otherwise it returns null.
	 * @param cn is the Competitor Number to be found.
	 * @return This is the object 'c' which corresponds to the cn taken as a parameter, and if cn is not found, it returns null. 
	 */
	public Aisha_Competitor findByNum(int cn)
	 {
		 for (Aisha_Competitor c : Aisha_CompetitorList)
		 {
			 if (c.getNum() == cn)
			 { return c; }
		 }
		 return null;
	 }

/////////////////////////////////////////////////////////////////////////////////
	 
	/** This is the method to calculate and print the first frequency report. The method counts the number of times full score was awarded to a field.
	 * @return report - It will return the Maximum Scores frequency report in String format.
	 */
	
	public String getScoresFrequencyReport() 
	{
		//HOW MANY FULL SCORES IN EACH FIELD
		int [] freqScores = new int [5];
		String [] Score = new String [5];
		
		int index = 0;
		for (Aisha_Competitor c : Aisha_CompetitorList) 
		{
			Score = c.convertScoresToRange().split(" ");
			for(int i=0; i<c.No_of_Scores; i++)
			{
				if(Score[i].equals("5"))
				{
					freqScores[i]++;
				}
			}
		}
		//create a report
		String report = "\nNUMBER OF FULL SCORES FOR EACH FIELD: \n\n";
		report += String.format("%-5s", "LAT") + String.format("%-5s", "BHS") +
				String.format("%-5s", "OS") + String.format("%-5s", "DS") + String.format("%-5s", "TFS") + "\n";
		
		for(int j = 0; j < 5; j++)
		{
			report += String.format("%-5s", freqScores[j]);
		}
		report += "\n";
		return report;
	}

/////////////////////////////////////////////////////////////////////////////////
	
	/** This is the method to calculate and print the second frequency report. The method counts the number of females and males and adds them to the respective elements of the freqGender array.
	 * @return report - It will return the Gender frequency report in String format.
	 */
	
	public String getGenderFrequencyReport() 
	{
		//work out how many females and males
		int [] freqGender = new int [2];
		char g;
		int index = 0;
		for (Aisha_Competitor c : Aisha_CompetitorList) 
		{
			g = c.getGender();
			if(g == 'F')
			{
				index = 0;
			}
			else index = 1;
			freqGender[index]++;
		}
		//create a report
		String report = "\nNUMBER OF COMPETITORS FEMALE AND MALE: \n\n";
		report += String.format("%-10s", "Females")+ String.format("%-10s", "Males") +"\n";
		report += String.format("%-10s", freqGender[0]) + String.format("%-10s", freqGender[1])+"\n";
		return report;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////

	
	/** This method calculates the highest overall score from all the Competitors and prints their full and short details.
	 * @return It returns the report which includes the Full and Short Details of the player with the highest score.
	 */
	public String getDetailsOfHighestOverallScoreComp()
	{
		double max = 0.0, curr_score;
		int max_cn = 100;
		
		for(Aisha_Competitor c : Aisha_CompetitorList)
		{
			curr_score = c.getOverallScore();
			if(curr_score > max)
			{
				max = curr_score;
				max_cn = c.getNum();
			}
		}
		String report = "";
		for(Aisha_Competitor c : Aisha_CompetitorList)
		{
			if(c.getNum() == max_cn)
			{
				report += "\n" + c.getFullDetails();
				report += "\n" + c.getShortDetails();
				report = report + "\n--------------------------------------------------------\n";
				
			}
		}
		return report;
		
	}
	
/////////////////////////////////////////////////////////////////////////////////	
	
	/** This method returns the Averages of all the Competitors and prints them with lastName, firstName format. 
	 * @return report - The String report with all Averages.
	 */
	public String getAverages()
	{
		String report = "\nThe Overall Averages for all Competitors are: \n";
		for(Aisha_Competitor c : Aisha_CompetitorList)
		{
			report += String.format("%-17s", c.getName().getLastCommaFirst());
			report += ": " + String.format("%1.3s", Double.toString(c.getOverallScore())) + "\n";
		}
		report = report + "\n---------------------------------------------\n";
		return report;
	}
	
/////////////////////////////////////////////////////////////////////////////////	
	
	/** This method returns the total scores out of 100 points.
	 * @return report - It returns the report with all scores out of 100 points.
	 */
	public String totalScores()
	{
		String report = "\n";
		for(Aisha_Competitor c : Aisha_CompetitorList)
		{
			report += "\n" + String.format("%-10s", c.getName().getFirst()) + ": ";
			report += c.getTotalScores()+"/100";
			//report = report + "---------------------\n";
		}
		return report;
	}
	
/////////////////////////////////////////////////////////////////////////////////	
	
	/** This method calculates the score field in which all Competitors scored the highest.
	 * @return report - The result of the highest scoring field in String format.
	 */
	public String mostScoring()
	{
		String report = "";
		double [] sum;	int [] curr_scores;
		sum = new double [5];	curr_scores = new int [5];
		
		for(Aisha_Competitor c : Aisha_CompetitorList)
		{
			curr_scores = c.getScoreArray();
			for(int i = 0; i<curr_scores.length; i++)
			{
				sum[i] = sum[i] + (double)curr_scores[i];  
			}
		}
		double size = (double)Aisha_CompetitorList.size();
		sum[0] = (sum[0]/(size*10))*100;			//find percentage of scoring LAT
		sum[1] = (sum[1]/(size*20))*100;			//find percentage of scoring BHS
		sum[2] = (sum[2]/(size*30))*100;			//find percentage of scoring OS	
		sum[3] = (sum[3]/(size*30))*100;			//find percentage of scoring DS
		sum[4] = (sum[4]/(size*10))*100;			//find percentage of scoring TFS
		
		double max = 0.0;
		int max_index = 0;
		for(int j = 0; j<sum.length; j++)
		{
			if(sum[j]>max)
			{
				max_index = j;
				max = sum[j];
			}
		}
		
		switch(max_index)
		{
			case 0: report = "Leadership and Teamwork (LAT) is the Most Scoring Field.\n";
					report = report + "\n--------------------------------------------------------\n";
					break;
			case 1: report = "\nBall Handling Skills (BHS) is the Most Scoring Field.\n";
			 		report = report + "\n---------------------------------------------------\n";
					break;
			case 2: report = "\nOffense Score (OS) is the Most Scoring Field.\n";
					report = report + "\n-------------------------------------------------\n";
					break;
			case 3: report = "\nDefense Score (DS) is the Most Scoring Field.\n";
					report = report + "\n-------------------------------------------------\n";
					break;
			case 4: report = "\nTricks and Free Style (TFS) is the Most Scoring Field.\n";
					report = report + "\n--------------------------------------------------------\n";
					break;
			default: report = "\nError has occured.\n";
			 		 report = report + "\n-------------------\n";
		}
		
		return report;
	}
	
		//LAT out of 10
		//BHS out of 20
		//OS out of 30
		//DS out of 30
		//TFS out of 10

/////////////////////////////////////////////////////////////////////////////////

	/** This method calculates the score field in which all Competitors scored the lowest.
	 * @return report - The result of the lowest scoring field in String format.
	 */
	public String leastScoring()
	{
		String report = "";
		double [] sum;	int [] curr_scores;
		sum = new double [5];	curr_scores = new int [5];
		
		for(Aisha_Competitor c : Aisha_CompetitorList)
		{
			curr_scores = c.getScoreArray();
			for(int i = 0; i<curr_scores.length; i++)
			{
				sum[i] = sum[i] + (double)curr_scores[i];  
			}
		}
		double size = (double)Aisha_CompetitorList.size();
		sum[0] = (sum[0]/(size*10))*100;			//find percentage of scoring LAT
		sum[1] = (sum[1]/(size*20))*100;			//find percentage of scoring BHS
		sum[2] = (sum[2]/(size*30))*100;			//find percentage of scoring OS	
		sum[3] = (sum[3]/(size*30))*100;			//find percentage of scoring DS
		sum[4] = (sum[4]/(size*10))*100;			//find percentage of scoring TFS
		
		double min = 100.0;			//maximum possible score, percentage wise
		int min_index = 0;
		for(int j = 0; j<sum.length; j++)
		{
			if(sum[j]<min)
			{
				min_index = j;
				min = sum[j];
			}
		}
		
		switch(min_index)
		{
			case 0: report = "\nLeadership and Teamwork (LAT) is the Least Scoring Field.\n";
			 		report = report + "\n--------------------------------------------------------\n";
					break;
			case 1: report = "\nBall Handling Skills (BHS) is the Least Scoring Field.\n";
			 		report = report + "\n----------------------------------------------------\n";
					break;
			case 2: report = "\nOffense Score (OS) is the Least Scoring Field.\n";
			 		report = report + "\n-------------------------------------------------\n";
					break;
			case 3: report = "\nDefense Score (DS) is the Least Scoring Field.\n";
			 		report = report + "\n-------------------------------------------------\n";
					break;
			case 4: report = "\nTricks and Free Style (TFS) is the Least Scoring Field.\n";
			 		report = report + "\n--------------------------------------------------------\n";
					break;
			default: report = "\nError has occured.\n";
			 		 report = report + "\n-------------------\n";
		}
		
		return report;
	}
	
/////////////////////////////////////////////////////////////////////////////////

}
