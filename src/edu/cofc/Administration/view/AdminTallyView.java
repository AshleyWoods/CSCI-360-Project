package edu.cofc.Administration.view;

import edu.cofc.Administration.Controller.*;

import edu.cofc.Administration.Controller.Tally.*;
import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.TextfileInterface.TextInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminTallyView { //This is a class to show any visuals pertaining to admins or tallies

    private BorderPane rootLayout;
    private Main main;

    public AdminTallyView(BorderPane boarderPane, Main m){
        rootLayout = boarderPane;
        main = m;
    }

    public void showRecount() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/Tally/recountPopUp.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Confirmation");


            recountPopUpController controller = loader.getController();
            controller.setMain(main);

            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
                    + "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
                    + "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            popUp.setScene(new Scene(layout));



            popUp.showAndWait();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showDownloadOfficialTally() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/Tally/downloadOfficialTallyPopUp.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Download Official Tally");


            downloadOfficialTallyPopUpController controller = loader.getController();
            controller.setMain(main);

            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
                    + "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
                    + "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            popUp.setScene(new Scene(layout));



            popUp.showAndWait();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showAdminMenu(){
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/AdminMenu.fxml"));
            AnchorPane AdminMenu =  loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(AdminMenu);

            // Give the controller access to the main app.
            AdminMenuController controller = loader.getController();
            controller.setMain(main, main.ElectionRunning);

            //ADD CSS FILE
            AdminMenu.getStylesheets().add(Main.class.getClassLoader().getResource("edu/cofc/View/RootLayout/votingHomepage.css").toExternalForm());
            //END ADD CSS FILE



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTally() {
        //Text unofficialTally = new Text();
        String buggsBunny;
        String daffyDuck;
        String roadRunner;
        String wileyECoyote; 
        String peterParker;
        String spiderman;
        String batman;
        String bruceWayne;
        TextInterface tInterface = new TextInterface();
        int[] unofficialVotes = tInterface.getUnofficialTally();
        
        buggsBunny = String.valueOf(unofficialVotes[0]);
        roadRunner = String.valueOf(unofficialVotes[1]);
        daffyDuck = String.valueOf(unofficialVotes[2]);
        wileyECoyote = String.valueOf(unofficialVotes[3]);
        peterParker = String.valueOf(unofficialVotes[4]);
        batman = String.valueOf(unofficialVotes[5]);
        spiderman = String.valueOf(unofficialVotes[6]);
        bruceWayne = String.valueOf(unofficialVotes[7]);

    	try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/Tally/Tally.fxml"));
            AnchorPane tally =  loader.load();
    	
            // Set person overview into the center of root layout.
            rootLayout.setCenter(tally);
            // Give the controller access to the main app.
            TallyController controller = loader.getController();
            controller.setMain(main);
            controller.setBuggs(buggsBunny);
            controller.setRoad(roadRunner);
            controller.setDaffy(daffyDuck);
            controller.setWiley(wileyECoyote);
            controller.setPeter(peterParker);
            controller.setBatman(batman);
            controller.setSpiderman(spiderman);
            controller.setBruceWayne(bruceWayne);
       
            //ADD CSS FILE
            rootLayout.getStylesheets().add(Main.class.getClassLoader().getResource("edu/cofc/View/RootLayout/votingHomepage.css").toExternalForm());
            //END ADD CSS FILE
     

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOfficialConfirmationPopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/Tally/officialTallyPopUp.fxml"));
            AnchorPane page = loader.load();


            Stage stage = new Stage();
            stage.setTitle("Confirm Official Tally");
            ;

            officialTallyPopUpController controller = loader.getController();
            controller.setMain(main);

            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
                    + "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
                    + "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            stage.setScene(new Scene(layout));

            stage.showAndWait();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showUnofficialConfirmationPopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/Tally/unofficialTallyPopUp.fxml"));
            AnchorPane page = loader.load();


            Stage stage = new Stage();
            stage.setTitle("Confirm Unofficial Tally");


            unofficialTallyPopUpController controller = loader.getController();
            controller.setMain(main);
            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
                    + "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
                    + "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            stage.setScene(new Scene(layout));

            stage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showNoOfficialTallyPopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/Tally/noOfficialTallyPopUp.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Warning");
            Scene confirmSaveScene = new Scene(page);
            popUp.setScene(confirmSaveScene);

            NoOfficialTallyPopUpController controller = loader.getController();
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

    public void showNoElectionPopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/NoElectionPopUp.fxml"));
            AnchorPane page = loader.load();

            Stage popUp = new Stage();

            popUp.setTitle("Warning");


            NoElectionPopUpController controller = loader.getController();
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

    public void showElectionRunningPopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/ElectionRunningPopUp.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Warning");


            ElectionRunningPopUpController controller = loader.getController();
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

    public void endElectionPopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/endElectionPopUp.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Warning");

            endElectionPopUpController controller = loader.getController();
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

    public void showOfficialTallyNeededPopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/Tally/officialTallyNeededPopUp.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Warning");


            officialTallyNeededPopUpController controller = loader.getController();
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

    public void startElectionPopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Administration/view/startElectionPopUp.fxml"));
            AnchorPane page =  loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Warning");


            startElectionPopUpController controller = loader.getController();
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
