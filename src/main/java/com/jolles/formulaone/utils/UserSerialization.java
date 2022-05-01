package com.jolles.formulaone.utils;

import com.jolles.formulaone.model.UserModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Eventually this class implement use of generics, but for now I only have uses for User persistence so I have
//tightly coupled this class and its methods to the UserModel class to allow for more focus
//on other areas of functionality.
public class UserSerialization {

    private UserSerialization() {

    }

    //If the Users.bin file is empty, it will give errors when trying to read from it
    //This method ensures that the Users.bin file will always contain the ByteStream version of an empty ArrayList
    //If it is completely empty at Runtime.
    public static void ensureMasterFileNotNull() {
        if (new File("src/main/resources/com/jolles/formulaone/users/Users.bin").length() == 0) {
            UserSerialization.write(new ArrayList<UserModel>());
        }
    }

    //Writes the master list back to the Users.bin file.
    public static void write(List<UserModel> u) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(
                            "src/main/resources/com/jolles/formulaone/users/Users.bin"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Objects.requireNonNull(objectOutputStream).writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Should be used to map the master user list to an ArrayList<UserModel> so that you can modify
    //it and then re-save it using .write()
    public static List<UserModel> read() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("src/main/resources/com/jolles/formulaone/users/Users.bin"));
            return (ArrayList<UserModel>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
