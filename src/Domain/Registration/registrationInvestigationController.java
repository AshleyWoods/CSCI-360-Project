package Domain.Registration;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;

public class registrationInvestigationController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleRegistrationInvestigation() {
        //Check the database to see if the login info is there
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, give a pop up confirming
      main.showLogin();
    }
}
