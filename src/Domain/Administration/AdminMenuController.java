package Domain.Administration;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;

public class AdminMenuController {
    private Main main;
    private boolean ElectionRunning;
    public boolean officialTally;
    public static boolean confirm ;

    public void setMain(Main main, boolean val) {
        this.main = main;
        this.ElectionRunning = val;
    ;
    }
    @FXML
    public void handleRecount() {
        //GET CONFIRMATION THE ADMIN WANTS THIS RECOUNT FIRST
        main.showRecount();
        if (!confirm) {return;}
        //MAKE SURE OFFICIAL TALLY BEEN DONE
        if (officialTally) {
            main.showRecount();
            return;
        }
        //get the recount tally
        //save the recount tally
        //official tally true
        main.showTally();
    }

    @FXML
    public void handleOfficialTally() {
        //GET CONFIRMATION THE ADMIN WANTS THIS TALLY FIRST
        main.showOfficialConfirmationPopUp();
        if (!confirm) {return;}
        //MAKE SURE CURRENT ELECTION IS ENDED
        if (ElectionRunning) {
            main.showNoOfficialTallyPopUp();
            return;
        }
        //get the official tally
        //save the official tally
        //official tally true
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
        if (!ElectionRunning){
            main.showNoElectionPopUp();
            return;
        }
        main.ElectionRunning= false;
        this.ElectionRunning = false;
    }

    @FXML
    public void handleStartElection() {
        //Confirm the action with a pop up
        main.startElectionPopUp();
        if (!confirm) {return;}
        if (ElectionRunning){
            main.showElectionRunningPopUp();
            return;
        }
        main.ElectionRunning= true;
        this.ElectionRunning = true;
    }

}
