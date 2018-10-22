package edu.cofc.Login.Controller;

import edu.cofc.DataBase.DatabaseInterface;
import edu.cofc.Application.VotingSystem.Main;
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
    private Voter voter;
    private DatabaseInterface dbInterface;
    private int loginType = 2;
    private int voterID = dbInterface.getVRN(voter.getFirstName(), voter.getLastName(), voter.getMiddleInitial(), voter.getSSN());
    private String voterIDString = String.valueOf(voterID);
    String firstName = firstNameText.getText().toString();
    String lastName = lastNameText.getText().toString();
    String middleInitial = middleInitialText.getText().toString();
    
    public void setMain(Main main) {
        this.main = main;
    }
   



	@FXML
    private void handleLoginClick() {
        //Check the database to see if teh login info is valid
       boolean loginValid = main.getInterface().voterRegistered(voterIDString, loginType);
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, continue to first ballot
       String SSN = main.getInterface().getSSN(firstName,lastName,middleInitial,voterIDString, loginType);
        //main.activeVoter = new Voter(lastName.getText(),firstName.getText(),middleInitial.getText(),SSN);
        main.showBallot();
    }
}
