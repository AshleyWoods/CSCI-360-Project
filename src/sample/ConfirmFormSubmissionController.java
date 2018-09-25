package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConfirmFormSubmissionController {

    private Main main;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SubmitButton;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleCancelButton(){
        Stage popUp = (Stage) CancelButton.getScene().getWindow();
        popUp.close();
        //Stop the submitting process
        VoterRegistrationController.cancel = true;

    }

    @FXML
    private void handleSubmitButton(){
        Stage popUp = (Stage) SubmitButton.getScene().getWindow();
        popUp.close();
        VoterRegistrationController.cancel = false;
        //program continues as intended, submitting and saving
    }

}
