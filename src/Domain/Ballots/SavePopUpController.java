package Domain.Ballots;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SavePopUpController {
    private Main main;
    @FXML
    private Button menuButton;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleOKClick () {
        Stage popUp = (Stage) menuButton.getScene().getWindow();
        popUp.close();
    }
}
