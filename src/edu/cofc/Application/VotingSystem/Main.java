package edu.cofc.Application.VotingSystem;

import edu.cofc.Administration.Controller.AdminMenuController;
import edu.cofc.Administration.Controller.ElectionRunningPopUpController;
import edu.cofc.Administration.Controller.NoElectionPopUpController;
import edu.cofc.Administration.Controller.Tally.*;
import edu.cofc.Administration.Controller.endElectionPopUpController;
import edu.cofc.Administration.Controller.startElectionPopUpController;
import edu.cofc.Administration.view.AdminTallyView;
import edu.cofc.Application.Election;
import edu.cofc.Ballots.Ballot;
import edu.cofc.Ballots.Controller.Ballot1Controller;
import edu.cofc.Ballots.Controller.FinalBallotController;
import edu.cofc.Ballots.Controller.SavePopUpController;
import edu.cofc.Ballots.View.BallotView;
import edu.cofc.Login.Controller.*;
import edu.cofc.Login.View.LoginView;
import edu.cofc.Registration.Controller.*;
import edu.cofc.Registration.View.RegistrationView;
import edu.cofc.TextfileInterface.TextInterface;
import edu.cofc.Vote.Voter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static edu.cofc.Registration.Controller.VoterRegistrationController.cancel;

public class Main extends Application {

    //This variable will be changed when an operator starts or ends an election
    public  boolean ElectionRunning = false;
    public static Election currentElection;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AdminTallyView adminTallyView;
    private BallotView ballotView;
    private LoginView loginView;
    private RegistrationView registrationView;
    //this variable will be changed when an operator completes an official tally 
    public boolean officialTally = false;
    public static Voter activeVoter;
    public TextInterface textInterface;
  
    
   

    @Override
    public void start(Stage primaryStage) throws Exception{
    

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SC Electronic Voting");
        textInterface = TextInterface.getInstance();
        this.ElectionRunning = false;
        //edu.cofc.Administration.Controller.AdminMenuController.officialTally = false;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("edu/cofc/View/RootLayout/RootLayout.fxml"));
        rootLayout = loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        //ADD CSS FILE
        scene.getStylesheets().add(Main.class.getClassLoader().getResource("edu/cofc/View/RootLayout/votingHomepage.css").toExternalForm());
        //END ADD CSS FILE
        primaryStage.show();
        currentElection = new Election();

        adminTallyView = new AdminTallyView(rootLayout, this);
        ballotView = new BallotView(rootLayout, this);
        loginView = new LoginView(rootLayout, this);
        registrationView = new RegistrationView(rootLayout, this);
        textInterface.registerAdmin();

        showLogin();
    }


    public TextInterface getTextInterfaceInstance() {
        return textInterface;
    }

    public static Election getCurrentElection() {
        return currentElection;
    }

    public void showRecount() {
    	adminTallyView.showRecount();
    }

    public void showInputInvalid() {
        loginView.showInputInvalid();
    }

    public void showRegistrationInvestigation() {
        registrationView.showRegistrationInvestigation();
    }

    public void showDownloadOfficialTally() {
    	adminTallyView.showDownloadOfficialTally();
    }

    public void showDriverLogin () {
        loginView.showDriverLogin();
    }

    public void showSSNLogin () {
        loginView.showSSNLogin();
    }

    public void showVRNLogin () {
      loginView.showVRNLogin();
    }

    public void showAdminLogin () {
        loginView.showAdminLogin();
    }

   //Go to login screen

    public void showLogin(){
       loginView.showLogin();
    }

    public void showAdminMenu(){
        adminTallyView.showAdminMenu();
    }

    public void showTally() {
       adminTallyView.showTally();
    }
    


    //Go to the voter registration page when the 'Register to Vote' button is clicked
    public void showVoterRegistration(){
       registrationView.showVoterRegistration();
    }

    public void showOfficialConfirmationPopUp() {
       adminTallyView.showOfficialConfirmationPopUp();
    }

    public void showUnofficialConfirmationPopUp() {
       adminTallyView.showUnofficialConfirmationPopUp();
    }

    public boolean showSubmissionConfirmationPopup () {
       boolean val = registrationView.showSubmissionConfirmationPopup();
       return val;
    }

    public boolean showBallotVoteChoiceConfirmationPopUp (Ballot ballot) { 
    	
    	return ballotView.showBallotVoteChoiceConfirmationPopUp(ballot);}

    public void showBallot() {
       ballotView.showBallot();
    }

    public void showFinalBallot() {
        ballotView.showFinalBallot();
    }

    public void showSavePopUp () {
        ballotView.showSavePopUp();
    }

    public void showSaveConfirmationPopUp () {
        registrationView.showSaveConfirmationPopUp();
    }

    public void showNoOfficialTallyPopUp() {
        adminTallyView.showNoOfficialTallyPopUp();
    }

    public void showNoElectionPopUp() {
      adminTallyView.showNoElectionPopUp();
    }

    public void showElectionRunningPopUp() {
       adminTallyView.showElectionRunningPopUp();
    }

    public void endElectionPopUp() {
        adminTallyView.endElectionPopUp();
    }

    public void showOfficialTallyNeededPopUp() {
        adminTallyView.showOfficialTallyNeededPopUp();
    }

    public void showRegistrationStatusPositivePopUp() {
        registrationView.showRegistrationStatusPositivePopUp();
    }

    public void showRegistrationStatusNegativePopUp() {
       registrationView.showRegistrationStatusNegativePopUp();
    }

    public void startElectionPopUp() {
        adminTallyView.startElectionPopUp();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
