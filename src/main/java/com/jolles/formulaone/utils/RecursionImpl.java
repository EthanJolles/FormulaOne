package com.jolles.formulaone.utils;

public class RecursionImpl {

    public static void recursion(int n) {
        if (n > 1) {
            System.out.println(n);
            recursion(n - 1);
            System.out.println(n);
        }
    }
}
