package edu.cofc.DataBase;

import edu.cofc.Vote.Voter;

import javax.swing.*;
import java.io.PrintWriter;
import java.util.List;
import java.io.IOException;
import java.io.File;

public class DatabaseInterface {

    private boolean officialTally;

    public DatabaseInterface(){
        this.officialTally = false;
    }

    //Registration Methods
    //See if a voter is registered
    public boolean voterRegistered(String firstName, String lastName, String middleInitial, int ID, int loginType){
        //searches the database for the voter's information and returns true if the voter is there and false if otherwise
        //ID is the identification the voter gives and loginType is where the database should look for the information
        //loginTypes:
        //1-DLN
        //2-VRN
        //3-SSN
        //4- check if the voter is registered (SSN)
        return false;
    }

    //register a voter
    public void registerVoter(String firstName, String lastName, String middleInitial, String suffix, String sex,
                               String race, int SSN, String street, String city, String state, int zipCode, int aptNumber,
                               Boolean inCityLimits, String POBox, String mailCity, String mailState, int mailZipCode,
                               String month, int day, int year, int homePhone, int workPhone, int DLN) {
        //stores the information in the database in the correct places
    }

    //Login Methods
    //see if a voter's login is valid--use voterRegistered from the registration methods section

    //see if an administrator's login is valid
    public boolean adminLoginValid(String userName, String password) {
        //checks the database for the login information from the admin database files and returns the result
        return false;
    }

    //Ballot Methods
    //Save a Vote to the database -- from Ballot class, needs voter class
    public void saveVote(Voter voter, List candidates, List votes) {
        //the database adds the tally to multiple places, first to the total votes made
        //then to each candidate individually
        //then marks the voter in the database as having voted along with saving the number of votes cast
    }

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

    public int getSSN(String firstName, String lastName, String middleInitial, int ID, int loginType){
        //searches the database for the voter's information and returns the SSN
        //loginTypes:
        //1-DLN
        //2-VRN
        //3-SSN
        return 0;
    }

}
