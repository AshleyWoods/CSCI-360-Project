package edu.cofc.Ballots.View;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.Ballots.Ballot;
import edu.cofc.Ballots.Controller.Ballot1Controller;
import edu.cofc.Ballots.Controller.BallotVoteChoiceConfirmationPopUpController;
import edu.cofc.Ballots.Controller.FinalBallotController;
import edu.cofc.Ballots.Controller.SavePopUpController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class BallotView {

    private BorderPane rootLayout;
    private Main main;
    public static boolean confirm;

    public BallotView(BorderPane boarderPane, Main m){
        rootLayout = boarderPane;
        main = m;
    }

    public void showBallot() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Ballots/View/Ballot1.fxml"));
            AnchorPane page = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(page);

            // Give the controller access to the main app.
            Ballot1Controller controller = loader.getController();
            controller.setMain(main);

            //ADD CSS FILE
            rootLayout.getStylesheets().add
                    (Main.class.getClassLoader().getResource("edu/cofc/View/RootLayout/votingHomepage.css").toExternalForm());
            //END ADD CSS FILE

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFinalBallot() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Ballots/View/FinalBallot.fxml"));
            AnchorPane page = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(page);

            // Give the controller access to the main app.
            FinalBallotController controller = loader.getController();
            controller.setMain(main);

            rootLayout.getStylesheets().add
                    (Main.class.getClassLoader().getResource("edu/cofc/View/RootLayout/votingHomepage.css").toExternalForm());
            //END ADD CSS FILE

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSavePopUp () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Ballots/View/SavePopUp.fxml"));
            AnchorPane page = loader.load();


            Stage confirmSave = new Stage();
            confirmSave.setTitle("Form Saved");
            Scene confirmSaveScene = new Scene(page);
            confirmSave.setScene(confirmSaveScene);

            SavePopUpController controller = loader.getController();
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

    public boolean showBallotVoteChoiceConfirmationPopUp (Ballot ballot) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Ballots/View/BallotVoteChoiceConfirmationPopUp.fxml"));
            AnchorPane page = loader.load();


            Stage confirmSave = new Stage();
            confirmSave.setTitle("Confirm Choice");
            Scene confirmSaveScene = new Scene(page);
            confirmSave.setScene(confirmSaveScene);

            BallotVoteChoiceConfirmationPopUpController controller = loader.getController();
            controller.setMain(main);

            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
                    + "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
                    + "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            confirmSave.setScene(new Scene(layout));





            confirmSave.showAndWait();
            return confirm;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
