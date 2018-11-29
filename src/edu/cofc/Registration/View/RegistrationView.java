package edu.cofc.Registration.View;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.Registration.Controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

import static edu.cofc.Registration.Controller.VoterRegistrationController.cancel;

public class RegistrationView {
    private BorderPane rootLayout;
    private Main main;

    public RegistrationView(BorderPane boarderPane, Main m){
        rootLayout = boarderPane;
        main = m;
    }

    public void showRegistrationInvestigation() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/registrationInvestigation.fxml"));
            AnchorPane page = loader.load();


            rootLayout.setCenter(page);

            registrationInvestigationController controller = loader.getController();
            controller.setMain(main);


        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showVoterRegistration(){
        try{
            if (main.ElectionRunning) {
                FXMLLoader load = new FXMLLoader();
                load.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/NoRegistrationPopUp.fxml"));
                AnchorPane NoVoterRegistration = load.load();

                Stage errorAlert = new Stage();
                errorAlert.setTitle("Invalid Action");
                Scene errorAlertScene = new Scene(NoVoterRegistration);
                errorAlert.setScene(errorAlertScene);

                NoRegistrationPopUpController controller = load.getController();
                controller.setMain(main);

                errorAlert.showAndWait();

                return;
            }

            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/VoterRegistration.fxml"));
            AnchorPane VoterRegistration =  loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(VoterRegistration);

            // Give the controller access to the main app.
            VoterRegistrationController controller = loader.getController();
            controller.setMain(main);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showSubmissionConfirmationPopup () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/ConfirmFormSubmission.fxml"));
            AnchorPane page =  loader.load();


            Stage confirmSubmit = new Stage();
            confirmSubmit.setTitle("Confirm Form Submission");

            ConfirmFormSubmissionController controller = loader.getController();
            controller.setMain(main);

            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
                    + "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
                    + "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            confirmSubmit.setScene(new Scene(layout));

            confirmSubmit.showAndWait();

            return cancel;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showSaveConfirmationPopUp () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/ConfirmFormSave.fxml"));
            AnchorPane page = loader.load();


            Stage confirmSave = new Stage();
            confirmSave.setTitle("Form Saved");
            Scene confirmSaveScene = new Scene(page);
            confirmSave.setScene(confirmSaveScene);


            ConfirmFormSaveController controller = loader.getController();
            controller.setMain(main);

            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
                    + "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
                    + "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            confirmSave.setScene(new Scene(layout));






            confirmSave.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRegistrationStatusPositivePopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/registrationStatusPositivePopUp.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Registration Status");


            registrationStatusPositivePopUpController controller = loader.getController();
            controller.setMain(main);

            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
                    + "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
                    + "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            popUp.setScene(new Scene(layout));

            popUp.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRegistrationStatusNegativePopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/registrationStatusNegativePopUp.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Registration Status");


            registrationStatusNegativePopUpController controller = loader.getController();
            controller.setMain(main);

            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
                    + "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
                    + "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            popUp.setScene(new Scene(layout));

            popUp.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
