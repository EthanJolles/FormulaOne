package com.jolles.formulaone;

//Name - Ethan Jolles
//Professor - Frank Seidel
//Class - CMIS 201 ONL1
//File name - DriversController.java

import com.jolles.formulaone.model.UserModel;
import com.jolles.formulaone.utils.ManageUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//Controls the components in the Drivers.fxml scene.
//Currently only functionality is the button to return to the main window
//There will be functionality implemented to update and delete, as well as set as active
//Whichever driver you want to be racing with under the Race.fxml scene.
public class DriversController {

    public Parent root;
    public Stage stage;
    public Label listDriverLabel;

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

    public void listDrivers(ActionEvent event) {
        try {
            ManageUser service = new ManageUser();
            StringBuilder sb = new StringBuilder();
            List<UserModel> userModel = service.getUsers();
            for (UserModel user : Objects.requireNonNull(userModel)) {
                sb.append(user.getName())
                        .append(" ")
                        .append(user.getTeamName())
                        .append(" ")
                        .append(user.getNumber())
                        .append("\n");
            }
            listDriverLabel.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
