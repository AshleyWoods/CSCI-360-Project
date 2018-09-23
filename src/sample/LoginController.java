package sample;

import javafx.fxml.FXML;

public class LoginController {

    private Main main;
    boolean RegisterClicked = false;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleRegisterClick(){
        RegisterClicked = true;
        main.showVoterRegistration();
    }
}
