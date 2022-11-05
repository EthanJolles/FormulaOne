package com.jolles.formulaone;

//Name - Ethan Jolles
//Professor - Frank Seidel
//Class - CMIS 201 ONL1
//File name - RaceController.java

import com.jolles.formulaone.model.OpponentModel;
import com.jolles.formulaone.model.RacerModel;
import com.jolles.formulaone.model.UserModel;
import com.jolles.formulaone.utils.DetermineWinner;
import com.jolles.formulaone.utils.OpponentList;
import com.jolles.formulaone.utils.UserSerialization;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


//Will eventually house the methods that control the main parts of the game
//NPCs will be generated and the outcome calculations will be done here or referenced here.

//Major Change #1 is implementing the use of the opponents and adding functionality to the race button and adding a way
//to choose your driver from the list of persisted/serialized drivers.

//Major Change #2 is adding some implementation of stats so that the race winner is not decided by a 50/50
//coin flip.
public class RaceController {

    public Button backToMainButton;
    public Button raceButton;
    public Button newOpponentButton;

    public Parent root;
    public Stage stage;
    public Label opponentLabel;
    public TextField enterDriverField;
    public Button searchDriverButton;
    public Label driverLabel;
    public Label opponentTeam;
    public Label driverTeam;
    public Label driverNumber;
    public Label opponentNumber;
    public Label winnerLabel;

    //Randomize stats between 0/100
    private void calculateStats(RacerModel rm) {
        rm.setPace(new Random().nextInt(99) + 1);
        rm.setRacecraft(new Random().nextInt(99) + 1);
        rm.setReliability(new Random().nextInt(99) + 1);
    }

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

    //Deserialize driver list and find the one you are searching for
    public void searchDriver(ActionEvent event) {
        ArrayList<UserModel> userList = (ArrayList<UserModel>) UserSerialization.read();
        for (UserModel user : userList) {
            if (user.getName().equalsIgnoreCase(enterDriverField.getText())) {
                driverLabel.setText(user.getName());
                driverTeam.setText(user.getTeamName());
                driverNumber.setText(String.valueOf(user.getNumber()));
            }
        }
    }

    //Generate an opponent from the precoded list
    public void generateOpponent(ActionEvent event) {
        List<OpponentModel> opponents = OpponentList.opponentList;
        OpponentModel opponent = opponents.get(new Random().nextInt(9) + 1);
        opponentLabel.setText(opponent.getName());
        opponentTeam.setText(opponent.getTeamName());
        opponentNumber.setText(String.valueOf(opponent.getNumber()));
    }

    //Grab the opponent and user and determine a winner
    public void race(ActionEvent event) {
        OpponentModel opponent = new OpponentModel();
        UserModel user = new UserModel();

        for (OpponentModel om : OpponentList.opponentList) {
            if (om.getName().equalsIgnoreCase(opponentLabel.getText())) {
                opponent = om;
            }
        }

        for (UserModel um : Objects.requireNonNull(UserSerialization.read())) {
            if (um.getName().equalsIgnoreCase(driverLabel.getText())) {
                user = um;
            }
        }

        RacerModel userRacer = new RacerModel(user.getName(), user.getTeamName(), user.getNumber());

        calculateStats(userRacer);
        calculateStats(opponent);

        RacerModel winner = DetermineWinner.race(userRacer, opponent);
        winnerLabel.setText("Winner: " + winner.getName());
    }
}
