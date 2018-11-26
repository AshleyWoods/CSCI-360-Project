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
    Label buggs;
    @FXML
    Label daffy;
    @FXML
    Label road;
    @FXML
    Label wiley;
    @FXML
    Label peter;
    @FXML
    Label bat;
    @FXML
    Label spider;
    @FXML
    Label bruce;
    @FXML
    Button confirm;
    @FXML
    Button deny;
    Ballot ballot;

    public void setMain(Main main) {
        this.main = main;
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
