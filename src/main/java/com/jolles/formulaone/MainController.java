package com.jolles.formulaone;

//Name - Ethan Jolles
//Professor - Frank Seidel
//Class - CMIS 201 ONL1
//File name - MainController.java

import com.jolles.formulaone.model.UserModel;
import com.jolles.formulaone.utils.UserSerialization;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static java.util.Objects.*;
import static javafx.fxml.FXMLLoader.*;

public class MainController {

    public TextField nameField;
    public TextField teamNameField;
    public TextField numberField;
    public Button submitButton;
    public Label statusLabel;
    public Parent root;
    public Stage stage;

    //Displays 'About' message.
    public void about(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Read Me");
        a.setHeaderText(null);
        a.setGraphic(null);
        a.setContentText(
                """
                Welcome to the Formula 1 Game, Developed by Ethan Jolles for Professor Frank Seidel's CMIS 201 class.
                
                This game allows the user to create racing drivers and pit them against generated NPCs.
                
                As the development process continues, more features will be implemented like customization of your car
                
                and a more graphically pleasing UI.
                """
        );
        a.show();
    }

    //Simple scene redirection to the Drivers.fxml scene.
    public void switchToRace(ActionEvent event) throws IOException {
        try {
            root = load(requireNonNull(getClass().getResource("Race.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Formula 1 - Race");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Simple scene redirection to the Drivers.fxml scene.
    public void switchToDrivers(ActionEvent event) throws IOException {
        try {
            root = load(requireNonNull(getClass().getResource("Drivers.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Formula 1 - Your Drivers");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Simple scene redirection to the Settings.fxml scene.
    public void switchToSettings(ActionEvent event) throws IOException {
        try {
            root = load(requireNonNull(getClass().getResource("Settings.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Formula 1 - Settings");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Deserializes the master racer list and adds your new racer to it, re-serializes the list
    //with the new Object.
    //Also sets the text fields to blank so that you don't accidentally create the same racer 2+ times.
    public void submit(ActionEvent event) {
        try {
            List<UserModel> master = UserSerialization.read();
            master.add(new UserModel(
                    nameField.getText(),
                    teamNameField.getText(),
                    Integer.parseInt(numberField.getText())));
            UserSerialization.write(master);
        } catch (NumberFormatException exc) {
            statusLabel.setText("Enter only numbers, please");
        } catch (Exception exc1) {
            exc1.printStackTrace();
        }
        nameField.setText("");
        teamNameField.setText("");
        numberField.setText("");
    }
}
