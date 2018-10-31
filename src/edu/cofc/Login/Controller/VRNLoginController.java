package edu.cofc.Login.Controller;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.TextfileInterface.TextInterface;
import edu.cofc.Vote.Voter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class VRNLoginController {
    private Main main;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField middleInitialText;
  
    @FXML
    private TextField VRN;
    @FXML
    private TextField DLN;

    
    private Voter voter;
    private TextInterface dbInterface;
    private int loginType = 2;
   
    
    
    
    public void setMain(Main main) {
        this.main = main;
    }
   



	@FXML
    private void handleLoginClick() {
		String firstName = firstNameText.getText().toString();
	    String lastName = lastNameText.getText().toString();
	    String middleInitial = middleInitialText.getText().toString();
	    String dlNumber = DLN.getText().toString();
	
	    //String voterID = dbInterface.getSSN(firstName, lastName, middleInitial,dlNumber, 1);
	   
        //Check the database to see if the login info is valid
       //boolean loginValid = Main.getInterface().voterRegistered(voterID, loginType);
       //if(!loginValid) {
    	 //  main.showRegistrationStatusNegativePopUp();
       //}
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, continue to first ballot
       //else {
        //main.activeVoter = new Voter(lastName.getText(),firstName.getText(),middleInitial.getText(),D1Number,2);
        main.showBallot();
    }
}
