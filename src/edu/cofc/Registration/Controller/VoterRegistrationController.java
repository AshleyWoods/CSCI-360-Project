package edu.cofc.Registration.Controller;

import java.io.FileNotFoundException;
import java.util.Random;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.TextfileInterface.TextInterface;
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

    private Random rand = new Random();

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleSubmit() throws FileNotFoundException{
       //CHECK IF THE CHECKBOXES ARE CHECKED
        if (!(above18.isSelected() && citizen.isSelected())){
            return;
        }
    	
    	//ASK IF THEY MEAN TO SUBMIT
        if (main.showSubmissionConfirmationPopup()) {
            //cancel if they did not
            return;
        }
        int voterID = rand.nextInt(100000);
        Voter v = new Voter(firstNameText.getText(), lastNameText.getText(), middleInitialText.getText(), suffixText.getText(),
                sexComboBox.getValue().toString(), raceComboBox.getValue().toString(), ssnText.getText(), streetText.getText(),
                cityText.getText(), stateText.getText(), zipText.getText(), aptText.getText(), cityLimitComboBox.getValue().toString()
                ,streetMailingText.getText(), cityMailingText.getText(), stateMailingText.getText(),
                zipMailingText.getText(), birthdayDateText.getText(), birthMonthComboBox.getValue().toString() ,
                birthdayYearText.getText(), homePhoneText.getText(),
                workPhoneText.getText(), dlNumberText.getText(), voterID);
        TextInterface.getInstance().registerVoter(v);
       //CONFIRM VOTER THAT DATA WAS SAVED
        
        main.showSaveConfirmationPopUp();
       
    }

}
