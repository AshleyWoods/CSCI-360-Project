package Domain.Administration.Tally;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NoOfficialTallyPopUpController {
    private Main main;
    @FXML
    private Button OKButton;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleOKClick () {
    //close window
        Stage popUp = (Stage) OKButton.getScene().getWindow();
        popUp.close();
    }
}
