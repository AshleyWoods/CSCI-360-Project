package edu.cofc.Login.Controller;

import java.io.FileNotFoundException;

import edu.cofc.Application.VotingSystem.Main;


import edu.cofc.TextfileInterface.TextInterface;
import edu.cofc.Vote.Voter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SSNLoginController {
    private Main main;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField middleInitialText;
    @FXML
    private TextField SSN;
  
    private int loginType =3;
   

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleLoginClick() throws FileNotFoundException {
    	 	//String firstName = firstNameText.getText().toString();
    	    //String lastName = lastNameText.getText().toString();
    	    //String middleInitial = middleInitialText.getText().toString();
    	    String ssn = SSN.getText().toString();
    	    String firstName = firstNameText.getText().toString();
    	    String lastName = lastNameText.getText().toString();
    	    String middleInitial = middleInitialText.getText().toString();

        if (ssn.length() > 9 || middleInitialText.getText().toString().length() > 1) {
            main.showInputInvalid();
            return;
        }
        //Check the database to see if the login info is valid
        boolean loginValid = TextInterface.getInstance().voterRegistered(firstName, lastName, middleInitial, ssn, loginType);
        if(!loginValid) {
        	main.showRegistrationStatusNegativePopUp();
        	main.showLogin();
        }
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, continue to first ballot
        else {
        	 main.showBallot();
            main.activeVoter = new Voter(firstName,lastName, middleInitial,ssn, 1);;
        }
        
        
    }
}
