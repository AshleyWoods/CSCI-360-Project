package edu.cofc.TextfileInterface;

import edu.cofc.Administration.Admin;
import edu.cofc.Administration.Controller.AdminMenuController;
import edu.cofc.Vote.Voter;
import java.sql.*;
import javax.swing.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.security.SecureRandom;


public class TextInterface {
//Assigned any and all accesses to the database (text files) -- Information Expert
    private boolean officialTally;
    private Voter voter;
    private SecureRandom rand = new SecureRandom();
    private byte bytes[];
    private String salt;
    private static final String COMMA = ",";
    private static final String NEWLINE = "\n";
    
    //FILE HEADER -- ADDED SALT FOR SECURITY PURPOSES
    private static final String HEADER = "firstName, lastName, middleInitial, suffix, sex, race, ssn, "
    		+ "streetResidential, cityResidential, stateResidential, zipResidential, aptResidential, inCityLimits,"
    		+ "streetMAiling, cityMailing, stateMailing, zipMailing, birthdayDate, birthdayMonth, birthdayYear, "
    		+ "homePhone, workPhone, dlNumber, voterID, salt, hasVoted";
 
    public TextInterface(){
        this.officialTally = false;
    }

    public boolean getOfficialTallyBoolean() {
        return this.officialTally;
    }

    //Registration Methods
    //See if a voter is registered
    //searches the database for the voter's information and returns true if the voter is there and false if otherwise
    //ID is the identification the voter gives and loginType is where the database should look for the information
    //loginTypes:
    //1-DLN
	//2-VRN
    //3-SSN
    //4- check if the voter is registered (SSN)? isnt that 3? 
 
    public boolean voterRegistered( String loginTypeIDNum, int loginType) {
   
    	try {
    		if(loginType == 1) {
    	    		return true;
    			}
    			else if(loginType == 2) {
    	    		return true;
    			}
    			else {
    	    		return true;
    			}
    	}//end try 
    	catch(Exception e) {
    		e.printStackTrace();
			
			}//end catch
		return false;
		
    	
    	
    }//END VOTERREGISTERED

    //register a voter
    public void registerVoter(Voter voter) throws FileNotFoundException {

    	try {
         	//give the csv file a name
        	String fileName = "registration.csv";
        	File registrationFile = new File(fileName);
        	//TRUE if Exists, FALSE if it doesn't
        	boolean exists = registrationFile.exists();
        	System.out.println(exists);

        	//Making the salt to be stored with the voter and to encrypt storage/help voters log in later
        	bytes = new byte[10];
			rand.nextBytes(bytes);
        	System.out.println(bytes);
        	salt = "";
    		for (int i = 0; i<bytes.length; i++){
    			salt = salt + bytes[i];
			}

        	if(!exists) {
    			System.out.println("in the if");
    			FileOutputStream output = new FileOutputStream(fileName, true);
    			PrintWriter pw = new PrintWriter(output);
    			pw.println(HEADER);
    			pw.println(NEWLINE);
    			pw.close();
    			
    			
    		}
    		FileOutputStream fileOUT = new FileOutputStream(fileName, true);
			FileWriter writer = new FileWriter(fileName, true);
			//insert values into file
 			writer.append(voter.getFirstName());
			writer.append(COMMA);
			writer.append(voter.getLastName());
			writer.append(COMMA);
			writer.append(voter.getMiddleInitial());
			writer.append(COMMA);
			if(voter.getSuffix()!= null) {
				writer.append(voter.getSuffix());
				writer.append(COMMA);
			}
			writer.append(voter.getSex());
			writer.append(COMMA);
			writer.append(voter.getRace());
			writer.append(COMMA);
			writer.append(voter.getSSN());
			writer.append(COMMA);
			writer.append(voter.getStreetResidential());
			writer.append(COMMA);
			writer.append(voter.getCityResidential());
			writer.append(COMMA);
			writer.append(voter.getZipResidential());
			writer.append(COMMA);
			writer.append(voter.getAptResidential());
			writer.append(COMMA);
			writer.append(voter.getCityLimits());
			writer.append(COMMA);
			writer.append(voter.getStreetMailing());
			writer.append(COMMA);
			writer.append(voter.getCityMailing());
			writer.append(COMMA);
			writer.append(voter.getStateMailing());
			writer.append(COMMA);
			writer.append(voter.getZipMailing());
			writer.append(COMMA);
			writer.append(voter.getBirthdayDate());
			writer.append(COMMA);
			writer.append(voter.getBirthdayMonth());
			writer.append(COMMA);
			writer.append(voter.getBirthdayYear());
			writer.append(COMMA);
			writer.append(voter.getHomePhone());
			writer.append(COMMA);
			writer.append(voter.getWorkPhone());
			writer.append(COMMA);
			writer.append(voter.getDLNumber());
			writer.append(COMMA);
			writer.append(String.valueOf(voter.getvoterID()));
			writer.append(COMMA);
			writer.append(salt);
			writer.append(COMMA);
			writer.append("false");
			writer.append(NEWLINE);
			writer.flush();
			writer.close();
    		System.out.println("Written to file successfully, check in your file browser to find it");
    	 
    	}//end try 
    	catch(Exception e){
    		System.out.println("ERROR!! The CSV file did not write successfuly! ");
    		e.printStackTrace();

    	}//end catch

    	}//end registerVoter
    

    //Login Methods
    //see if a voter's login is valid--use voterRegistered from the registration methods section

    //see if an administrator's login is valid
    public boolean adminLoginValid(Admin opperator) {
        //checks the database for the login information from the admin database files and returns the result

        return false;
    }


    public void saveVote(Voter voter, List candidates, List votes) throws FileNotFoundException {
        //the database adds the tally to multiple places, first to the total votes made
        //then to each candidate individually
        //then marks the voter in the database as having voted along with saving the number of votes cast
      	//give the csv file a name
    	try {
    		String fileName = "votes.csv";
    		File registrationFile = new File(fileName);
    		//TRUE if Exists, FALSE if it doesn't
    		boolean exists = registrationFile.exists();
    		System.out.println(exists);
    		
    		if(!exists) {
    			System.out.println("in the if");
    			FileOutputStream output = new FileOutputStream(fileName, true);
    			PrintWriter pw = new PrintWriter(output);
    			pw.println(HEADER);
    			pw.println(NEWLINE);
    			pw.close();
    			
    			
    		}//END IF
    		FileOutputStream fileOUT = new FileOutputStream(fileName, true);
			FileWriter writer = new FileWriter(fileName, true);
			//insert values into file
 			writer.append(voter.getFirstName());
			writer.append(COMMA);
			writer.append(voter.getLastName());
			writer.append(COMMA);
			writer.append(voter.getMiddleInitial());
			writer.append(COMMA);
    	}//END TRY	
    	catch(Exception e){
    		System.out.println("ERROR!! The CSV file did not write successfuly! ");
    		e.printStackTrace();
    		}//END CATCH
    	
    }//END SAVE VOTE()

    //Admin Methods
    //Get an official tally count
    public int getOfficialTally() {
        //set officialTally to true and store the result in the database
        //if officialTally is true, grab results from the database
            //take number of votes from each candidate and total it
            //compare with number of votes from each voter
            //initiate recount if it's not the same
            //display total if it is
        this.officialTally = true;
        //AdminMenuController.officialTally = true;
        return 0;
    }

    //download official tally as a file
    public void downloadOfficialTally() throws IOException{
        //No errors are thrown but it doesn't save a file? -- Currently saves to desktop instead
        JFileChooser locationPrompt = new JFileChooser();
        locationPrompt.setCurrentDirectory(new java.io.File("."));
        locationPrompt.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int fileLocation = locationPrompt.showOpenDialog(null);
        File doc = new File("c://Users//it//Desktop//OfficialTally.txt");
        //this line throws an error, says that the file does not exist
        //File doc = new File((Integer.toString(fileLocation) +"OfficialTally.txt"));
        PrintWriter writer = new PrintWriter(doc);
        //insert data into newly created file
        writer.close();
    }

    //get an unofficial tally count
    public int getUnofficialTally() {
        //takes the number of votes from each candidate in the database and displays it with not votes counted
        return 0;
    }

    //get a recount
    public int getRecount() {
        //take number of votes from each candidate and total it
        //compare with number of votes from each voter
        //if it's the same, return the total, if it is not, do it again and return the result
        return 0;
    }



}
