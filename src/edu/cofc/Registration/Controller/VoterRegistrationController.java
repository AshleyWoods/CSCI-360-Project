package edu.cofc.Registration.Controller;

import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;

public class VoterRegistrationController {

    private Main main;
    public static boolean cancel = true;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleSubmit(){
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
