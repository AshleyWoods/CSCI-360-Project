package edu.cofc.Registration.Controller;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.Vote.Voter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import edu.cofc.DataBase.DatabaseInterface;

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
 
    private DatabaseInterface dbInterface;
    
    private boolean loginValid;
   
 
    
    private int loginType = 4;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleRegistrationInvestigation() {
    	 String ssn = SSN.getText().toString();
        //Check the database to see if the login info is there
       
    	loginValid = Main.getInterface().voterRegistered(ssn,loginType);
    	 
    	System.out.println(loginValid);
        if (loginValid) {
            main.showRegistrationStatusPositivePopUp(); 
        	
        }
        main.showRegistrationStatusNegativePopUp();
    
       
        main.showLogin();
    }
}
