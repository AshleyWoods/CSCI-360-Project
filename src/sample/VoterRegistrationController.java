package sample;

import javafx.fxml.FXML;

public class VoterRegistrationController {

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleSubmit(){
        //ASK IF THEY MEAN TO SUBMIT
       //CHECK VALIDITY OF INPUT IN ALL FIELDS
        //CHECK THE PERSON TO SEE IF THEY'RE ALLOWED TO VOTE?--HOW?
        //SAVE DATA
       //CONFIRM VOTER THAT DATA WAS SAVED
        main.showLogin();
    }
}
