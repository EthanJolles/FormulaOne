package com.jolles.formulaone.utils;

import com.jolles.formulaone.model.UserModel;

public class ConsoleUtils<T extends UserModel> {

    T t;

    public ConsoleUtils(String name, String teamName, int number) {
        t.setName(name);
        t.setTeamName(teamName);
        t.setNumber(number);
    }

    public void displayToConsole() {
        System.out.println("Your racer's name is " + t.getName() + ", and your racer's team is " + t.getTeamName());
    }

}
