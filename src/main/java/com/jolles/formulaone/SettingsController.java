package com.jolles.formulaone;

//Name - Ethan Jolles
//Professor - Frank Seidel
//Class - CMIS 201 ONL1
//File name - SettingsController.java

import com.jolles.formulaone.model.UserModel;
import com.jolles.formulaone.utils.UserSerialization;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SettingsController {

    public Parent root;
    public Stage stage;

    //Simple redirection to Main.fxml scene.
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

    //Deletes all serialized data
    public void remove(ActionEvent event) {
        UserSerialization.write(new ArrayList<>());
    }

    //Exits the program
    public void exit(ActionEvent event) {
        System.exit(0);
    }
}
