package sample;

import javafx.fxml.FXML;

public class LoginController {

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleRegisterClick(){
        main.showVoterRegistration();
    }
}
