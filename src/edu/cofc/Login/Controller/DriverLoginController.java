package edu.cofc.Login.Controller;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.Vote.Voter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DriverLoginController {
    private Main main;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField middleInitial;
    @FXML
    private TextField DLN;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleLoginClick() {
        //Check the database to see if teh login info is valid
        boolean loginValid = main.getInterface().voterRegistered(firstName.getText(),lastName.getText(),middleInitial.getText(),Integer.parseInt(DLN.getText()),1);
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, continue to first ballot
        int SSN = main.getInterface().getSSN(firstName.getText(),lastName.getText(),middleInitial.getText(),Integer.parseInt(DLN.getText()),1);
        //main.activeVoter = new Voter(lastName.getText(),firstName.getText(),middleInitial.getText(),SSN);
        main.showBallot();
    }
}
