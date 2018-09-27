package Domain.Registration;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VoterRegistrationController {

    private Main main;
    public static boolean cancel = true;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleSubmit(){
        //ASK IF THEY MEAN TO SUBMIT
        if (main.showSubmissionConfirmationPopup()) {
            //cancel if they did not
            return;
        }
       //CHECK VALIDITY OF INPUT IN ALL FIELDS
        //CHECK THE PERSON TO SEE IF THEY'RE ALLOWED TO VOTE?--HOW?
        //SAVE DATA
       //CONFIRM VOTER THAT DATA WAS SAVED
        main.showSaveConfirmationPopUp();
    }

}
