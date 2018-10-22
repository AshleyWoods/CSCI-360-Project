package edu.cofc.Login.Controller;

import edu.cofc.Application.VotingSystem.Main;
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
    String firstName = firstNameText.getText().toString();
    String lastName = lastNameText.getText().toString();
    String middleInitial = middleInitialText.getText().toString();
    String ssn = SSN.getText().toString();

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleLoginClick() {
        //Check the database to see if teh login info is valid
        boolean loginValid = main.getInterface().voterRegistered(ssn, loginType);
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, continue to first ballot
        //main.activeVoter = new Voter(lastName.getText(),firstName.getText(),middleInitial.getText(),Integer.parseInt(SSN.getText()));
        main.showBallot();
    }
}
