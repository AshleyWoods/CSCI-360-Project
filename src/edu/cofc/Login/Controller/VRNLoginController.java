package edu.cofc.Login.Controller;

import java.io.FileNotFoundException;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.TextfileInterface.TextInterface;
import edu.cofc.Vote.Voter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class VRNLoginController {
    private Main main;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField middleInitialText;
  
    @FXML
    private TextField VRN;

    
    private Voter voter;
    private TextInterface dbInterface;
    private int loginType = 2;
   
    
    
    
    public void setMain(Main main) {
        this.main = main;
    }
   



	@FXML
    private void handleLoginClick() throws FileNotFoundException {
		String firstName = firstNameText.getText().toString();
	    String lastName = lastNameText.getText().toString();
	    String middleInitial = middleInitialText.getText().toString();
	    String vrnNumber = VRN.getText().toString();

        boolean loginValid = TextInterface.getInstance().voterRegistered(vrnNumber , loginType);
        if(!loginValid) {
            main.showRegistrationStatusNegativePopUp();
            main.showLogin();
        }
        //if not, give the voter a pop up (interchangeable between all login screens) and don't continue this method
        //if it does work, continue to first ballot
        else {
            main.showBallot();
            //main.activeVoter = new Voter(lastName.getText(),firstName.getText(),middleInitial.getText(),Integer.parseInt(SSN.getText()));
        }
    }
}
