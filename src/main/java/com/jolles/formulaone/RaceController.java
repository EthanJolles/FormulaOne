package com.jolles.formulaone;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


//Will eventually house the methods that control the main parts of the game
//NPCs will be generated and the outcome calculations will be done here or referenced here.
public class RaceController {

    public Button backToMainButton;
    public Button raceButton;
    public Button newOpponentButton;
    public Button newDriverButton;

    public Parent root;
    public Stage stage;

    //Simple scene switch back to Main.fxml
    public void switchToMain(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Formula 1");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
