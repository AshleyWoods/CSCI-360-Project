package Domain.Ballots;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;

public class FinalBallotController {

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleSubmitClick(){
        //save vote
        //make pop up window confirm save
        main.showSavePopUp();
        //return to home screen
        main.showLogin();
    }

    @FXML
    private void handleCancelClick() {
        //go back to voter login
        main.showLogin();
        // log out voter
    }

    @FXML
    private void handleBackClick () {
        //go back to previous ballot
        main.showBallot();
    }
}
