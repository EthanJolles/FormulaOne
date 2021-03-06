package com.jolles.formulaone;

import com.jolles.formulaone.utils.UserSerialization;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Formula 1");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //Method call to make sure our Users.bin file is never empty.
        UserSerialization.ensureMasterFileNotNull();
        launch();
    }
}