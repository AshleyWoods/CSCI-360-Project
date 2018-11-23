package edu.cofc.Login.Controller;

import java.io.FileNotFoundException;

import edu.cofc.Application.VotingSystem.Main;


import edu.cofc.TextfileInterface.TextInterface;
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
    public void handleLoginClick() throws FileNotFoundException {
        //Check the database to see if the login info is valid
    	  String dlNumber = DLN.getText().toString();
    	  String firstName = firstNameText.getText().toString();
    	  String lastName = lastNameText.getText().toString();
    	  String middleInitial = middleInitialText.getText().toString();

        if (dlNumber.length() > 9 || middleInitial.length() > 1) {
            main.showInputInvalid();
            return;
        }

        boolean loginValid = TextInterface.getInstance().voterRegistered( firstName, lastName, middleInitial, dlNumber, loginType);
        if(!loginValid) {
        	 main.showRegistrationStatusNegativePopUp();
        	main.showLogin();
        }
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, continue to first ballot
        else { 
        	//main.activeVoter = new Voter(firstName,lastName, middleInitial,DLN, 3);
        	main.showBallot();
    }
    }}
