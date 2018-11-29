package edu.cofc.Administration.Controller;

import edu.cofc.Application.VotingSystem.Main;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NoElectionPopUpController {
    private Main main;
    @FXML
    private Button confirm;
    @FXML

    
    

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
