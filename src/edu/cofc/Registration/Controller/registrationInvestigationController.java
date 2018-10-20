package edu.cofc.Registration.Controller;

import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;

public class registrationInvestigationController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleRegistrationInvestigation() {
        //Check the database to see if the login info is there
        //if not, give the voter a pop up and don't continue this method
        main.showRegistrationStatusNegativePopUp();
        //if it does work, give a pop up confirming
        main.showRegistrationStatusPositivePopUp();
      main.showLogin();
    }
}
