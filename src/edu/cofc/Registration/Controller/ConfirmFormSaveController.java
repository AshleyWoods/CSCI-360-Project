package edu.cofc.Registration.Controller;

import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ConfirmFormSaveController {

    private Main main;
    @FXML
    private Button MenuButton;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleMainMenu(){

       Stage popUp = (Stage) MenuButton.getScene().getWindow();
       popUp.close();

       main.showLogin();
    }

}
