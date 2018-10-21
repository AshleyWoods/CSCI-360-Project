package edu.cofc.Registration.Controller;

import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class registrationInvestigationController {
    private Main main;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField middleInitial;
    @FXML
    private TextField SSN;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleRegistrationInvestigation() {
        //Check the database to see if the login info is there
        boolean loginValid = main.getInterface().voterRegistered(firstName.getText(),lastName.getText(),middleInitial.getText(),Integer.parseInt(SSN.getText()),4);
        //if not, give the voter a pop up and don't continue this method
        main.showRegistrationStatusNegativePopUp();
        //if it does work, give a pop up confirming
        main.showRegistrationStatusPositivePopUp();
      main.showLogin();
    }
}
