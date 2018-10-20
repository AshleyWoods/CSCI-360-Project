package edu.cofc.Administration.Controller;

import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class endElectionPopUpController {
    private Main main;
    @FXML
    private Button confirm;
    @FXML
    private Button cancel;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleConfirm() {
        //continue the operation
        AdminMenuController.confirm = true;
        //close the window
        Stage popUp = (Stage) confirm.getScene().getWindow();
        popUp.close();
    }

    @FXML
    private void handleCancel() {
        //stop the operation
        AdminMenuController.confirm = false;
        //close the window
        Stage popUp = (Stage) cancel.getScene().getWindow();
        popUp.close();
    }
}
