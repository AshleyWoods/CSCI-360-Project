package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class NoRegistrationPopUpController {

    private Main main;
    @FXML
    private Button menuButton;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleMenuButton () {

            Stage popUp = (Stage) menuButton.getScene().getWindow();
            popUp.close();

    }
}
