package edu.cofc.Administration.Controller;

import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;

import java.io.IOException;

public class AdminMenuController {
    private Main main;
    private boolean ElectionRunning;
    public static boolean officialTally;
    public static boolean confirm ;

    public void setMain(Main main, boolean val) {
        this.main = main;
        this.ElectionRunning = val;
    
    }
    @FXML
    private void handleRecount() {
        //GET CONFIRMATION THE ADMIN WANTS THIS RECOUNT FIRST
        main.showRecount();
        if (!confirm) {return;}
        //MAKE SURE OFFICIAL TALLY BEEN DONE
        if (!officialTally) {
            main.showOfficialTallyNeededPopUp();
            return;
        }
        //get the recount tally
        main.getInterface().getRecount();
        //save the recount tally as the new official tally
        main.showTally();
    }

    @FXML
    private void handleDownloadOfficialTally() throws IOException {
        //GET CONFIRMATION THE ADMIN WANTS THIS RECOUNT FIRST
        main.showDownloadOfficialTally();
        if (!confirm) {return;}
        //MAKE SURE OFFICIAL TALLY BEEN DONE
        if (!officialTally) {
            main.showOfficialTallyNeededPopUp();
            return;
        }
        main.getInterface().downloadOfficialTally();
    }

    @FXML
    private void handleOfficialTally() {
        //GET CONFIRMATION THE ADMIN WANTS THIS TALLY FIRST
        main.showOfficialConfirmationPopUp();
        if (!confirm) {return;}
        //MAKE SURE CURRENT ELECTION IS ENDED
        if (ElectionRunning) {
            main.showNoOfficialTallyPopUp();
            return;
        }
        //get the official tally
        main.getInterface().getOfficialTally();
        //save the official tally
        this.officialTally = true;
        //go to official tally page
        //OFFICIAL AND UNOFFICIAL TALLY ARE THE SAME PAGE WITH THE TALLY VALUES ADDED IN DIFFERENT WAYS
        main.showTally();
    }

    @FXML
    private void handleUnofficialTally() {
        //GET CONFIRMATION THE ADMIN WANTS THIS TALLY FIRST
        main.showUnofficialConfirmationPopUp();
        if (!confirm) {return;}
        //get the unofficial tally
        main.getInterface().getUnofficialTally();
        //go to unofficial tally
        //OFFICIAL AND UNOFFICIAL TALLY ARE THE SAME PAGE WITH THE TALLY VALUES ADDED IN DIFFERENT WAYS
        main.showTally();

    }

    @FXML
    private void handleLogout() {
        //logout admin
        main.showLogin();
    }

    @FXML
    private void handleEndElection () {
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
    private void handleStartElection() {
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
