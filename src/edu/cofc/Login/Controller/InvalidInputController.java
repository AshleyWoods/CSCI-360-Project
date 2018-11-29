package edu.cofc.Login.Controller;

import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InvalidInputController {

    private Main main;
    @FXML
    private Button closeButton;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleCloseButton () {

        Stage popUp = (Stage) closeButton.getScene().getWindow();
        popUp.close();

    }
}
