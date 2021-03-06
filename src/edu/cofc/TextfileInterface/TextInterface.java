package edu.cofc.TextfileInterface;

import edu.cofc.Administration.Admin;

import edu.cofc.TextfileInterface.src.org.mindrot.jbcrypt.BCrypt;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.awt.*;
import java.util.Base64;
import edu.cofc.Administration.Controller.AdminMenuController;
import edu.cofc.Vote.Voter;
import javafx.scene.text.Text;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Base64;
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
    private static final String COMMA = ",";
    private static final String NEWLINE = "\n";
    public static TextInterface textInterfaceInstance;
    

    //FILE HEADER -- ADDED SALT FOR SECURITY PURPOSES
    private static final String HEADER = "firstName,lastName,middleInitial,suffix,sex,race,ssn,"
    		+ "streetResidential,cityResidential,stateResidential,zipResidential,aptResidential,inCityLimits,"
    		+ "streetMAiling,cityMailing,stateMailing,zipMailing,birthdayDate,birthdayMonth,birthdayYear,"
    		+ "homePhone,workPhone,dlNumber,voterID,hasVoted";
    //FILE HEADER FOR ADMIN LOGIN
    private static final String ADMINHEADER = "password,username";
    private static final String VOTEHEADER = "bugs bunny,road runner,daffy duck,wiley e cyote,peter parker,batman,spider man,bruce wayne,total submitted";
    private static final String TALLYHEADER = "bugs bunny, road runner, daffy duck, wiley e cyote, peter paker, batman, spiderman, bruce wayne";
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

	public String encrypt(String item){
		String encrypt = "";
		try {
			byte[] key = "Ab9xZ&l".getBytes("UTF-8");
			SecretKeySpec secKey = prepKey(key);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, secKey);
			byte[] encrypted = cipher.doFinal(item.getBytes("UTF-8"));
			encrypt = Base64.getEncoder().encodeToString(encrypted);
			return encrypt;
		}
		catch (Exception e) {
		}
		return encrypt;
	}

	private SecretKeySpec prepKey (byte [] key) {
		byte [] k = new byte[16];
		try{
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			k = sha.digest(key);
			k = Arrays.copyOf(k,16);
		}
		catch(Exception e){}
		SecretKeySpec secKey = new SecretKeySpec(k, "AES");
		return secKey;
	}

	public String decrypt(String item){
		String decrypt = "";
		try{
			byte[] key = "Ab9xZ&l".getBytes("UTF-8");
			SecretKeySpec secKey = prepKey(key);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(item)));
		}catch(Exception e) {}
		return decrypt;
	}

	private String hash(String password) {
    	String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
    	return hashed;
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
 
    public boolean voterRegistered(String firstName, String lastName, String MI, String loginTypeIDNum, int loginType) throws FileNotFoundException {
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
	    	
    	    			String index22 = decrypt(lineAsArray[22]);
    	    			String hasVoted = lineAsArray[24];
    	    			String first = decrypt(lineAsArray[0]);
    	    			String last = decrypt(lineAsArray[1]);
    	    			String MiddleInitial = decrypt(lineAsArray[2]);
	    				if(first.equals(firstName)&& last.equals(lastName)&& MiddleInitial.equals(MI)&& index22.equals(searchNum)&& hasVoted.equals("false")) {
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
	    	    			String index23 = decrypt(lineAsArray[23]);
						    String hasVoted = lineAsArray[24];
						  String first = decrypt(lineAsArray[0]);
						  String last = decrypt(lineAsArray[1]);
						  String MiddleInitial = decrypt(lineAsArray[2]);
		    				if(first.equals(firstName)&& last.equals(lastName)&& MiddleInitial.equals(MI)&& index23.equals(searchNum) && hasVoted.equals("false")) {
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
	    	    			String index6 = decrypt(lineAsArray[6]);
							String hasVoted = lineAsArray[24];
							String first = decrypt(lineAsArray[0]);
							String last = decrypt(lineAsArray[1]);
							String MiddleInitial = decrypt(lineAsArray[2]);
		    				if(first.equals(firstName)&& last.equals(lastName)&& MiddleInitial.equals(MI)&& index6.equals(searchNum)&& hasVoted.equals("false")) {
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


        	if(!exists) {
    			System.out.println("in the if");
    			FileOutputStream output = new FileOutputStream(fileName, true);
    			PrintWriter pw = new PrintWriter(output);
    			pw.print(HEADER);
    			//pw.println(NEWLINE);
    			pw.close();
    			
    			
    		}
    		FileOutputStream fileOUT = new FileOutputStream(fileName, true);
			FileWriter writer = new FileWriter(fileName, true);
			//insert values into file
			writer.append(encrypt(voter.getFirstName()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getLastName()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getMiddleInitial()));
			writer.append(COMMA);
			if(voter.getSuffix()!= null) {
				writer.append(encrypt(voter.getSuffix()));
				writer.append(COMMA);
			}
			writer.append(encrypt(voter.getSex()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getRace()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getSSN()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getStreetResidential()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getCityResidential()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getStateResidental()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getZipResidential()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getAptResidential()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getCityLimits()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getStreetMailing()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getCityMailing()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getStateMailing()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getZipMailing()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getBirthdayDate()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getBirthdayMonth()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getBirthdayYear()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getHomePhone()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getWorkPhone()));
			writer.append(COMMA);
			writer.append(encrypt(voter.getDLNumber()));
			writer.append(COMMA);
			writer.append(encrypt(String.valueOf(voter.getvoterID())));
			writer.append(COMMA);
			writer.append("false");
			writer.append(NEWLINE);
			writer.flush();
			writer.close();
			System.out.println(String.valueOf(voter.getvoterID()));
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
    		

         	FileOutputStream fileOUT = new FileOutputStream(fileName, true);
			FileWriter writer = new FileWriter(fileName, true);
			//insert values into file
 			//MISAE LOGIN INFORMATION
			writer.append(hash("bubbles"));
			writer.append(COMMA);
			writer.append("misae");
			//ASHLEY LOGIN INFORMATION
			writer.append(NEWLINE);
			writer.append(hash("blossom") + ",");
			writer.append("ashley");
			writer.append(NEWLINE);
			//DR.X LOGIN INFORMATION
			//password
			//username
			writer.append(hash("xmen") + ",");
			writer.append("drX");
			writer.flush();
			writer.close();
    		System.out.println("Written to file successfully, check in your file browser to find it");
			}//END IF
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
    		buffReader.readLine();
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
	    			
  				if(BCrypt.checkpw(password, index0)) {
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
    	String first = voter.getFirstName();
    	String last = voter.getLastName();
    	String middle = voter.getMiddleInitial();
    	String social = voter.getSSN();
    	System.out.println(social);
    	System.out.println("first= " + first+ " last= "+ last+ " middle="+ middle + " social= " + social);
    	setHasVoted(voter.getFirstName(), voter.getLastName(), voter.getMiddleInitial());
	
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
				//System.out.print(votesArray[j]);
				if(votesArray[j].equals("1")|| votesArray[j].equals(" 1") || votesArray[j].equals("1 ")) {
					numVotes++;		
				}//END IF 
			}//END FOR
			//first vote choices 
		
		
			String voteCount = String.valueOf(numVotes);
			// System.out.println("vote count: "+ voteCount);
	
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
    public int[] getOfficialTally() {
        //set officialTally to true and store the result in the database
        //if officialTally is true, grab results from the database
            //take number of votes from each candidate and total it
            //compare with number of votes from each voter
            //initiate recount if it's not the same
            //display total if it is
		try {
			String fileName = "votes.csv";
			File voteFile = new File(fileName);
			//TRUE if Exists, FALSE if it doesn't
			boolean exists = voteFile.exists();
			System.out.println(exists);
			//mark the voter as voted, but don't put their information in voter csv file, votes shouldnt be connected to voter right?
			//hasVoted = true;

			if (!exists) {
				System.out.println("in the if");
				FileOutputStream output = new FileOutputStream(fileName, true);
				PrintWriter pw = new PrintWriter(output);
				pw.println(VOTEHEADER);
				pw.close();


			}//END IF
		}
		catch(Exception e){
			System.out.println("ERROR!! The CSV file did not write successfuly! ");
			e.printStackTrace();
		}//END CATCH


        this.officialTally = true;
        String file = "votes.csv";
      	int buggsBunny = 0; 
      	int daffyDuck = 0; 
      	int roadRunner = 0; 
      	int wileyCoyote = 0; 
      	int peterParker = 0; 
      	int spiderMan = 0; 
      	int batMan = 0; 
      	int bruceWayne = 0; 
      	int numVotes = 0; 

    	
    	
    	try {
    		FileReader fileReader = new FileReader(file);
    		BufferedReader buffReader = new BufferedReader(fileReader);
    		//READ IN THE FIRST LINE TO IN EFFECT SKIP IT IN THE WHILE LOOP 
    		buffReader.readLine();
    		String currLine;
    		String[] lineAsArray;
    		//ITERATE THROUGH THE TEXT FILE BY LINE
    		while((currLine = buffReader.readLine()) != null) {
    			//SPLIT THE LINE INTO AN ARRAY WITH SPLITHTELINE HELPER METHOD
    			//A SINGLE LINE = 1 BALLOT
    		
    			lineAsArray = splitTheLine(currLine);
    			
    			//STRIP THE WHITE SPACE 
    			for (int i = 0; i < lineAsArray.length; i++)
    			    lineAsArray[i] = lineAsArray[i].trim();
    			
    			//GRAB THE VALUE AT EACH INDEX OF THE ARRAY 
    			int buggsIndex = Integer.parseInt(lineAsArray[0]);
    			int roadIndex = Integer.parseInt(lineAsArray[1]);
    			int daffyIndex = Integer.parseInt(lineAsArray[2]);
    			int wileyIndex = Integer.parseInt(lineAsArray[3]);
    			int peterIndex = Integer.parseInt(lineAsArray[4]);
    			int batIndex = Integer.parseInt(lineAsArray[5]);
    			int spiderIndex = Integer.parseInt(lineAsArray[6]);
    			int bruceIndex = Integer.parseInt(lineAsArray[7]);
    			int numVotesPerVoter = Integer.parseInt(lineAsArray[8]);
    			//GO THROUGH THE BALLOT AND LOOK FOR "1" 
    			//IF A 1 IS FOUND ADD IT TO THE TOTAL COUNT PER CANDIDATE
    			if(buggsIndex == 1)
    				buggsBunny+= 1;
    			if(roadIndex == 1)
    				roadRunner+=1;
    			if(daffyIndex ==1)
    				daffyDuck+=1;
    			if(wileyIndex ==1)
    				wileyCoyote+=1;
    			if(peterIndex ==1)
    				peterParker+=1;
    			if(batIndex ==1)
    				batMan +=1;
    			if(spiderIndex ==1)
    				spiderMan+=1;
    			if(bruceIndex ==1)
    				bruceWayne+=1;
    			numVotes += numVotesPerVoter;
    		}//END WHILE
   
        	
    	}//END TRY
    	catch(Exception e) {
    		System.out.println("ERROR!! THE VOTES COULD NOT BE RETRIEVED TO PERFORM THE REQUESTED TASK");
    		e.printStackTrace();
    	}
        //AdminMenuController.officialTally = true;
 	   	int[] officialTallyArray = {buggsBunny, roadRunner, daffyDuck, wileyCoyote, peterParker, batMan, spiderMan, bruceWayne};
    	
	   	int compareVal = buggsBunny + roadRunner + daffyDuck + wileyCoyote + peterParker+ batMan + spiderMan + bruceWayne;
    	
	   	if(compareVal != numVotes)
	   		getRecount();
	   	
	 
		return officialTallyArray;
    }

    //download official tally as a file -- Information Expert
    public void downloadOfficialTally() throws IOException{
    /*    //No errors are thrown but it doesn't save a file? -- Currently saves to desktop instead
        JFileChooser locationPrompt = new JFileChooser();
        locationPrompt.setCurrentDirectory(new java.io.File("."));
        locationPrompt.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int fileLocation = locationPrompt.showOpenDialog(null);
        File doc = new File("c://Users//it//Desktop//OfficialTally.txt");
        //this line throws an error, says that the file does not exist
        //File doc = new File((Integer.toString(fileLocation) +"OfficialTally.txt"));
        PrintWriter writer = new PrintWriter(doc);
        //insert data into newly created file
        writer.close();*/
    	try {
         	//give the csv file a name
        	String fileName = "voteTally.txt";
        	File voteTally = new File(fileName);
        	//TRUE if Exists, FALSE if it doesn't
        	boolean exists = voteTally.exists();
        	System.out.println(exists);
    		int [] officialTallyArray  = getOfficialTally();

        	//IF THE FILE ALREADY EXISTS-- DELETE IT 
        	if(exists) {
        		voteTally.delete();
        	}
        	
        	FileOutputStream output = new FileOutputStream(fileName, true);
			PrintWriter pw = new PrintWriter(output);
			String [] helperString = {"Buggs Bunny", "Road Runner", "Daffy Duck", "Wiley E Coyote", "Peter Parker", "Batman", "Spiderman", "Bruce Wayne"};
			for (int j =0; j <officialTallyArray.length; j++) {
				pw.println(helperString[j] + ": " + officialTallyArray[j]);
			
			}//END OUTER FOR 
			pw.flush();
			pw.close();
 		
    }//END TRY 
    	catch(Exception e) {
    		System.out.println("ERROR!!FILE DID NOT DOWNLOAD CORRECTLY");
    		e.printStackTrace();
    	}//END CATCH
    }//END DOWNLOAD OFFICIAL TALLY

    //get an unofficial tally count  -- Information Expert
    //I MADE THE METHOD VOID BECAUSE I NEED THE VALUE OF 8 INTS
    public int[] getUnofficialTally() {
        //takes the number of votes from each candidate in the database and displays it with not votes counted


		try {
			String fileName = "votes.csv";
			File voteFile = new File(fileName);
			//TRUE if Exists, FALSE if it doesn't
			boolean exists = voteFile.exists();
			System.out.println(exists);
			//mark the voter as voted, but don't put their information in voter csv file, votes shouldnt be connected to voter right?
			//hasVoted = true;

			if (!exists) {
				System.out.println("in the if");
				FileOutputStream output = new FileOutputStream(fileName, true);
				PrintWriter pw = new PrintWriter(output);
				pw.println(VOTEHEADER);
				pw.close();


			}//END IF
		}
		catch(Exception e){
			System.out.println("ERROR!! The CSV file did not write successfuly! ");
			e.printStackTrace();
		}//END CATCH


		String file = "votes.csv";
      	int buggsBunny = 0; 
      	int daffyDuck = 0; 
      	int roadRunner = 0; 
      	int wileyCoyote = 0; 
      	int peterParker = 0; 
      	int spiderMan = 0; 
      	int batMan = 0; 
      	int bruceWayne = 0; 
    	
    	
    	try {
    		FileReader fileReader = new FileReader(file);
    		BufferedReader buffReader = new BufferedReader(fileReader);
    		//READ IN THE FIRST LINE TO IN EFFECT SKIP IT IN THE WHILE LOOP 
    		buffReader.readLine();
    		String currLine;
    		String[] lineAsArray;
    		//ITERATE THROUGH THE TEXT FILE BY LINE
    		while((currLine = buffReader.readLine()) != null) {
    			//SPLIT THE LINE INTO AN ARRAY WITH SPLITHTELINE HELPER METHOD
    			//A SINGLE LINE = 1 BALLOT
    		
    			lineAsArray = splitTheLine(currLine);
    			
    			//STRIP THE WHITE SPACE 
    			for (int i = 0; i < lineAsArray.length; i++)
    			    lineAsArray[i] = lineAsArray[i].trim();
    			
    			//GRAB THE VALUE AT EACH INDEX OF THE ARRAY 
    			int buggsIndex = Integer.parseInt(lineAsArray[0]);
    			int roadIndex = Integer.parseInt(lineAsArray[1]);
    			int daffyIndex = Integer.parseInt(lineAsArray[2]);
    			int wileyIndex = Integer.parseInt(lineAsArray[3]);
    			int peterIndex = Integer.parseInt(lineAsArray[4]);
    			int batIndex = Integer.parseInt(lineAsArray[5]);
    			int spiderIndex = Integer.parseInt(lineAsArray[6]);
    			int bruceIndex = Integer.parseInt(lineAsArray[7]);
    			//GO THROUGH THE BALLOT AND LOOK FOR "1" 
    			//IF A 1 IS FOUND ADD IT TO THE TOTAL COUNT PER CANDIDATE
    			if(buggsIndex == 1)
    				buggsBunny+= 1;
    			if(roadIndex == 1)
    				roadRunner+=1;
    			if(daffyIndex ==1)
    				daffyDuck+=1;
    			if(wileyIndex ==1)
    				wileyCoyote+=1;
    			if(peterIndex ==1)
    				peterParker+=1;
    			if (batIndex ==1)
    				batMan+=1;
    			if(spiderIndex ==1)
    				spiderMan+=1;
    			if(bruceIndex ==1)
    				bruceWayne+=1;
    		}//END WHILE
    	}//END TRY
    	catch(Exception e) {
    		System.out.println("ERROR!! THE VOTES COULD NOT BE RETRIEVED TO PERFORM THE REQUESTED TASK");
    		e.printStackTrace();
    	}
    
    	int unofficalTally[] = {buggsBunny, roadRunner, daffyDuck, wileyCoyote, peterParker,batMan, spiderMan, bruceWayne};
    	
    	return unofficalTally;
    }//END UNOFFICIAL TALLY 

    //get a recount -- Information Expert
    //RETURNS TRUE IF THE RECOUNT VALUES ARE THE SAME 
    public boolean getRecount() {
        //take number of votes from each candidate and total it
        //compare with number of votes from each voter
        //if it's the same, return the total, if it is not, do it again and return the result
      	String file = "votes.csv";
      	int buggsBunny = 0; 
      	int daffyDuck = 0; 
      	int roadRunner = 0; 
      	int wileyCoyote = 0; 
      	int peterParker = 0; 
      	int spiderMan = 0; 
      	int batMan = 0; 
      	int bruceWayne = 0; 
      	boolean match = false;
    	
    	
    	try {
    		FileReader fileReader = new FileReader(file);
    		BufferedReader buffReader = new BufferedReader(fileReader);
    		buffReader.readLine();
    		String currLine;
    		String[] lineAsArray;
    		//ITERATE THROUGH THE TEXT FILE BY LINE
    		while((currLine = buffReader.readLine()) != null) {
    			//SPLIT THE LINE INTO AN ARRAY WITH SPLITTHELINE HELPER METHOD
    			//A SINGLE LINE = 1 BALLOT
    			lineAsArray = splitTheLine(currLine);

				//STRIP THE WHITE SPACE
				for (int i = 0; i < lineAsArray.length; i++)
					lineAsArray[i] = lineAsArray[i].trim();

    			//GRAB THE VALUE AT EACH INDEX OF THE ARRAY 
				int buggsIndex = Integer.parseInt(lineAsArray[0]);
				int roadIndex = Integer.parseInt(lineAsArray[1]);
				int daffyIndex = Integer.parseInt(lineAsArray[2]);
				int wileyIndex = Integer.parseInt(lineAsArray[3]);
				int peterIndex = Integer.parseInt(lineAsArray[4]);
				int batIndex = Integer.parseInt(lineAsArray[5]);
				int spiderIndex = Integer.parseInt(lineAsArray[6]);
				int bruceIndex = Integer.parseInt(lineAsArray[7]);
    			//GO THROUGH THE BALLOT AND LOOK FOR "1" 
    			//IF A 1 IS FOUND ADD IT TO THE TOTAL COUNT PER CANDIDATE
    			if(buggsIndex == 1)
    				buggsBunny+= 1;
    			if(roadIndex == 1)
    				roadRunner+=1;
    			if(daffyIndex ==1)
    				daffyDuck+=1;
    			if(wileyIndex ==1)
    				wileyCoyote+=1;
    			if(peterIndex ==1)
    				peterParker+=1;
    			if (batIndex == 1)
    				batMan+=1;
    			if(spiderIndex ==1)
    				spiderMan+=1;
    			if(bruceIndex ==1)
    				bruceWayne+=1;
    		}//END WHILE
    	int[] recount = {buggsBunny, roadRunner, daffyDuck, wileyCoyote, peterParker, batMan, spiderMan, bruceWayne};
    	int [] officialTally = getOfficialTally();
    	match = Arrays.equals(recount,officialTally);
 
    	}//END TRY
    	catch(Exception e) {
    		System.out.println("ERROR!! THE VOTES COULD NOT BE RETRIEVED TO PERFORM THE REQUESTED TASK");
    		e.printStackTrace();
    	}//END CATCH 

        return match;
        
    }//END GET RECOUNT 

	//SETS ALL VOTERS 'HAS VOTED' TO FALSE SO THAT THEY CAN VOTE IN THE NEWEST ELECTION
	//ALSO RESETS THE VOTES.CSV FILE TO WIPE IT FOR THE NEW ELECTION
	public void beginElection () throws FileNotFoundException {
    	//Reset Votes.csv
		String fileName = "votes.csv";
		File voteFile = new File(fileName);
		//TRUE if Exists, FALSE if it doesn't
		boolean exists = voteFile.exists();
		if (exists) {
			boolean x = voteFile.delete();
			System.out.print("x");
		}
		try {
		//Set all 'hasVoted' to false for the new election
		String file = "registration.csv";
		String currLine;
		String[] lineAsArray;
		StringBuffer inputBuffer = new StringBuffer();
		FileReader fileReader = new FileReader(file);
		BufferedReader buffReader = new BufferedReader(fileReader);
	
		//**NOTE**: I found the condition in the while loop from stack overflow.
		while((currLine = buffReader.readLine()) != null) {
			lineAsArray = splitTheLine(currLine);
		
			inputBuffer.append(currLine);
	        inputBuffer.append('\n');
		}

		String inputStr = inputBuffer.toString();
		buffReader.close();
		System.out.println(inputStr);
		String[] lines = inputStr.split("\\r?\\n");

	      for (String line : lines) {
	    	  System.out.println(line);
	    	  lineAsArray = splitTheLine(line);
	    	  String newString = line.replaceAll("true", "false");
			  inputStr = inputStr.replace(line, newString);
	      }//END FOR 
	      FileOutputStream fileOut = new FileOutputStream("registration.csv");
	      fileOut.write(inputStr.getBytes());
	      fileOut.close();
	}//END TRY
	catch(Exception e) {
		e.printStackTrace();
	}//END CATCH
	}

	//SETS A VOTER'S 'HAS VOTED' TO TRUE
		public void setHasVoted(String firstname, String lastname, String middleInitial) {
		   	String file = "registration.csv";
	    	boolean found = false;
	    	//String searchNum = ssn;
	    	
	    	try {
	    		FileReader fileReader = new FileReader(file);
	    		BufferedReader buffReader = new BufferedReader(fileReader);
	    		
	    		String currLine;
	    		String[] lineAsArray;
	    		StringBuffer inputBuffer = new StringBuffer();
	    	
				//**NOTE**: I found the condition in the while loop from stack overflow.
	    		while((currLine = buffReader.readLine()) != null) {
	    			lineAsArray = splitTheLine(currLine);
	    			//System.out.print(lineAsArray[23]);
	    			//grab the entire file 
	    			inputBuffer.append(currLine);
			        inputBuffer.append('\n');
	    		}
	    		//System.out.println("I am out of the first while loop");
	    		String inputStr = inputBuffer.toString();
	    		buffReader.close();
	    		System.out.println(inputStr);
	    		String[] lines = inputStr.split("\\r?\\n");
	    		//System.out.println("array: " );
	    	      for (String line : lines) {
	    	    	  System.out.println(line);
	    	    	  lineAsArray = splitTheLine(line);
	    	  
	    	    		String first = decrypt(lineAsArray[0]);
	    				String last = decrypt(lineAsArray[1]);
	    				String MiddleInitial = decrypt(lineAsArray[2]);
	    				String hasVoted = lineAsArray[24];
	    				
	    				if(first.equals(firstname)&& last.equals(lastname)&& MiddleInitial.equals(middleInitial)) {
	    					//System.out.println("I am in the if statement- the voter has been found");
	    					found = true;
	    					//System.out.println("line to be replaced: " + line);
	    				
	    					String newString = line.replaceAll("false", "true");
	    					 inputStr = inputStr.replace(line, newString);
	    					//System.out.println("newString: " + newString);
	    					continue;
	    			        
	    	      }//END OUTER IF
	    	      }//END FOR 
	    		

	    	      //System.out.println("----------------------------------\n"  + inputStr);
	    	      FileOutputStream fileOut = new FileOutputStream("registration.csv");
			      fileOut.write(inputStr.getBytes());
			      fileOut.close();
	    	
	   
	 
	    	

	      
			}//END TRY
			catch(Exception e) {
				System.out.println("The file did not update successfully");
				e.printStackTrace();
			}//END CATCH 
		}//END SET HAS VOTED 
}