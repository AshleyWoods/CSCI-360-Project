package edu.cofc.Registration.Controller;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.TextfileInterface.TextInterface;
import edu.cofc.Vote.Voter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class registrationInvestigationController {
    private Main main;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField middleInitialText;
    @FXML
    private TextField SSN;
    
    private Voter voter;
 
    private TextInterface dbInterface;
    
    private boolean loginValid;
   
 
    
    private int loginType = 4;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleRegistrationInvestigation() {
    	 String ssn = SSN.getText().toString();
        //Check the database to see if the login info is there
       
    	loginValid = TextInterface.getInstance().voterRegistered(ssn,loginType);
    	 
    	System.out.println(loginValid);
        if (loginValid) {
            main.showRegistrationStatusPositivePopUp(); 
        	
        }
        else {
            main.showRegistrationStatusNegativePopUp();
        }
       
        main.showLogin();
    }
}
