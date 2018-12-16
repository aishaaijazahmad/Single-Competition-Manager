import javax.swing.JOptionPane;
/** This is Aisha's Competitor Manager class which is run by the admin to check details by the Competitor Number.
 * Dated: 23/10/2018
 * @author Aisha Aijaz Ahmad
 * @version 1.0
 */
public class Aisha_CompetitorManager 
{
/////////////////////////////////////////////////////////////////////////////////
	
	//PRIVATE OBJECT
	private Aisha_CompetitorList allCompetitors;
	
/////////////////////////////////////////////////////////////////////////////////
	
	//INITIALIZE OBJECT USING CONSTRUCTOR
	/**
	 * This is the constructor which initializes the object for the Competitor List.
	 */
	public Aisha_CompetitorManager() 
	{
		allCompetitors = new Aisha_CompetitorList();
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	//RUN
	/**
	 * This is the method which outputs the report overall to the console as well the text file and also shows the dialog box for the manager to check the short details of the Competitor by the Competitor Number.
	 */
	public void run() 
	{
		//READ THE FILE
		allCompetitors.readFile("StudentList.csv");
		
		//REPORT, PART 1: COMPETITOR TABLE
		String report = "\nPART 1: Competitor Table\n" + allCompetitors.getTableOfCompetitors();
		
		//REPORT, PART 2: WHO SCORED THE HIGHEST OVERALL?
		report = report + "\nPART 2: Details of Competitor with Highest Overall Score\n" + allCompetitors.getDetailsOfHighestOverallScoreComp();
		
		//REPORT, PART 3: STATISTIC 1 - TOTALS (INTEGER OUT OF 100)
		report = report + "\nPART 3: Statistic 1 - Totals (marking out of 100)\n";
		report = report + "\nLeadership and Teamwork - 10 points";
		report = report + "\nBall Handling Score - 20 points";
		report = report + "\nOffense Score - 30 points";
		report = report + "\nDefense Score - 30 points";
		report = report + "\nTricks and Free Style - 10 points";
		report = report + "\nTOTAL = 100 points";
		report = report + allCompetitors.totalScores();
		report = report + "\n\n---------------------------------------------";
		
		//REPORT, PART 4: STATISTIC 2 - ALL AVERGAES SCORES (DECIMAL OUT OF 5)
		report = report + "\n\nPART 4: Statistic 2 - Averages\n" + allCompetitors.getAverages();
		
		//REPORT, PART 5: STATISTIC 3 - MOST SCORING FIELD
		report = report + "\nPART 5: Statistic 3 - Most Scoring Field (by %)\n" + allCompetitors.mostScoring();
		
		//REPORT, PART 6: STATISTIC 4 - LEAST SCORING FIELD
		report = report + "\nPART 6: Statistic 4 - Least Scoring Field (by %)\n" + allCompetitors.leastScoring();
		
		//REPORT, PART 7a: SCORES FREQUENCY REPORT
		report = report + "\nPART 7a: Scores Frequency Report\n" +allCompetitors.getScoresFrequencyReport();

		//REPORT, PART 7b: GENDER FREQUENCY REPORT
		report = report + "\nPART 7b: Gender Frequency Report\n" +allCompetitors.getGenderFrequencyReport();

		//OUTPUT REPORT TO CONSOLE
		System.out.println(report);
						
		//try out the search, give 3 tries
		boolean ok = false;
		int count = 0;
		String outPut = "";
		while (!ok && count <=2) 							//number of tries = 3
		{
			String cn = JOptionPane.showInputDialog(null, "Enter Competitor Number:");
			Aisha_Competitor c = allCompetitors.findByNum(Integer.parseInt(cn));
			count++;
		
			if (c!=null) 
			{
				outPut += "--------------------------------------------\nCN entered is valid. See Short Details below:\n";
				outPut += c.getShortDetails();
				System.out.println(outPut);
				ok = true;
			}
			else 
			{
				System.out.println("Incorrect CN!");
				if (count <= 2) 							//number of tries = 3
				{
					System.out.println("Try again.\n");
				}
				else 
				{
					System.out.println("Reached Maximum Number of Tries. End of Program"); //end message.
					System.exit(0);														   //normal exit.
				}
			}
		} 
		
		//WRITE TO FILE
		allCompetitors.writeToFile("StudentsOut.txt", report+outPut); 						//out report and output to file.
	}	
/////////////////////////////////////////////////////////////////////////////////
	
}
