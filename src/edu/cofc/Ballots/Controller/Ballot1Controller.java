package edu.cofc.Ballots.Controller;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.Ballots.Ballot;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Ballot1Controller {// This is a CONTROLLER

    private Main main;
    @FXML
    private RadioButton buggsBunny;
    @FXML
    private RadioButton roadRunner;
    @FXML
    private RadioButton daffyDuck;
    @FXML
    private RadioButton wileyECyote;
    @FXML
    private ToggleGroup buttonGroup;
    public static String selected;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleContinueClick(){
        selected = buttonGroup.getSelectedToggle().toString();
        int index = selected.indexOf('\'');
        selected = selected.substring(index+1, selected.length()-1);
        //show next ballot
         main.showFinalBallot();
    }

    @FXML
    private void handleCancelClick() {
        //go back to voter login
        main.activeVoter = null;
        main.showLogin();
        // log out voter
    }

    @FXML
    private void handleBackClick () {
        //go back to login screen
        main.activeVoter = null;
        main.showLogin();
        //log out voter
    }
}
