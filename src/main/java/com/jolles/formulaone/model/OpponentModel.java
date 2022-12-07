package com.jolles.formulaone.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Name - Ethan Jolles
//Professor - Frank Seidel
//Class - CMIS 201 ONL1
//File name - OpponentModel.java

//Represent Opponent AI
@Entity
public class OpponentModel extends RacerModel {

    public OpponentModel() {
        super();
    }

    public OpponentModel(String name, String teamName, int number) {
        super(name, teamName, number);
    }

    public OpponentModel(String name, String teamName, int number, double reliability, double pace, double racecraft) {
        super(name, teamName, number, reliability, pace, racecraft);
    }
}
