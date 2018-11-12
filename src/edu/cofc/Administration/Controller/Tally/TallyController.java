package edu.cofc.Administration.Controller.Tally;

import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;

public class TallyController {// This is a CONTROLLER
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleLogout() {
        //logout admin
        main.showLogin();
    }

    @FXML
    private void handleBack() {
        //return to admin menu
        main.showAdminMenu();
    }
}
