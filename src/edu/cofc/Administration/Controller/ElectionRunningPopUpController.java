package edu.cofc.Administration.Controller;

import edu.cofc.Administration.Controller.AdminMenuController;
import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ElectionRunningPopUpController {
    private Main main;
    @FXML
    private Button confirm;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleOK() {
        //continue the operation
        AdminMenuController.confirm = true;
        //close the window
        Stage popUp = (Stage) confirm.getScene().getWindow();
        popUp.close();
    }
}
