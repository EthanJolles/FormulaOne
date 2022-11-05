package com.jolles.formulaone.model;

//Name - Ethan Jolles
//Professor - Frank Seidel
//Class - CMIS 201 ONL1
//File name - UserModel.java

import java.io.Serializable;
import java.util.Objects;


//As the class name suggests, a model object of a User, should be used to represent individual Racers that a player will
//create during their time playing the game.
public class UserModel implements Serializable {

    public UserModel() {
    }

    public UserModel(String name, String teamName, int number) {
        this.name = name;
        this.teamName = teamName;
        this.number = number;
    }

    private String name;
    private String teamName;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return number == userModel.number && name.equals(userModel.name) && teamName.equals(userModel.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teamName, number);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                ", name='" + name + '\'' +
                ", teamName='" + teamName + '\'' +
                ", number=" + number +
                '}';
    }
}
