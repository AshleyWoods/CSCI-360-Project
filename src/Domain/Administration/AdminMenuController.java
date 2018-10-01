package Domain.Administration;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;

public class AdminMenuController {
    private Main main;
    public static boolean confirm ;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleOfficialTally() {
        //GET CONFIRMATION THE ADMIN WANTS THIS TALLY FIRST
        main.showOfficialConfirmationPopUp();
        if (!confirm) {return;}
        //MAKE SURE CURRENT ELECTION IS ENDED
        if (main.ElectionRunning = true) {
            main.showNoOfficialTallyPopUp();
            return;
        }
        //get the official tally
        //save the official tally
        //go to official tally page
        //OFFICIAL AND UNOFFICIAL TALLY ARE THE SAME PAGE WITH THE TALLY VALUES ADDED IN DIFFERENT WAYS
        main.showTally();
    }

    @FXML
    public void handleUnofficialTally() {
        //GET CONFIRMATION THE ADMIN WANTS THIS TALLY FIRST
        main.showUnofficialConfirmationPopUp();
        if (!confirm) {return;}
        //get the unofficial tally
        //go to unofficial tally
        //OFFICIAL AND UNOFFICIAL TALLY ARE THE SAME PAGE WITH THE TALLY VALUES ADDED IN DIFFERENT WAYS
        main.showTally();

    }

    @FXML
    public void handleLogout() {
        //logout admin
        main.showLogin();
    }

    @FXML
    public void handleEndElection () {
        //Confirm the action with a pop up
        main.endElectionPopUp();
        if (!confirm) {return;}
        if (main.ElectionRunning = false){
            main.showNoElectionPopUp();
        }
        main.ElectionRunning = false;
    }

    @FXML
    public void handleStartElection() {
        //Confirm the action with a pop up
        main.startElectionPopUp();
        if (!confirm) {return;}
        if (main.ElectionRunning = true){
            main.showElectionRunningPopUp();
        }
        main.ElectionRunning = true;
    }

}
