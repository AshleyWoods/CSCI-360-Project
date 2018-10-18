package Domain.Administration.Tally;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;

public class TallyController {
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
