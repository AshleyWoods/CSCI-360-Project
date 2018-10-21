package edu.cofc.Registration.Controller;

import edu.cofc.Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class VoterRegistrationController {

    private Main main;
    public static boolean cancel = true;
    @FXML
    public CheckBox above18;
    @FXML
    public CheckBox citizen;
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public TextField middleInitial;
    @FXML
    public TextField suffix;
    @FXML
    public ComboBox sex;
    @FXML
    public ComboBox race;
    @FXML
    public TextField SSN;
    @FXML
    public TextField street;
    @FXML
    public TextField city;
    @FXML
    public TextField state;
    @FXML
    public TextField zipCode;
    @FXML
    public TextField aptNumber;
    @FXML
    public ComboBox cityLimits;
    @FXML
    public TextField mailStreet;
    @FXML
    public TextField mailCity;
    @FXML
    public TextField mailState;
    @FXML
    public TextField mailZipCode;
    @FXML
    public ComboBox birthdayMonth;
    @FXML
    public TextField day;
    @FXML
    public TextField year;
    @FXML
    public TextField homePhone;
    @FXML
    public TextField workPhone;
    @FXML
    public TextField DLN;


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
        //CITY LIMITS NEEDS HELP!
        main.getInterface().registerVoter(firstName.getText(), lastName.getText(), middleInitial.getText(),suffix.getText(),
                sex.getSelectionModel().getSelectedItem().toString(), race.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(SSN.getText()), street.getText(), city.getText(),
                state.getText(), Integer.parseInt(zipCode.getText()), Integer.parseInt(aptNumber.getText()), true, mailStreet.getText(),
                mailCity.getText(), mailState.getText(), Integer.parseInt(mailZipCode.getText()), birthdayMonth.getSelectionModel().getSelectedItem().toString(),
                Integer.parseInt(day.getText()), Integer.parseInt(year.getText()), Integer.parseInt(homePhone.getText()),
                Integer.parseInt(workPhone.getText()), Integer.parseInt(DLN.getText()));
       //CONFIRM VOTER THAT DATA WAS SAVED
        main.showSaveConfirmationPopUp();
    }

}
