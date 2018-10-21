package edu.cofc.Login.Controller;

import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AdminLoginController {
    private Main main;
    @FXML
    private TextField userName;
    @FXML
    private TextField passWord;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleLoginClick() {
        //Check the database to see if teh login info is valid
        boolean loginValid = main.getInterface().adminLoginValid(userName.getText(),passWord.getText());
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, continue to Admin Menu
        main.showAdminMenu();
    }
}
