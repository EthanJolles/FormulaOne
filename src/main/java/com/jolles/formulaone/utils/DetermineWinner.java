package com.jolles.formulaone.utils;

import com.jolles.formulaone.model.RacerModel;

import java.util.Random;

public class DetermineWinner {

    private DetermineWinner() {}


    //Resolve a tie between the stats.
    private static int rng() {
        return new Random().nextInt() % 2;
    }

    public static RacerModel race(RacerModel one, RacerModel two) {
        double pointsOne = 0;
        double pointsTwo = 0;

        //Reliability point
        if (one.getReliability() > two.getReliability()) {
            pointsOne+=1;
        } else if (two.getReliability() > one.getReliability()){
            pointsTwo+=1;
        } else {
            if (rng() == 1) {
                pointsOne+=1;
            } else {
                pointsTwo+=1;
            }
        }

        //Pace point
        if (one.getPace() > two.getPace()) {
            pointsOne+=1;
        } else if (two.getPace() > one.getPace()){
            pointsTwo+=1;
        } else {
            if (rng() == 1) {
                pointsOne+=1;
            } else {
                pointsTwo+=1;
            }
        }

        //Racecraft point
        if (one.getRacecraft() > two.getRacecraft()) {
            pointsOne+=1;
        } else if (two.getRacecraft() > one.getRacecraft()){
            pointsTwo+=1;
        } else {
            if (rng() == 1) {
                pointsOne+=1;
            } else {
                pointsTwo+=1;
            }
        }

        //Luck point
        int num = new Random().nextInt() % 2;
        if (num == 1) {
            pointsOne+=1;
        } else {
            pointsTwo+=1;
        }

        //Loop will end once there is at least 1 point difference between the racers
        //It will never allow a tie
        while (true) {
            if (pointsOne > pointsTwo) {
                return one;
            } else if (pointsTwo > pointsOne) {
                return two;
            } else {
                if (rng() == 1) {
                    pointsOne+=1;
                } else {
                    pointsTwo+=1;
                }
            }
        }
    }
}
