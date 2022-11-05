package com.jolles.formulaone.utils;

//Name - Ethan Jolles
//Professor - Frank Seidel
//Class - CMIS 201 ONL1
//File name - OpponentList.java


import com.jolles.formulaone.model.OpponentModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Utility class with a hardcoded list of the 10 AI you can face, without defining their stats
public class OpponentList {
    public static List<OpponentModel> opponentList = new ArrayList<OpponentModel>(Arrays.asList(
        new OpponentModel("Lewis Hamilton", "Mercedes", 44),
        new OpponentModel("Max Verstappen", "Redbull Racing", 1),
        new OpponentModel("Michael Dinan", "Turner Motorsport", 96),
        new OpponentModel("Robby Foley", "Turner Motorsport", 96),
        new OpponentModel("Fernando Alonso", "Renault", 14),
        new OpponentModel("Michael Schumacher", "Scuderia Ferrari", 7),
        new OpponentModel("Sebastian Vettel", "Scuderia Ferrari", 5),
        new OpponentModel("Nico Rosberg", "Mercedes", 6),
        new OpponentModel("Charles Leclerc", "Scuderia Ferrari", 16),
        new OpponentModel("Lando Norris", "McLaren", 4)));
}
