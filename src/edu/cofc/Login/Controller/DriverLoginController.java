package edu.cofc.Login.Controller;

import edu.cofc.Application.VotingSystem.Main;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DriverLoginController {
    private Main main;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField middleInitialText;
    @FXML
    private TextField DLN;

    public int loginType = 1;
  

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleLoginClick() {
        //Check the database to see if the login info is valid
    	  String dlNumber = DLN.getText().toString();
    	  String firstName = firstNameText.getText().toString();
    	  String lastName = lastNameText.getText().toString();
    	  String middleInitial = middleInitialText.getText().toString();
        boolean loginValid = Main.getInterface().voterRegistered( dlNumber, loginType);
        if(!loginValid) {
        	 main.showRegistrationStatusNegativePopUp();
        	
        }
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, continue to first ballot
        else { 
        	//main.activeVoter = new Voter(firstName,lastName, middleInitial,DLN, 3);
        	main.showBallot();
    }
    }}
