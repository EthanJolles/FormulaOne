package com.jolles.formulaone.model;

//Name - Ethan Jolles
//Professor - Frank Seidel
//Class - CMIS 201 ONL1
//File name - RacerModel.java

//This class will be used to house more comprehensive information about Users, their stats and records
public class RacerModel extends UserModel {

    public RacerModel() {
        super();
    }

    public RacerModel(String name, String teamName, int number, double reliability, double pace, double racecraft) {
        super(name, teamName, number);
        this.reliability = reliability;
        this.pace = pace;
        this.racecraft = racecraft;
    }

    public RacerModel(String name, String teamName, int number) {
        super(name, teamName, number);
    }

    private double reliability;
    private double pace;
    private double racecraft;
    private int wins;
    private int losses;


    public double getReliability() {
        return reliability;
    }

    public void setReliability(double reliability) {
        this.reliability = reliability;
    }

    public double getPace() {
        return pace;
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

    public double getRacecraft() {
        return racecraft;
    }

    public void setRacecraft(double racecraft) {
        this.racecraft = racecraft;
    }

    public int getWins() {
        return this.wins;
    }

    //I do not think the setLosses() and setWins() methods will be used in the context of the application,
    //but I have included them for the sake of consistency.
    //Marked as Deprecated to warn against use.
    @Deprecated
    public void setWins(int wins) {
        this.wins = wins;
    }


    public int getLosses() {
        return this.losses;
    }

    //I do not think the setLosses() and setWins() methods will be used in the context of the application,
    //but I have included them for the sake of consistency.
    //Marked as Deprecated to warn against use.
    @Deprecated
    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void addWin() {
        wins+=1;
    }

    public void addLoss() {
        losses+=1;
    }

    @Override
    public String toString() {
        return "RacerModel{" +
                "reliability=" + reliability +
                ", pace=" + pace +
                ", racecraft=" + racecraft +
                '}';
    }
}

