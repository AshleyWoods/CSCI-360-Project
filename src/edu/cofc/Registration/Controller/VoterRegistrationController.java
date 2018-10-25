package edu.cofc.Registration.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.Vote.Voter;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class VoterRegistrationController {

    private Main main;
    public static boolean cancel = true;
    private Voter voter;
    @FXML
    public CheckBox above18;
    @FXML
    public CheckBox citizen;
    @FXML public TextField firstNameText;
    @FXML public TextField lastNameText;
    @FXML public TextField middleInitialText;
    @FXML public TextField suffixText;
    @FXML public TextField ssnText;
    @FXML public TextField streetText;
    @FXML public TextField cityText;
    @FXML public TextField stateText;
    @FXML public TextField zipText;
    @FXML public TextField aptText;
    @FXML public TextField streetMailingText;
    @FXML public TextField cityMailingText;
    @FXML public TextField stateMailingText;
    @FXML public TextField zipMailingText;
    @FXML public TextField birthdayDateText;
    @FXML public TextField birthdayYearText;
    @FXML public TextField homePhoneText;
    @FXML public TextField workPhoneText;
    @FXML public TextField dlNumberText;
    @FXML public ComboBox<String> sexComboBox;
    @FXML public ComboBox<String> raceComboBox;
    @FXML public ComboBox<String> cityLimitComboBox;
    @FXML public ComboBox<String> birthMonthComboBox;
   


    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleSubmit() throws FileNotFoundException{
       //CHECK VALIDITY OF INPUT IN ALL FIELDS
        //CHECK THE PERSON TO SEE IF THEY'RE ALLOWED TO VOTE?--HOW?
    	
    	//ASK IF THEY MEAN TO SUBMIT
        if (main.showSubmissionConfirmationPopup()) {
            //cancel if they did not
            return;
        }
        
        Main.getInterface().registerVoter(voter);
       //CONFIRM VOTER THAT DATA WAS SAVED
        
        main.showSaveConfirmationPopUp();
       
    }

}
