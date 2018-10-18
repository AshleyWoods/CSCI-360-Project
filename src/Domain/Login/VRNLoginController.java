package Domain.Login;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;

public class VRNLoginController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleLoginClick() {
        //Check the database to see if teh login info is valid
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, continue to first ballot
        main.showBallot();
    }
}
