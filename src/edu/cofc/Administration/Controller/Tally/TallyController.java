package edu.cofc.Administration.Controller.Tally;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.TextfileInterface.TextInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class TallyController {// This is a CONTROLLER
    private Main main;
    

  
    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    Label buggs;
    @FXML 
    Label daffy; 
    @FXML 
    Label road;
    @FXML 
    Label wiley; 
    @FXML 
    Label peter;
    @FXML 
    Label bat;
    @FXML 
    Label spider;
    @FXML
    Label bruce;
    public void setBuggs(String buggsBunny) {
    	buggs.setText(buggsBunny);
    }
    public void setRoad(String roadRunner) {
    	road.setText(roadRunner);
    }
    public void setDaffy(String daffyDuck) {
    	daffy.setText(daffyDuck);
    }
    public void setWiley(String wileyCoyote) {
    	wiley.setText(wileyCoyote);
    }
    public void setPeter(String peterParker) {
    	peter.setText(peterParker);
    }
    public void setBatman(String batman) {
    	bat.setText(batman);
    }
    public void setSpiderman(String spiderman) {
    	spider.setText(spiderman);
    }
    public void setBruceWayne(String bruceWayne) {
    	bruce.setText(bruceWayne);
    }
    @FXML
    private void handleLogout() {
        //logout admin
        main.showLogin();
    }

    @FXML
    private void handleBack() {
        //return to admin menu
        main.showAdminMenu();
    }
}
