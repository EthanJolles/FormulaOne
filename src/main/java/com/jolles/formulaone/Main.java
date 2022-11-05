package com.jolles.formulaone;

//Name - Ethan Jolles
//Professor - Frank Seidel
//Class - CMIS 201 ONL1
//File name - Main.java

import com.jolles.formulaone.utils.RecursionImpl;
import com.jolles.formulaone.utils.UserSerialization;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
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

        Polygon p = new Polygon();
        p.getPoints().add(4.0);

    }

    public static void main(String[] args) {
        //Method call to make sure our Users.bin file is never empty.
        UserSerialization.ensureMasterFileNotNull();

        RecursionImpl.recursion(10);

        launch();
    }
}