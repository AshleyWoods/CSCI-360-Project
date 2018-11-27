package edu.cofc.Ballots.Controller;

import edu.cofc.Application.VotingSystem.Main;

import edu.cofc.Ballots.Ballot;
import edu.cofc.Ballots.View.BallotView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BallotVoteChoiceConfirmationPopUpController {
    private Main main;
    
    @FXML
    Label voteChoice1;
    @FXML
    Label voteChoice2;
    @FXML
    Button confirm;
    @FXML
    Button deny;
    Ballot ballot;

    public void setMain(Main main) {
        this.main = main;
    }
    public void set1(String vote1) {
    	voteChoice1.setText(vote1);
    }
    public void set2(String vote2) {
    	voteChoice2.setText(vote2);
    }

    @FXML
    private void handleDenyClick(){
        Stage popUp = (Stage) deny.getScene().getWindow();
        popUp.close();
        BallotView.confirm = false;
    }

    @FXML
    private void handleConfirmClick(){
        Stage popUp = (Stage) confirm.getScene().getWindow();
        popUp.close();
        BallotView.confirm = true;
    }
}
