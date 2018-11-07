package edu.cofc.Ballots.Controller;

import java.io.FileNotFoundException;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.Ballots.Ballot;
import edu.cofc.Vote.Vote;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class FinalBallotController {

    private Main main;
    @FXML
    private RadioButton peterParker;
    @FXML
    private RadioButton spiderMan;
    @FXML
    private RadioButton batMan;
    @FXML
    private RadioButton bruceWayne;
    @FXML
    private ToggleGroup buttonGroup;
    private String selected;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleSubmitClick() throws FileNotFoundException{
        selected = buttonGroup.getSelectedToggle().toString();
        int index = selected.indexOf('\'');
        selected = selected.substring(index +1,selected.length()-1);
        Ballot ballot = new Ballot();
        ballot.addVote(new Vote(main.activeVoter,selected));
        ballot.addVote(new Vote(main.activeVoter,Ballot1Controller.selected));
        ballot.submitBallot();
        //save vote
        //make pop up window confirm save
        main.showSavePopUp();
        //return to home screen
        main.activeVoter = null;
        main.showLogin();
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
        //go back to previous ballot
        main.showBallot();
    }
}
