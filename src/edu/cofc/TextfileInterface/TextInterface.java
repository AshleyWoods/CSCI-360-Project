package edu.cofc.TextfileInterface;

import edu.cofc.Administration.Admin;

import edu.cofc.Administration.Controller.AdminMenuController;
import edu.cofc.Vote.Voter;
import javafx.scene.text.Text;

import java.sql.*;
import javax.swing.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.SecureRandom;


//Singleton Class
public class TextInterface {
//Assigned any and all accesses to the database (text files) -- Information Expert
    private boolean officialTally;
    private Voter voter;
    private SecureRandom rand = new SecureRandom();
    private byte bytes[];
    private String salt;
    private static final String COMMA = ",";
    private static final String NEWLINE = "\n";
    public static TextInterface textInterfaceInstance;

    //FILE HEADER -- ADDED SALT FOR SECURITY PURPOSES
    private static final String HEADER = "firstName,lastName,middleInitial,suffix,sex,race,ssn,"
    		+ "streetResidential,cityResidential,stateResidential,zipResidential,aptResidential,inCityLimits,"
    		+ "streetMAiling,cityMailing,stateMailing,zipMailing,birthdayDate,birthdayMonth,birthdayYear,"
    		+ "homePhone,workPhone,dlNumber,voterID,salt,hasVoted";
    //FILE HEADER FOR ADMIN LOGIN
    private static final String ADMINHEADER = "password,username";
    private static final String VOTEHEADER = "bugs bunny,road runner,daffy duck,wiley e cyote,peter parker,spider man,batman,bruce wayne,total submitted";
 
    public TextInterface(){
        this.officialTally = false;
    }

    public boolean getOfficialTallyBoolean() {
        return this.officialTally;
    }

    //THIS IS A SINGLETON CLASS, so this will give access to the only instance of it.
    public static TextInterface getInstance(){
		if (textInterfaceInstance == null) {
			textInterfaceInstance = new TextInterface();
		}
		return textInterfaceInstance;
	}

    //Registration Methods -- Information Expert
    //See if a voter is registered
    //searches the database for the voter's information and returns true if the voter is there and false if otherwise
    //ID is the identification the voter gives and loginType is where the database should look for the information
    //loginTypes:
    //1-DLN
	//2-VRN
    //3-SSN
    //4- check if the voter is registered (SSN)? isnt that 3? 
 
    public boolean voterRegistered( String loginTypeIDNum, int loginType) throws FileNotFoundException {
    	String file = "registration.csv";
    	boolean found = false;
    	
    	try {
    		FileReader fileReader = new FileReader(file);
    		BufferedReader buffReader = new BufferedReader(fileReader);
    		String currLine;
    		String[] lineAsArray;
 
    	
    	//DLN LOGIN
	    		if(loginType == 1) {
	    			String searchNum = loginTypeIDNum;
    				while((currLine = buffReader.readLine()) != null) {
    	    			lineAsArray = splitTheLine(currLine);
	    	
    	    			String index22 = lineAsArray[22];
	    				if(index22.equals(searchNum)) {
	    					System.out.println("I am in the if statement- they match");

	    					found = true;
	    				}//END IF 
	    			}//END WHILE
	    		}//END IF
	    		
	      //VRN LOGIN
	    		  else if(loginType == 2) { 
	    			  String searchNum = loginTypeIDNum;
	    			  while((currLine = buffReader.readLine()) != null) {
	    	    			lineAsArray = splitTheLine(currLine);
		    				

	    	    			//check to see if vrn can be found
	    	    			String index23 = lineAsArray[23];
		    				if(index23.equals(searchNum)) {
		    					System.out.println("I am in the if statement- they match");

		    					found = true;
		    				}//END IF 
	    			  }//END WHILE
	    		  }//END ELSE IF
	    		  
	    	
	    //SSN LOGIN	
	    //ASHLEY- I LEFT COMMENTS IN THIS ELSE IF SO YOU COULD SEE MY THOUGHT PROCESS THROUGH TESTING THAT I DID
	    //FEEL FREE TO DELETE IF YOU DON'T NEED IT :)
	    			else if (loginType ==3){
	    				String searchNum = loginTypeIDNum;
	    				//**NOTE**: I found the condition in the while loop from stack overflow.
	    				while((currLine = buffReader.readLine()) != null) {
	    	    			lineAsArray = splitTheLine(currLine);
		    				
		    		/*		//go inside the array to search for a match at index 6(ssn)
		    				for(int j =0; j < lineAsArray.length; j++ ) {
		    					System.out.println("i = " + j + ":" +lineAsArray[j]);
		    				}
		    		
		    				System.out.println("at [6]:"+lineAsArray[6]);
		    				System.out.println("search num:" + searchNum);
		    				
		    				System.out.println(index6.equals(searchNum));
		    				*/
	    	    			
	    	    			//check to see if social can be found
	    	    			String index6 = lineAsArray[6];
		    				if(index6.equals(searchNum)) {
		    					System.out.println("I am in the if statement- they match");

		    					found = true;
		    				}
		    			
	    				}//END WHILE
	    			}//END ELSE IF
	    	
	    	//1-3 ARE THE ONLY OPTIONS, SHOULD RETURN FALSE IF ANY OTHER NUMBER IS GIVEN		
	    			else {
	    				System.out.println("the parameters given are not valid");
	    			}//END ELSE
    	}//END try
    	
    	catch(Exception e) {
    		e.printStackTrace();
			
			}//end catch
    	
		return found;
		
    	
  }//END VOTERREGISTERED
    
   //HELPER METHOD FOR VOTER REGISTERED CLASS TO SPLIT THE LINE IN A CSV FILE BY COMMA SEPERATOR
   public String[] splitTheLine(String someLine) {
	   return someLine.split(COMMA);
   }

    //register a voter -- Information Expert
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
    			//pw.println(NEWLINE);
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
			writer.append(voter.getStateResidental());
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
			//writer.append(NEWLINE);
			writer.flush();
			writer.close();
    		System.out.println("Written to file successfully, check in your file browser to find it");
    	 
    	}//end try 
    	catch(Exception e){
    		System.out.println("ERROR!! The CSV file did not write successfuly! ");
    		e.printStackTrace();

    	}//end catch

    	}//end registerVoter
    

    //Login Methods -- Information Expert
    //see if a voter's login is valid--use voterRegistered from the registration methods section

    //TEXTFILE THAT HOLDS ADMIN LOGIN INFORMATION-- SEPERATED FROM VOTER TEXTFILE. 
    public void registerAdmin() {
    	try {
         	//give the csv file a name
        	String fileName = "adminLogin.csv";
        	File adminFile = new File(fileName);
        	//TRUE if Exists, FALSE if it doesn't
        	boolean exists = adminFile.exists();
        	System.out.println(exists);
        	
         	if(!exists) {
    			System.out.println("in the if");
    			FileOutputStream output = new FileOutputStream(fileName, true);
    			PrintWriter pw = new PrintWriter(output);
    			pw.println(ADMINHEADER);
    			//pw.println(NEWLINE);
    			pw.close();
    		
    		}//END IF
         	FileOutputStream fileOUT = new FileOutputStream(fileName, true);
			FileWriter writer = new FileWriter(fileName, true);
			//insert values into file
 			//MISAE LOGIN INFORMATION
			writer.append("bubbles");
			writer.append(COMMA);
			writer.append("misae");
			//ASHLEY LOGIN INFORMATION
			writer.append(NEWLINE);
			writer.append("buttercup");
			writer.append("ashley");
			writer.append(NEWLINE);
			//DR.X LOGIN INFORMATION
			//password
			//username
			writer.append("xmen");
			writer.append("drX");
			writer.flush();
			writer.close();
    		System.out.println("Written to file successfully, check in your file browser to find it");
		
    	}//END TRY
    	catch(Exception e) {
    		System.out.println("ERROR!! ADMIN INFORMATION DID NOT STORE TO FILE!!");
    		e.printStackTrace();
    	}//END CATCH
    }
    
    //see if an administrator's login is valid
    public boolean adminLoginValid(Admin operator) {
        //checks the database for the login information from the admin database files and returns the result
    	String file = "adminLogin.csv";
    	boolean found = false;
    	
    	try {
    		FileReader fileReader = new FileReader(file);
    		BufferedReader buffReader = new BufferedReader(fileReader);
    		String currLine;
    		String[] lineAsArray;
    		String password = operator.getPassword();
    		String username = operator.getUsername();
    		//System.out.println(password);
    		//System.out.println(username);
    		
			 while((currLine = buffReader.readLine()) != null) {
	    			lineAsArray = splitTheLine(currLine);
	    			//check to see if password can be found
	    			String index0 = lineAsArray[0];
	    			String index1 = lineAsArray[1];
	    			
	
  				if(index0.equals(password)) {
  					System.out.println("I am in the if statement- the password matches");
  					if(index1.equals(username)) {
  						found = true;
  					}//END INNER IF TO CHECK USER NAME TO MATCH PASS

  				}//END OUTER IF TO CHECK FOR A PASSWORD MATCH 
			  }//END WHILE
    	}//END TRY
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	System.out.println("password and user name match status: "+ found);
        return found;
    }


    public void saveVote(Voter voter, List candidates, List votes) throws FileNotFoundException {
        //the database adds the tally to multiple places, first to the total votes made
        //then to each candidate individually
        //then marks the voter in the database as having voted along with saving the number of votes cast
      	//give the csv file a name
    	try {
    		String fileName = "votes.csv";
    		File voteFile = new File(fileName);
    		//TRUE if Exists, FALSE if it doesn't
    		boolean exists = voteFile.exists();
    		System.out.println(exists);
    		//mark the voter as voted, but don't put their information in voter csv file, votes shouldnt be connected to voter right?
    		//hasVoted = true;
    		
    		if(!exists) {
    			System.out.println("in the if");
    			FileOutputStream output = new FileOutputStream(fileName, true);
    			PrintWriter pw = new PrintWriter(output);
    			pw.println(VOTEHEADER);
    			pw.close();
    			
    			
    		}//END IF
    		FileOutputStream fileOUT = new FileOutputStream(fileName, true);
			FileWriter writer = new FileWriter(fileName, true);
			String votesList = votes.toString().replace("[", "").replace("]", "");
			String[] votesArray = splitTheLine(votesList);

			int numVotes = 0; 
			
			for (int j =0; j < votesArray.length; j++) {
				votesArray[j] = votesArray[j].trim();
				
				if(votesArray[j].equals("1")|| votesArray[j].equals("[1") || votesArray[j].equals("1]")) {
					numVotes++;		
				}//END IF 
			}//END FOR
			
			String voteCount = String.valueOf(numVotes);
			System.out.println("vote count: "+ voteCount);
			writer.append(votesList);
			writer.append(COMMA);
			writer.append(voteCount);
			writer.append(NEWLINE);
			writer.flush();
			writer.close();
    		System.out.println("Written to file successfully, check in your file browser to find it");
    	}//END TRY	
    	catch(Exception e){
    		System.out.println("ERROR!! The CSV file did not write successfuly! ");
    		e.printStackTrace();
    	}//END CATCH
    	
    }//END SAVE VOTE()

    //Admin Methods
    //Get an official tally count -- Information Expert
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

    //download official tally as a file -- Information Expert
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

    //get an unofficial tally count  -- Information Expert
    public int getUnofficialTally() {
        //takes the number of votes from each candidate in the database and displays it with not votes counted
        return 0;
    }

    //get a recount -- Information Expert
    public int getRecount() {
        //take number of votes from each candidate and total it
        //compare with number of votes from each voter
        //if it's the same, return the total, if it is not, do it again and return the result
        return 0;
    }



}
