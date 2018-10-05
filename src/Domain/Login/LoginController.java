package Domain.Login;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class LoginController {

    private Main main;
    private boolean ElectionRunning;
    @FXML
    private ComboBox loginChoice;


    public void setMain(Main main, boolean val) {
        this.main = main;
        this.ElectionRunning = val;
    }

    @FXML
    private void handleRegisterClick(){
        main.showVoterRegistration();
    }


    public void handleRegistrationInvestigation() {
    	main.showRegistrationInvestigation();
    }

    @FXML
    public void handleContinueClick(){

        if (loginChoice.getValue() == null) {return;}
        //THIS LINE CAN THROW A NULL POINTER EXCEPTION IF THE USER DOES NOT PICK AN OPTION, HOW TO FIX?
        if (loginChoice.getValue().equals("Driver's Licence")){
            if (!this.ElectionRunning) {
                main.showNoElectionPopUp();
                return;
            }
            //take them to the drivers licence login
            main.showDriverLogin();
        }
        else if (loginChoice.getValue().equals("Social Security Number")){
            if (!this.ElectionRunning) {
                main.showNoElectionPopUp();
                return;
            }
            //take them to the ssn login
            main.showSSNLogin();
        }
        else if (loginChoice.getValue().equals("Voter Registration Number")){
            if (!this.ElectionRunning) {
                main.showNoElectionPopUp();
                return;
            }
            //take them to the vrn login
            main.showVRNLogin();
        }
        else {
            //take them to the admin login
            main.showAdminLogin();
        }

    }

}
