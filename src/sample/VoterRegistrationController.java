package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VoterRegistrationController {

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleSubmit(){
        //ASK IF THEY MEAN TO SUBMIT
        confirmSubmitPopUp();
       //CHECK VALIDITY OF INPUT IN ALL FIELDS
        //CHECK THE PERSON TO SEE IF THEY'RE ALLOWED TO VOTE?--HOW?
        //SAVE DATA
       //CONFIRM VOTER THAT DATA WAS SAVED
        confirmSavePopUp();

        main.showLogin();
    }

    public void confirmSubmitPopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("ConfirmFormSubmission.fxml"));
            AnchorPane page = (AnchorPane) loader.load();


            Stage confirmSubmit = new Stage();
            confirmSubmit.setTitle("Confirm Form Submission");
            Scene confirmSubmitScene = new Scene(page);
            confirmSubmit.setScene(confirmSubmitScene);

            confirmSubmit.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void confirmSavePopUp() {

        //None of these files currently exist, don't uncomment the lines until they do
         try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("ConfirmFormSave.fxml"));
            AnchorPane page = (AnchorPane) loader.load();


            Stage confirmSave = new Stage();
            confirmSave.setTitle("Form Saved");
            Scene confirmSaveScene = new Scene(page);
            confirmSave.setScene(confirmSaveScene);

            confirmSave.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
